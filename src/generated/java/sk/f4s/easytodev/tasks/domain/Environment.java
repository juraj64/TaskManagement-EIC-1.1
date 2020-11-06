package sk.f4s.easytodev.tasks.domain;

import java.io.Serializable;

/**
 * Enum for Environment
 */
public enum Environment implements Serializable {
	DEV, TEST, RUT;

	/**
	 */
	private Environment() {
	}

	public String getName() {
		return name();
	}
}
