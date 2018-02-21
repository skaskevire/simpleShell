package com.epam.simpleShell.invoker;

import java.util.List;

import com.epam.simpleShell.Response;
import com.epam.simpleShell.action.ActionEnum;

public interface Invoker {
	public Response executeAction(ActionEnum action, List<String> args);
}
