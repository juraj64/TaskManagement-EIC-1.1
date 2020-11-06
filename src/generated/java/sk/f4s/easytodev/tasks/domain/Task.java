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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.domain.Environment;
import sk.f4s.easytodev.tasks.domain.Priority;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.domain.TaskStatus;
import sk.f4s.easytodev.tasks.domain.TimeLine;

/**
 * Entity representing Task.
 */

@Entity
@Table(name = "TASK")
@EntityListeners({ AuditListener.class })
public class Task extends AbstractDomainObject implements Auditable, Identifiable {

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
	@Column(name = "ORIGINDATE", nullable = false)
	@Type(type = "date")
	@NotNull
	private Date originDate;
	@Column(name = "DEADLINE", nullable = false)
	@Type(type = "date")
	@NotNull
	private Date deadline;
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

	@ManyToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "PROJECT", nullable = false)
	@ForeignKey(name = "FK_TASK_PROJECT")
	@NotNull
	private Project project;
	@Column(name = "TASKTYPE", nullable = false, length = 13)
	@Enumerated(EnumType.STRING)
	@NotNull
	private sk.f4s.easytodev.tasks.domain.Type taskType;
	@Column(name = "PRIORITY", nullable = false, length = 6)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Priority priority;
	@Column(name = "STATUS", nullable = false, length = 8)
	@Enumerated(EnumType.STRING)
	@NotNull
	private TaskStatus status;
	@Column(name = "PLACEMENT", nullable = false, length = 4)
	@Enumerated(EnumType.STRING)
	@NotNull
	private Environment placement;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
	@NotNull
	private List<Communication> communications = new ArrayList<Communication>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
	@NotNull
	private List<TimeLine> timeLines = new ArrayList<TimeLine>();

	public Task() {
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

	public Date getOriginDate() {
		return originDate;
	}

	public void setOriginDate(Date originDate) {
		this.originDate = originDate;

	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;

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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public sk.f4s.easytodev.tasks.domain.Type getTaskType() {
		return taskType;
	}

	public void setTaskType(sk.f4s.easytodev.tasks.domain.Type taskType) {
		this.taskType = taskType;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public Environment getPlacement() {
		return placement;
	}

	public void setPlacement(Environment placement) {
		this.placement = placement;
	}

	public List<Communication> getCommunications() {
		return communications;
	}

	/**
	 * Adds an object to the bidirectional many-to-one association in both ends. It is added the collection
	 * {@link #getCommunications} at this side and the association {@link sk.f4s.easytodev.tasks.domain.Communication#setTask} at
	 * the opposite side is set.
	 */
	public void addCommunication(Communication communicationElement) {
		getCommunications().add(communicationElement);
		communicationElement.setTask((sk.f4s.easytodev.tasks.domain.Task) this);
	}

	/*
	 * EclipseLink/DataNucleus are trying to update the related entities. This fails on non nullable references
	 */
	/**
	 * Removes an object from the bidirectional many-to-one association in both ends. It is removed from the collection
	 * {@link #getCommunications} at this side and the association {@link sk.f4s.easytodev.tasks.domain.Communication#setTask} at
	 * the opposite side is cleared (nulled).
	 */
	public void removeCommunication(Communication communicationElement) {
		getCommunications().remove(communicationElement);

		communicationElement.setTask(null);
	}

	/*
	 * EclipseLink/DataNucleus are trying to update the related entities. This fails on non nullable references
	 */
	/**
	 * Removes all object from the bidirectional many-to-one association in both ends. All elements are removed from the collection
	 * {@link #getCommunications} at this side and the association {@link sk.f4s.easytodev.tasks.domain.Communication#setTask} at
	 * the opposite side is cleared (nulled).
	 */
	public void removeAllCommunications() {
		for (Communication d : getCommunications()) {
			d.setTask(null);
		}
		getCommunications().clear();
	}

	public List<TimeLine> getTimeLines() {
		return timeLines;
	}

	/**
	 * Adds an object to the bidirectional many-to-one association in both ends. It is added the collection {@link #getTimeLines} at
	 * this side and the association {@link sk.f4s.easytodev.tasks.domain.TimeLine#setTask} at the opposite side is set.
	 */
	public void addTimeLine(TimeLine timeLineElement) {
		getTimeLines().add(timeLineElement);
		timeLineElement.setTask((sk.f4s.easytodev.tasks.domain.Task) this);
	}

	/*
	 * EclipseLink/DataNucleus are trying to update the related entities. This fails on non nullable references
	 */
	/**
	 * Removes an object from the bidirectional many-to-one association in both ends. It is removed from the collection
	 * {@link #getTimeLines} at this side and the association {@link sk.f4s.easytodev.tasks.domain.TimeLine#setTask} at the opposite
	 * side is cleared (nulled).
	 */
	public void removeTimeLine(TimeLine timeLineElement) {
		getTimeLines().remove(timeLineElement);

		timeLineElement.setTask(null);
	}

	/*
	 * EclipseLink/DataNucleus are trying to update the related entities. This fails on non nullable references
	 */
	/**
	 * Removes all object from the bidirectional many-to-one association in both ends. All elements are removed from the collection
	 * {@link #getTimeLines} at this side and the association {@link sk.f4s.easytodev.tasks.domain.TimeLine#setTask} at the opposite
	 * side is cleared (nulled).
	 */
	public void removeAllTimeLines() {
		for (TimeLine d : getTimeLines()) {
			d.setTask(null);
		}
		getTimeLines().clear();
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
			if (field.getName().equals("taskType")) {
				return true;
			}
			if (field.getName().equals("priority")) {
				return true;
			}
			if (field.getName().equals("status")) {
				return true;
			}
			if (field.getName().equals("placement")) {
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
