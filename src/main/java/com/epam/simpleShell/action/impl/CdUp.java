package com.epam.simpleShell.action.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.simpleShell.exception.InvalidInputException;
import com.epam.simpleShell.navigation.Cursor;

@Component("cdUp")
public class CdUp extends DefaultAction{

	public CdUp(Cursor cursor) {
		super(cursor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(List<String> args) throws InvalidInputException {
		String pathToPosition = (new StringBuilder(cursor.getPathToPosition())).append("\\").append(args.get(0)).toString();
		if (Files.exists(Paths.get(pathToPosition))) {
			if (Files.isDirectory(Paths.get(pathToPosition))) {
				cursor.setPathToPosition(
						(new StringBuilder(cursor.getPathToPosition())).append("\\").append(args.get(0)).toString());
			} else {
				throw new InvalidInputException("Destination is not a directory");
			}
		} else {
			throw new InvalidInputException("Destination is not exists");
		}		
	}
}
