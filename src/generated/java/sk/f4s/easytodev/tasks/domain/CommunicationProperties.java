package sk.f4s.easytodev.tasks.domain;

import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.domain.TaskProperties.TaskProperty;
import sk.f4s.easytodev.tasks.domain.UseerProperties.UseerProperty;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link sk.f4s.easytodev.tasks.domain.Communication}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class CommunicationProperties {

	private CommunicationProperties() {
	}

	private static final CommunicationPropertiesImpl<Communication> sharedInstance = new CommunicationPropertiesImpl<Communication>(
			Communication.class);

	public static Property<Communication> id() {
		return sharedInstance.id();
	}

	public static Property<Communication> content() {
		return sharedInstance.content();
	}

	public static Property<Communication> date() {
		return sharedInstance.date();
	}

	public static Property<Communication> uuid() {
		return sharedInstance.uuid();
	}

	public static Property<Communication> createdDate() {
		return sharedInstance.createdDate();
	}

	public static Property<Communication> createdBy() {
		return sharedInstance.createdBy();
	}

	public static Property<Communication> lastUpdated() {
		return sharedInstance.lastUpdated();
	}

	public static Property<Communication> lastUpdatedBy() {
		return sharedInstance.lastUpdatedBy();
	}

	public static Property<Communication> version() {
		return sharedInstance.version();
	}

	public static TaskProperty<Communication> task() {
		return sharedInstance.task();
	}

	public static UseerProperty<Communication> sender() {
		return sharedInstance.sender();
	}

	public static UseerProperty<Communication> recipient() {
		return sharedInstance.recipient();
	}

	/**
	 * This class is used for references to {@link sk.f4s.easytodev.tasks.domain.Communication}, i.e. nested property.
	 */
	public static class CommunicationProperty<T> extends CommunicationPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public CommunicationProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class CommunicationPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		CommunicationPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		CommunicationPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
		}

		public Property<T> content() {
			return new LeafProperty<T>(getParentPath(), "content", false, owningClass);
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

		public TaskProperty<T> task() {
			return new TaskProperty<T>(getParentPath(), "task", owningClass);
		}

		public UseerProperty<T> sender() {
			return new UseerProperty<T>(getParentPath(), "sender", owningClass);
		}

		public UseerProperty<T> recipient() {
			return new UseerProperty<T>(getParentPath(), "recipient", owningClass);
		}
	}
}
