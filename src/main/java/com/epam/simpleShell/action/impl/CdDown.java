package com.epam.simpleShell.action.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.simpleShell.navigation.Cursor;

@Component("cdDown")
public class CdDown extends DefaultAction{

	public CdDown(Cursor cursor) {
		super(cursor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(List<String> args) {
		cursor.setPathToPosition(cursor.getPathToPosition().substring(0, cursor.getPathToPosition().lastIndexOf("\\")));
	}

}
