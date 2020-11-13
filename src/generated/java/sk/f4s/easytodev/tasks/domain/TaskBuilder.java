package sk.f4s.easytodev.tasks.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sk.f4s.easytodev.tasks.domain.Communication;
import sk.f4s.easytodev.tasks.domain.Environment;
import sk.f4s.easytodev.tasks.domain.Priority;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.domain.TaskStatus;
import sk.f4s.easytodev.tasks.domain.TimeLine;
import sk.f4s.easytodev.tasks.domain.Type;

/**
 * Builder for Task class.
 */
public class TaskBuilder {

	private Long projectId;
	private String name;
	private String description;
	private Date originDate;
	private Date deadline;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	private Project project;
	private Type taskType;
	private Priority priority;
	private TaskStatus status;
	private Environment placement;

	private List<Communication> communications = new ArrayList<Communication>();

	private List<TimeLine> timeLines = new ArrayList<TimeLine>();

	/**
	 * Static factory method for TaskBuilder
	 */
	public static TaskBuilder task() {
		return new TaskBuilder();
	}

	public TaskBuilder() {
	}

	public TaskBuilder projectId(Long val) {
		this.projectId = val;
		return this;
	}

	public TaskBuilder name(String val) {
		this.name = val;
		return this;
	}

	public TaskBuilder description(String val) {
		this.description = val;
		return this;
	}

	public TaskBuilder originDate(Date val) {
		this.originDate = val;
		return this;
	}

	public TaskBuilder deadline(Date val) {
		this.deadline = val;
		return this;
	}

	public TaskBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public TaskBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public TaskBuilder lastUpdated(Date val) {
		this.lastUpdated = val;
		return this;
	}

	public TaskBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	public TaskBuilder project(Project project) {
		this.project = project;
		return this;
	}

	public TaskBuilder taskType(Type taskType) {
		this.taskType = taskType;
		return this;
	}

	public TaskBuilder priority(Priority priority) {
		this.priority = priority;
		return this;
	}

	public TaskBuilder status(TaskStatus status) {
		this.status = status;
		return this;
	}

	public TaskBuilder placement(Environment placement) {
		this.placement = placement;
		return this;
	}

	/**
	 * Adds an object to the to-many association. It is added the collection {@link #getCommunications}.
	 */
	public TaskBuilder addCommunication(Communication communicationElement) {
		getCommunications().add(communicationElement);
		return this;
	}

	/**
	 * Adds an object to the to-many association. It is added the collection {@link #getTimeLines}.
	 */
	public TaskBuilder addTimeLine(TimeLine timeLineElement) {
		getTimeLines().add(timeLineElement);
		return this;
	}

	public Long getProjectId() {
		return projectId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getOriginDate() {
		return originDate;
	}

	public Date getDeadline() {
		return deadline;
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

	public Project getProject() {
		return project;
	}

	public Type getTaskType() {
		return taskType;
	}

	public Priority getPriority() {
		return priority;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public Environment getPlacement() {
		return placement;
	}

	public List<Communication> getCommunications() {
		return communications;
	}

	public List<TimeLine> getTimeLines() {
		return timeLines;
	}

	/**
	 * @return new Task instance constructed based on the values that have been set into this builder
	 */
	public Task build() {
		Task obj = new Task();
		obj.setProjectId(projectId);
		obj.setName(name);
		obj.setDescription(description);
		obj.setOriginDate(originDate);
		obj.setDeadline(deadline);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);
		obj.setProject(project);
		obj.setTaskType(taskType);
		obj.setPriority(priority);
		obj.setStatus(status);
		obj.setPlacement(placement);
		obj.getCommunications().addAll(communications);
		obj.getTimeLines().addAll(timeLines);

		return obj;
	}
}
