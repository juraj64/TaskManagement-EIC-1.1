package sk.f4s.easytodev.tasks.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sk.f4s.easytodev.tasks.domain.Project;
import sk.f4s.easytodev.tasks.domain.Task;

/**
 * Builder for Project class.
 */
public class ProjectBuilder {

	private String name;
	private String description;
	private Date launchDate;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	private List<Task> tasks = new ArrayList<Task>();

	/**
	 * Static factory method for ProjectBuilder
	 */
	public static ProjectBuilder project() {
		return new ProjectBuilder();
	}

	public ProjectBuilder() {
	}

	public ProjectBuilder name(String val) {
		this.name = val;
		return this;
	}

	public ProjectBuilder description(String val) {
		this.description = val;
		return this;
	}

	public ProjectBuilder launchDate(Date val) {
		this.launchDate = val;
		return this;
	}

	public ProjectBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public ProjectBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public ProjectBuilder lastUpdated(Date val) {
		this.lastUpdated = val;
		return this;
	}

	public ProjectBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	/**
	 * Adds an object to the to-many association. It is added the collection {@link #getTasks}.
	 */
	public ProjectBuilder addTask(Task taskElement) {
		getTasks().add(taskElement);
		return this;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Date getLaunchDate() {
		return launchDate;
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

	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * @return new Project instance constructed based on the values that have been set into this builder
	 */
	public Project build() {
		Project obj = new Project();
		obj.setName(name);
		obj.setDescription(description);
		obj.setLaunchDate(launchDate);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);
		obj.getTasks().addAll(tasks);

		return obj;
	}
}
