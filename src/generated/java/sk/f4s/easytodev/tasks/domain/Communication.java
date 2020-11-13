package sk.f4s.easytodev.tasks.domain;

import java.util.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import sk.f4s.easytodev.tasks.domain.EndUser;
import sk.f4s.easytodev.tasks.domain.Task;

/**
 * Entity representing Communication.
 */

@Entity
@Table(name = "COMMUNICATION")
@EntityListeners({ AuditListener.class })
public class Communication extends AbstractDomainObject implements Auditable, Identifiable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "TASKID", nullable = false)
	@NotNull
	private Long taskId;
	@Column(name = "SENDERNAME", nullable = false, length = 100)
	@NotNull
	private String senderName;
	@Column(name = "RECIPIENTNAME", nullable = false, length = 100)
	@NotNull
	private String recipientName;
	@Column(name = "CONTENT", nullable = false, length = 100)
	@NotNull
	private String content;
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

	@ManyToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "TASK", nullable = false)
	@ForeignKey(name = "FK_COMMUNICATION_TASK")
	@NotNull
	private Task task;
	@ManyToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "SENDER", nullable = false)
	@ForeignKey(name = "FK_COMMUNICATION_SENDER")
	@NotNull
	private EndUser sender;
	@ManyToOne(optional = false, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "RECIPIENT", nullable = false)
	@ForeignKey(name = "FK_COMMUNICATION_RECIPIENT")
	@NotNull
	private EndUser recipient;

	public Communication() {
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

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;

	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;

	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;

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

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public EndUser getSender() {
		return sender;
	}

	public void setSender(EndUser sender) {
		this.sender = sender;
	}

	public EndUser getRecipient() {
		return recipient;
	}

	public void setRecipient(EndUser recipient) {
		this.recipient = recipient;
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
