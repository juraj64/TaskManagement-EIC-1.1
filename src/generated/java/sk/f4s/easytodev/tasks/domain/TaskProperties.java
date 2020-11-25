package sk.f4s.easytodev.tasks.domain;

import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;
import sk.f4s.easytodev.tasks.domain.CommunicationProperties.CommunicationProperty;
import sk.f4s.easytodev.tasks.domain.EndUserProperties.EndUserProperty;
import sk.f4s.easytodev.tasks.domain.ProjectProperties.ProjectProperty;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.domain.TimeLineProperties.TimeLineProperty;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link sk.f4s.easytodev.tasks.domain.Task}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class TaskProperties {

	private TaskProperties() {
	}

	private static final TaskPropertiesImpl<Task> sharedInstance = new TaskPropertiesImpl<Task>(Task.class);

	public static Property<Task> id() {
		return sharedInstance.id();
	}

	public static Property<Task> projectId() {
		return sharedInstance.projectId();
	}

	public static Property<Task> name() {
		return sharedInstance.name();
	}

	public static Property<Task> description() {
		return sharedInstance.description();
	}

	public static Property<Task> originDate() {
		return sharedInstance.originDate();
	}

	public static Property<Task> deadline() {
		return sharedInstance.deadline();
	}

	public static Property<Task> personName() {
		return sharedInstance.personName();
	}

	public static Property<Task> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<Task> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<Task> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<Task> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<Task> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<Task> version() {
		return sharedInstance.version();
	}

	public static Property<Task> taskType() {
		return sharedInstance.taskType();
	}

	public static Property<Task> priority() {
		return sharedInstance.priority();
	}

	public static Property<Task> status() {
		return sharedInstance.status();
	}

	public static Property<Task> placement() {
		return sharedInstance.placement();
	}

	public static ProjectProperty<Task> project() {
		return sharedInstance.project();
	}

	public static EndUserProperty<Task> person() {
		return sharedInstance.person();
	}

	public static CommunicationProperty<Task> communications() {
		return sharedInstance.communications();
	}

	public static TimeLineProperty<Task> timeLines() {
		return sharedInstance.timeLines();
	}

	/**
	 * This class is used for references to {@link sk.f4s.easytodev.tasks.domain.Task}, i.e. nested property.
	 */
	public static class TaskProperty<T> extends TaskPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public TaskProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class TaskPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		TaskPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		TaskPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
		}

		public Property<T> projectId() {
			return new LeafProperty<T>(getParentPath(), "projectId", false, owningClass);
		}

		public Property<T> name() {
			return new LeafProperty<T>(getParentPath(), "name", false, owningClass);
		}

		public Property<T> description() {
			return new LeafProperty<T>(getParentPath(), "description", false, owningClass);
		}

		public Property<T> originDate() {
			return new LeafProperty<T>(getParentPath(), "originDate", false, owningClass);
		}

		public Property<T> deadline() {
			return new LeafProperty<T>(getParentPath(), "deadline", false, owningClass);
		}

		public Property<T> personName() {
			return new LeafProperty<T>(getParentPath(), "personName", false, owningClass);
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

		public Property<T> taskType() {
			return new LeafProperty<T>(getParentPath(), "taskType", false, owningClass);
		}

		public Property<T> priority() {
			return new LeafProperty<T>(getParentPath(), "priority", false, owningClass);
		}

		public Property<T> status() {
			return new LeafProperty<T>(getParentPath(), "status", false, owningClass);
		}

		public Property<T> placement() {
			return new LeafProperty<T>(getParentPath(), "placement", false, owningClass);
		}

		public ProjectProperty<T> project() {
			return new ProjectProperty<T>(getParentPath(), "project", owningClass);
		}

		public EndUserProperty<T> person() {
			return new EndUserProperty<T>(getParentPath(), "person", owningClass);
		}

		public CommunicationProperty<T> communications() {
			return new CommunicationProperty<T>(getParentPath(), "communications", owningClass);
		}

		public TimeLineProperty<T> timeLines() {
			return new TimeLineProperty<T>(getParentPath(), "timeLines", owningClass);
		}
	}
}
