package com.epam.simpleShell.action.impl;

import java.util.List;

import com.epam.simpleShell.exception.InternalException;
import com.epam.simpleShell.navigation.Cursor;

public abstract class DefaultAction{

	protected Cursor cursor;

	public DefaultAction(Cursor cursor) {
		super();
		this.cursor = cursor;
	}
	
	public abstract void execute(List<String> args) throws InternalException;
}
