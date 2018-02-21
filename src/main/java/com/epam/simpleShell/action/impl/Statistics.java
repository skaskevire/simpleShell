package com.epam.simpleShell.action.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.simpleShell.action.ActionEnum;
import com.epam.simpleShell.navigation.Cursor;
import com.epam.simpleShell.util.InvocationCounter;

@Component("statistics")
public class Statistics extends DefaultAction {
	private InvocationCounter counter;

	public Statistics(Cursor cursor, InvocationCounter counter) {
		super(cursor);
		this.counter = counter;
	}

	@Override
	public void execute(List<String> args) {
		for (ActionEnum action : ActionEnum.values()) {
			System.out.println(
					action.getName()
					+ " "
					+ counter.getSuccessCount(action) 
					+ ":"
					+ counter.getFailureCount(action));
		}

	}

}
