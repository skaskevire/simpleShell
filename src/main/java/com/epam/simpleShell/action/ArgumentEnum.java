package com.epam.simpleShell.action;

public enum ArgumentEnum {
	CWD("cwd"), CD_DOWN(".."), CWD_RESET("reset");
	String name;

	ArgumentEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static ArgumentEnum getByName(String name) {
		for (ArgumentEnum action : ArgumentEnum.values()) {
			if (action.getName().equals(name)) {
				return action;
			}
		}

		return null;
	}
}
