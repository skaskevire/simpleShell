package com.epam.simpleShell.action.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.simpleShell.action.ArgumentEnum;
import com.epam.simpleShell.exception.InvalidInputException;
import com.epam.simpleShell.navigation.Cursor;

@Component("prompt")
public class Prompt extends DefaultAction{

	public Prompt(Cursor cursor) {
		super(cursor);
	}

	@Override
	public void execute(List<String> args) throws InvalidInputException {
		if(args.size()!=1)
		{
			throw new InvalidInputException("Invalid number of arguments");
		}
		if(ArgumentEnum.CWD.getName().equals(args.get(0)))
		{
			cursor.setCwd(true);
			return;
		}
		if(ArgumentEnum.CWD_RESET.getName().equals(args.get(0)))
		{
			cursor.setCwd(false);
			cursor.setDisplayPath(Cursor.HIDDEN_PATH_SIGN);
			return;
		}
		cursor.setDisplayPath(args.get(0));
		cursor.setCwd(false);
	}
}
