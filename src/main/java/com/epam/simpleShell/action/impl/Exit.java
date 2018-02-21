package com.epam.simpleShell.action.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.simpleShell.navigation.Cursor;

@Component("exit")
public class Exit extends DefaultAction{

	public Exit(Cursor cursor) {
		super(cursor);
	}

	@Override
	public void execute(List<String> args) {
		cursor.setRunning(false);		
	}

}
