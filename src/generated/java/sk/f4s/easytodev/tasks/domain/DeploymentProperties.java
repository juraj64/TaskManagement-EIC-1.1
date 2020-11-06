package sk.f4s.easytodev.tasks.domain;

import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;
import sk.f4s.easytodev.tasks.domain.Deployment;
import sk.f4s.easytodev.tasks.domain.TaskProperties.TaskProperty;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link sk.f4s.easytodev.tasks.domain.Deployment}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class DeploymentProperties {

	private DeploymentProperties() {
	}

	private static final DeploymentPropertiesImpl<Deployment> sharedInstance = new DeploymentPropertiesImpl<Deployment>(
			Deployment.class);

	public static Property<Deployment> id() {
		return sharedInstance.id();
	}

	public static Property<Deployment> label() {
		return sharedInstance.label();
	}

	public static Property<Deployment> date() {
		return sharedInstance.date();
	}

	public static Property<Deployment> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<Deployment> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<Deployment> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<Deployment> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<Deployment> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<Deployment> version() {
		return sharedInstance.version();
	}

	public static Property<Deployment> environment() {
		return sharedInstance.environment();
	}

	public static TaskProperty<Deployment> tasks() {
		return sharedInstance.tasks();
	}

	/**
	 * This class is used for references to {@link sk.f4s.easytodev.tasks.domain.Deployment}, i.e. nested property.
	 */
	public static class DeploymentProperty<T> extends DeploymentPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public DeploymentProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class DeploymentPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		DeploymentPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		DeploymentPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
		}

		public Property<T> label() {
			return new LeafProperty<T>(getParentPath(), "label", false, owningClass);
		}

		public Property<T> date() {
			return new LeafProperty<T>(getParentPath(), "date", false, owningClass);
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

		public Property<T> environment() {
			return new LeafProperty<T>(getParentPath(), "environment", false, owningClass);
		}

		public TaskProperty<T> tasks() {
			return new TaskProperty<T>(getParentPath(), "tasks", owningClass);
		}
	}
}
