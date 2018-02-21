package com.epam.simpleShell;

import java.util.ArrayList;
import java.util.List;

import com.epam.simpleShell.action.ActionEnum;

public class Command
{
	public Command(ActionEnum name, List<String> args) {
		super();
		this.name = name;
		this.args = args;
	}
	private ActionEnum name;
	private List<String> args = new ArrayList<>();
	public List<String> getArgs() {
		return args;
	}
	public ActionEnum getName() {
		return name;
	}
}