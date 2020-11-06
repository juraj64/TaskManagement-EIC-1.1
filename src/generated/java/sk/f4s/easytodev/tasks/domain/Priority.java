package sk.f4s.easytodev.tasks.domain;

import java.io.Serializable;

/**
 * Enum for Priority
 */
public enum Priority implements Serializable {
	Urgent, High, Medium, Low;

	/**
	 */
	private Priority() {
	}

	public String getName() {
		return name();
	}
}
