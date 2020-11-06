package sk.f4s.easytodev.tasks.domain;

import java.io.Serializable;

/**
 * Enum for TaskStatus
 */
public enum TaskStatus implements Serializable {
	Created, Returned, Accepted, Resolved;

	/**
	 */
	private TaskStatus() {
	}

	public String getName() {
		return name();
	}
}
