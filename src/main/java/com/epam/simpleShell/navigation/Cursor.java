package com.epam.simpleShell.navigation;

import org.springframework.stereotype.Component;

@Component("cursor")
public class Cursor {
	private boolean running;
	public static final String HIDDEN_PATH_SIGN = "$";
	private String displayPath;
	private String pathToPosition;
	private boolean isCwd;

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public boolean isCwd() {
		return isCwd;
	}

	public void setCwd(boolean isCwd) {
		this.isCwd = isCwd;
	}

	public Cursor() {
		pathToPosition = System.getProperty("user.dir");
		displayPath = HIDDEN_PATH_SIGN;
		running = true;
	}

	public String getPathToPosition() {
		return pathToPosition;
	}

	public void setPathToPosition(String pathToPosition) {
		this.pathToPosition = pathToPosition;
	}

	public String getDisplayPath() {
		if (isCwd) {
			return pathToPosition;
		} else {
			return displayPath;
		}
	}

	public void setDisplayPath(String displayPath) {
		this.displayPath = displayPath;
	}
}
