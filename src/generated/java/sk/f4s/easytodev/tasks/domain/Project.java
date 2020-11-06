package sk.f4s.easytodev.tasks.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.sculptor.framework.domain.AbstractDomainObject;
import org.sculptor.framework.domain.AuditListener;
import org.sculptor.framework.domain.Auditable;
import org.sculptor.framework.domain.Identifiable;
import sk.f4s.easytodev.tasks.domain.Task;

/**
 * Entity representing Project.
 */

@Entity
@Table(name = "PROJECT")
@EntityListeners({ AuditListener.class })
public class Project extends AbstractDomainObject implements Auditable, Identifiable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NAME", nullable = false, length = 100)
	@NotNull
	private String name;
	@Column(name = "DESCRIPTION", nullable = false, length = 100)
	@NotNull
	private String description;
	@Column(name = "LAUNCHDATE", nullable = false)
	@Type(type = "date")
	@NotNull
	private Date launchDate;
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	@NotNull
	private List<Task> tasks = new ArrayList<Task>();

	public Project() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;

	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;

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

	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * Adds an object to the bidirectional many-to-one association in both ends. It is added the collection {@link #getTasks} at
	 * this side and the association {@link sk.f4s.easytodev.tasks.domain.Task#setProject} at the opposite side is set.
	 */
	public void addTask(Task taskElement) {
		getTasks().add(taskElement);
		taskElement.setProject((sk.f4s.easytodev.tasks.domain.Project) this);
	}

	/*
	 * EclipseLink/DataNucleus are trying to update the related entities. This fails on non nullable references
	 */
	/**
	 * Removes an object from the bidirectional many-to-one association in both ends. It is removed from the collection
	 * {@link #getTasks} at this side and the association {@link sk.f4s.easytodev.tasks.domain.Task#setProject} at the opposite side
	 * is cleared (nulled).
	 */
	public void removeTask(Task taskElement) {
		getTasks().remove(taskElement);

		taskElement.setProject(null);
	}

	/*
	 * EclipseLink/DataNucleus are trying to update the related entities. This fails on non nullable references
	 */
	/**
	 * Removes all object from the bidirectional many-to-one association in both ends. All elements are removed from the collection
	 * {@link #getTasks} at this side and the association {@link sk.f4s.easytodev.tasks.domain.Task#setProject} at the opposite side
	 * is cleared (nulled).
	 */
	public void removeAllTasks() {
		for (Task d : getTasks()) {
			d.setProject(null);
		}
		getTasks().clear();
	}

	@PrePersist
	protected void prePersist() {
		getUuid();
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
