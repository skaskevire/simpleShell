package com.epam.simpleShell.action;

public enum ActionEnum {
	CD("cd"), DIR("dir"), EXIT("exit"), TREE("tree"), PROMPT("prompt"), STATISTICS("statistics");
	String name;

	ActionEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static ActionEnum getByName(String name) {
		for (ActionEnum action : ActionEnum.values()) {
			if (action.getName().equals(name)) {
				return action;
			}
		}

		return null;
	}
}
