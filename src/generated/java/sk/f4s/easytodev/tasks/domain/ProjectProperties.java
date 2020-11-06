package sk.f4s.easytodev.tasks.domain;

import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.domain.TaskProperties.TaskProperty;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link sk.f4s.easytodev.tasks.domain.Project}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class ProjectProperties {

	private ProjectProperties() {
	}

	private static final ProjectPropertiesImpl<Project> sharedInstance = new ProjectPropertiesImpl<Project>(Project.class);

	public static Property<Project> id() {
		return sharedInstance.id();
	}

	public static Property<Project> name() {
		return sharedInstance.name();
	}

	public static Property<Project> description() {
		return sharedInstance.description();
	}

	public static Property<Project> launchDate() {
		return sharedInstance.launchDate();
	}

	public static Property<Project> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<Project> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<Project> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<Project> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<Project> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<Project> version() {
		return sharedInstance.version();
	}

	public static TaskProperty<Project> tasks() {
		return sharedInstance.tasks();
	}

	/**
	 * This class is used for references to {@link sk.f4s.easytodev.tasks.domain.Project}, i.e. nested property.
	 */
	public static class ProjectProperty<T> extends ProjectPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public ProjectProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class ProjectPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		ProjectPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		ProjectPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
		}

		public Property<T> name() {
			return new LeafProperty<T>(getParentPath(), "name", false, owningClass);
		}

		public Property<T> description() {
			return new LeafProperty<T>(getParentPath(), "description", false, owningClass);
		}

		public Property<T> launchDate() {
			return new LeafProperty<T>(getParentPath(), "launchDate", false, owningClass);
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

		public TaskProperty<T> tasks() {
			return new TaskProperty<T>(getParentPath(), "tasks", owningClass);
		}
	}
}
