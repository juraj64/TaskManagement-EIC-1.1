package sk.f4s.easytodev.tasks.domain;

import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;
import sk.f4s.easytodev.tasks.domain.EndUserProperties.EndUserProperty;
import sk.f4s.easytodev.tasks.domain.TaskProperties.TaskProperty;
import sk.f4s.easytodev.tasks.domain.TimeLine;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link sk.f4s.easytodev.tasks.domain.TimeLine}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class TimeLineProperties {

	private TimeLineProperties() {
	}

	private static final TimeLinePropertiesImpl<TimeLine> sharedInstance = new TimeLinePropertiesImpl<TimeLine>(TimeLine.class);

	public static Property<TimeLine> id() {
		return sharedInstance.id();
	}

	public static Property<TimeLine> date() {
		return sharedInstance.date();
	}

	public static Property<TimeLine> label() {
		return sharedInstance.label();
	}

	public static Property<TimeLine> personId() {
		return sharedInstance.personId();
	}

	public static Property<TimeLine> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<TimeLine> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<TimeLine> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<TimeLine> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<TimeLine> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<TimeLine> version() {
		return sharedInstance.version();
	}

	public static EndUserProperty<TimeLine> person() {
		return sharedInstance.person();
	}

	public static TaskProperty<TimeLine> task() {
		return sharedInstance.task();
	}

	/**
	 * This class is used for references to {@link sk.f4s.easytodev.tasks.domain.TimeLine}, i.e. nested property.
	 */
	public static class TimeLineProperty<T> extends TimeLinePropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public TimeLineProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class TimeLinePropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		TimeLinePropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		TimeLinePropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
		}

		public Property<T> date() {
			return new LeafProperty<T>(getParentPath(), "date", false, owningClass);
		}

		public Property<T> label() {
			return new LeafProperty<T>(getParentPath(), "label", false, owningClass);
		}

		public Property<T> personId() {
			return new LeafProperty<T>(getParentPath(), "personId", false, owningClass);
		}

		public Property<T> uuid() {
			return new LeafProperty<T>(getParentPath(), "uuid", false, owningClass);
		}

		public Property<T> createdDate() {
			return new LeafProperty<T>(getParentPath(), "createdDate", false, owningClass);
		}

		public Property<T> createdBy() {
			return new LeafProperty<T>(getParentPath(), "createdBy", false, owningClass);
		}

		public Property<T> lastUpdated() {
			return new LeafProperty<T>(getParentPath(), "lastUpdated", false, owningClass);
		}

		public Property<T> lastUpdatedBy() {
			return new LeafProperty<T>(getParentPath(), "lastUpdatedBy", false, owningClass);
		}

		public Property<T> version() {
			return new LeafProperty<T>(getParentPath(), "version", false, owningClass);
		}

		public EndUserProperty<T> person() {
			return new EndUserProperty<T>(getParentPath(), "person", owningClass);
		}

		public TaskProperty<T> task() {
			return new TaskProperty<T>(getParentPath(), "task", owningClass);
		}
	}
}
