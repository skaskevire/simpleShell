package com.epam.simpleShell.action.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.simpleShell.exception.InvalidInputException;
import com.epam.simpleShell.navigation.Cursor;

@Component("dir")
public class Dir extends DefaultAction{

	public Dir(Cursor cursor) {
		super(cursor);
	}

	@Override
	public void execute(List<String> args) throws InvalidInputException {
		if(args.size() > 0)
		{
			throw new InvalidInputException("Invalid argument number");
		}
		File f = new File(cursor.getPathToPosition());
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					System.out.println("DIR   " + files[i].getName());
				} else {
					System.out.println("FILE   " + files[i].getName());
				}
			}
		} else {
			throw new InvalidInputException(cursor.getPathToPosition() + "is not directory");
		}		
	}

}
