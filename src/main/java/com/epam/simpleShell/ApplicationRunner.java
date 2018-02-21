package com.epam.simpleShell;

import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.simpleShell.invoker.Invoker;
import com.epam.simpleShell.navigation.Cursor;
import com.epam.simpleShell.util.ActionParser;

@Component("applicationRunner")
public class ApplicationRunner {
	private static final String CURSOR_PATTERN = "%s>";
	private Cursor cursor;
	private Invoker invoker;
	Scanner scanner;
	private ActionParser actionParser = new ActionParser();

	@PostConstruct
	public void doInit()
	{
		scanner = new Scanner(System.in);
		
	}

	@Autowired
	public ApplicationRunner(Cursor cursor, Invoker invoker)
	{
		this.cursor = cursor;
		this.invoker = invoker;
	}
	public void run()
	{
		do
		{
			System.out.print(String.format(CURSOR_PATTERN, cursor.getDisplayPath()));
			String input = scanner.nextLine();
			Command command = actionParser.extractCommand(input);
			Response response = invoker.executeAction(command.getName(), command.getArgs());
			if(response.isContainsError())
			{
				System.out.println(response.getErrorMessage());
			}
		} while(cursor.isRunning());
		
		

	}

	@PreDestroy
	public void doAfter()
	{
		scanner.close();
	}
}
