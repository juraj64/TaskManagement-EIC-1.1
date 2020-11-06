package sk.f4s.easytodev.tasks.domain;

import java.util.Date;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.domain.Useer;

/**
 * Builder for Communication class.
 */
public class CommunicationBuilder {

	private String content;
	private Date date;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	private Task task;
	private Useer sender;
	private Useer recipient;

	/**
	 * Static factory method for CommunicationBuilder
	 */
	public static CommunicationBuilder communication() {
		return new CommunicationBuilder();
	}

	public CommunicationBuilder() {
	}

	public CommunicationBuilder content(String val) {
		this.content = val;
		return this;
	}

	public CommunicationBuilder date(Date val) {
		this.date = val;
		return this;
	}

	public CommunicationBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public CommunicationBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public CommunicationBuilder lastUpdated(Date val) {
		this.lastUpdated = val;
		return this;
	}

	public CommunicationBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	public CommunicationBuilder task(Task task) {
		this.task = task;
		return this;
	}

	public CommunicationBuilder sender(Useer sender) {
		this.sender = sender;
		return this;
	}

	public CommunicationBuilder recipient(Useer recipient) {
		this.recipient = recipient;
		return this;
	}

	public String getContent() {
		return content;
	}

	public Date getDate() {
		return date;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public Task getTask() {
		return task;
	}

	public Useer getSender() {
		return sender;
	}

	public Useer getRecipient() {
		return recipient;
	}

	/**
	 * @return new Communication instance constructed based on the values that have been set into this builder
	 */
	public Communication build() {
		Communication obj = new Communication();
		obj.setContent(content);
		obj.setDate(date);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);
		obj.setTask(task);
		obj.setSender(sender);
		obj.setRecipient(recipient);

		return obj;
	}
}
