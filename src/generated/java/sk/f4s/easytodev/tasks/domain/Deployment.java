package sk.f4s.easytodev.tasks.domain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Type;
import org.sculptor.framework.domain.AbstractDomainObject;
import org.sculptor.framework.domain.AuditListener;
import org.sculptor.framework.domain.Auditable;
import org.sculptor.framework.domain.Identifiable;
import sk.f4s.easytodev.tasks.domain.Environment;
import sk.f4s.easytodev.tasks.domain.Task;

/**
 * Entity representing Deployment.
 */

@Entity
@Table(name = "DEPLOYMENT")
@EntityListeners({ AuditListener.class })
public class Deployment extends AbstractDomainObject implements Auditable, Identifiable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "LABEL", nullable = false, length = 100)
	@NotNull
	private String label;
	@Column(name = "DATE", nullable = false)
	@Type(type = "date")
	@NotNull
	private Date date;
	@Column(name = "UUID", nullable = false, length = 36, unique = true)
	private String uuid;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDDATE")
	private Date createdDate;
	@Column(name = "CREATEDBY", length = 50)
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LASTUPDATED")
	private Date lastUpdated;
	@Column(name = "LASTUPDATEDBY", length = 50)
	private String lastUpdatedBy;
	@Version
	@Column(name = "VERSION", nullable = false)
	private Long version;

	@Column(name = "ENVIRONMENT", nullable = false, length = 4)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Environment environment;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "DEPLOYMENT_TASK", joinColumns = @JoinColumn(name = "DEPLOYMENT"), inverseJoinColumns = @JoinColumn(name = "TASK"))
	@ForeignKey(name = "FK_DEPLOYMENT_TASK_DEPLOYMENT", inverseName = "FK_DEPLOYMENT_TASK_TASK")
	@NotNull
	private List<Task> tasks = new ArrayList<Task>();

	public Deployment() {
	}

	public Long getId() {
		return id;
	}

	/**
	 * The id is not intended to be changed or assigned manually, but for test purpose it is allowed to assign the id.
	 */
	protected void setId(Long id) {
		if ((this.id != null) && !this.id.equals(id)) {
			throw new IllegalArgumentException("Not allowed to change the id property.");
		}
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;

	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;

	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;

	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;

	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;

	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;

	}

	/**
	 * This domain object doesn't have a natural key and this random generated identifier is the unique identifier for this domain
	 * object.
	 */
	public String getUuid() {
		// lazy init of UUID
		if (uuid == null) {
			uuid = UUID.randomUUID().toString();
		}
		return uuid;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * Adds an object to the unidirectional to-many association. It is added the collection {@link #getTasks}.
	 */
	public void addTask(Task taskElement) {
		getTasks().add(taskElement);
	}

	/**
	 * Removes an object from the unidirectional to-many association. It is removed from the collection {@link #getTasks}.
	 */
	public void removeTask(Task taskElement) {
		getTasks().remove(taskElement);
	}

	/**
	 * Removes all object from the unidirectional to-many association. All elements are removed from the collection
	 * {@link #getTasks}.
	 */
	public void removeAllTasks() {
		getTasks().clear();
	}

	@PrePersist
	protected void prePersist() {
		getUuid();
	}

	/**
	 * This method is used by toString. It specifies what to include in the toString result.
	 * 
	 * @return true if the field is to be included in toString
	 */
	protected boolean acceptToString(Field field) {
		if (super.acceptToString(field)) {
			return true;
		} else {
			if (field.getName().equals("environment")) {
				return true;
			}
			return false;
		}
	}

	/**
	 * This method is used by equals and hashCode.
	 * 
	 * @return {{@link #getUuid}
	 */
	public Object getKey() {
		return getUuid();
	}

}
