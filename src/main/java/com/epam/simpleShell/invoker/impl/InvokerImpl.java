package com.epam.simpleShell.invoker.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.simpleShell.Response;
import com.epam.simpleShell.action.ActionEnum;
import com.epam.simpleShell.action.impl.DefaultAction;
import com.epam.simpleShell.exception.InternalException;
import com.epam.simpleShell.invoker.Invoker;
import com.epam.simpleShell.util.InvocationCounter;

@Component("invoker")
public class InvokerImpl implements Invoker {
	private Map<String, DefaultAction> handledActions;
	private InvocationCounter counter;
	
	@Autowired
	public InvokerImpl(Map<String, DefaultAction> handledActions, InvocationCounter counter) {
		this.handledActions = handledActions;
		this.counter = counter;
	}

	@Override
	public Response executeAction(ActionEnum action, List<String> args) {
		try {
			if(action == null)
			{
				throw new InternalException("Invalid input");
			}
			handledActions.get(action.getName()).execute(args);
			counter.incrementSuccessCount(action);
			return new Response(null, false, null);
		} catch (InternalException e) {			
			counter.incrementFailureCount(action);
			return new Response(null, true, e.getMessage());
		}
	}
}
