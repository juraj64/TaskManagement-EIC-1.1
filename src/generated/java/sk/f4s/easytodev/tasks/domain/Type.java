package sk.f4s.easytodev.tasks.domain;

import java.io.Serializable;

/**
 * Enum for Type
 */
public enum Type implements Serializable {
	NewFunction, ChangeRequest, Bug, Other;

	/**
	 */
	private Type() {
	}

	public String getName() {
		return name();
	}
}
