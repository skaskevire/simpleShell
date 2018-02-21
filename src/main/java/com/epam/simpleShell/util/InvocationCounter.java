package com.epam.simpleShell.util;

import java.util.EnumMap;

import org.springframework.stereotype.Component;

import com.epam.simpleShell.action.ActionEnum;

@Component("counter")
public class InvocationCounter {
	private EnumMap<ActionEnum, Invocation> counter = new EnumMap<>(ActionEnum.class);

	public void incrementSuccessCount(ActionEnum action) {
		if (action != null) {
			Invocation invocation = counter.get(action);
			if (invocation == null) {
				invocation = new Invocation();
				counter.put(action, invocation);
			}

			invocation.incrementSuccess();
		}
	}

	public void incrementFailureCount(ActionEnum action) {
		if(action != null)
		{
			Invocation invocation = counter.get(action);
			if (invocation == null) {
				invocation = new Invocation();
				counter.put(action, invocation);
			}

			invocation.incrementFailure();
		}
	}

	public Integer getSuccessCount(ActionEnum action) {
		Invocation invocation = counter.get(action);
		return invocation == null ? 0 : invocation.getSuccess();
	}

	public Integer getFailureCount(ActionEnum action) {
		Invocation invocation = counter.get(action);
		return invocation == null ? 0 : invocation.getFailure();
	}

	private class Invocation {
		int success;
		int failure;

		public int getFailure() {
			return failure;
		}

		public int getSuccess() {
			return success;
		}

		public void incrementSuccess() {
			success++;
		}

		public void incrementFailure() {
			failure++;
		}
	}
}
