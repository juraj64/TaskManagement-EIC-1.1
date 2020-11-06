package sk.f4s.easytodev.tasks.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sk.f4s.easytodev.tasks.domain.Deployment;
import sk.f4s.easytodev.tasks.domain.Environment;
import sk.f4s.easytodev.tasks.domain.Task;

/**
 * Builder for Deployment class.
 */
public class DeploymentBuilder {

	private String label;
	private Date date;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	private Environment environment;

	private List<Task> tasks = new ArrayList<Task>();

	/**
	 * Static factory method for DeploymentBuilder
	 */
	public static DeploymentBuilder deployment() {
		return new DeploymentBuilder();
	}

	public DeploymentBuilder() {
	}

	public DeploymentBuilder label(String val) {
		this.label = val;
		return this;
	}

	public DeploymentBuilder date(Date val) {
		this.date = val;
		return this;
	}

	public DeploymentBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public DeploymentBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public DeploymentBuilder lastUpdated(Date val) {
		this.lastUpdated = val;
		return this;
	}

	public DeploymentBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	public DeploymentBuilder environment(Environment environment) {
		this.environment = environment;
		return this;
	}

	/**
	 * Adds an object to the to-many association. It is added the collection {@link #getTasks}.
	 */
	public DeploymentBuilder addTask(Task taskElement) {
		getTasks().add(taskElement);
		return this;
	}

	public String getLabel() {
		return label;
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

	public Environment getEnvironment() {
		return environment;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	/**
	 * @return new Deployment instance constructed based on the values that have been set into this builder
	 */
	public Deployment build() {
		Deployment obj = new Deployment();
		obj.setLabel(label);
		obj.setDate(date);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);
		obj.setEnvironment(environment);
		obj.getTasks().addAll(tasks);

		return obj;
	}
}
