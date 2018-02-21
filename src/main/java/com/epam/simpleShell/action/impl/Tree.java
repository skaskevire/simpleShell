package com.epam.simpleShell.action.impl;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.simpleShell.exception.InvalidInputException;
import com.epam.simpleShell.navigation.Cursor;

@Component("tree")
public class Tree extends DefaultAction {

	public Tree(Cursor cursor) {
		super(cursor);
	}

	@Override
	public void execute(List<String> args) throws InvalidInputException {
		File f = new File(cursor.getPathToPosition());
		treeStructurePrint(f, "");

	}

	private void treeStructurePrint(File f, String printPrefix) throws InvalidInputException {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					System.out.println(printPrefix + files[i].getName());
					treeStructurePrint(files[i], printPrefix + "-");

				} else {
					System.out.println(printPrefix + files[i].getName());
				}
			}
		} else {
			throw new InvalidInputException(cursor.getPathToPosition() + "is not directory");
		}
	}

}
