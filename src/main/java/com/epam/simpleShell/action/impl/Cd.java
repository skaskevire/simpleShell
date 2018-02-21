package com.epam.simpleShell.action.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.simpleShell.action.ArgumentEnum;
import com.epam.simpleShell.exception.InternalException;
import com.epam.simpleShell.exception.InvalidInputException;
import com.epam.simpleShell.navigation.Cursor;

@Component("cd")
public class Cd extends DefaultAction{
	
	private DefaultAction cdDownAction;

	private DefaultAction cdUpAction;

	@Autowired
	public Cd(Cursor cursor, DefaultAction cdUp , DefaultAction cdDown) {
		super(cursor);
		this.cdDownAction = cdDown;
		this.cdUpAction = cdUp;
	}

	@Override
	public void execute(List<String> args) throws InternalException {
		if(args.size()!=1)
		{
			throw new InvalidInputException("Invalid number of arguments");
		}
		if(ArgumentEnum.CD_DOWN.getName().equals(args.get(0)))
		{
			cdDownAction.execute(null);
		}
		else
		{
			cdUpAction.execute(args);
		}		
	}

}
