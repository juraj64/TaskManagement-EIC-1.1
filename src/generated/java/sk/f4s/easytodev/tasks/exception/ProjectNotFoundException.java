package sk.f4s.easytodev.tasks.exception;

import org.sculptor.framework.errorhandling.ApplicationException;

public class ProjectNotFoundException extends ApplicationException {
	private static final long serialVersionUID = 1L;
	private static final String CLASS_NAME = ProjectNotFoundException.class.getSimpleName();
	private static final String CLASS_FULL_NAME = ProjectNotFoundException.class.getName();

	public ProjectNotFoundException(String m, java.io.Serializable... messageParameter) {
		super(CLASS_FULL_NAME, m);
		setMessageParameters(messageParameter);
	}

	public ProjectNotFoundException(int errorCode, String m, java.io.Serializable... messageParameter) {
		super(String.format("%1$s-%3$04d", CLASS_FULL_NAME, CLASS_NAME, errorCode), m);
		setMessageParameters(messageParameter);
	}
}
