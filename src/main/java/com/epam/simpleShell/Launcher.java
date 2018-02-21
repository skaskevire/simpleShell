package com.epam.simpleShell;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Application entry point.
 * Handles imput from consiole.
 * 
 * @author Raman_Skaskevich
 */
public class Launcher {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.epam.simpleShell");
		ctx.refresh();

		ApplicationRunner runner = ctx.getBean("applicationRunner", ApplicationRunner.class);
		runner.run();

		ctx.close();
	}
}
