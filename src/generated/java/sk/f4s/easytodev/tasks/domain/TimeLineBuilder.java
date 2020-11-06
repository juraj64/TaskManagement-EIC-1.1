package sk.f4s.easytodev.tasks.domain;

import java.util.Date;
import sk.f4s.easytodev.tasks.domain.Task;
import sk.f4s.easytodev.tasks.domain.TimeLine;
import sk.f4s.easytodev.tasks.domain.Useer;

/**
 * Builder for TimeLine class.
 */
public class TimeLineBuilder {

	private Date date;
	private String label;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	private Useer useer;
	private Task task;

	/**
	 * Static factory method for TimeLineBuilder
	 */
	public static TimeLineBuilder timeLine() {
		return new TimeLineBuilder();
	}

	public TimeLineBuilder() {
	}

	public TimeLineBuilder date(Date val) {
		this.date = val;
		return this;
	}

	public TimeLineBuilder label(String val) {
		this.label = val;
		return this;
	}

	public TimeLineBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public TimeLineBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public TimeLineBuilder lastUpdated(Date val) {
		this.lastUpdated = val;
		return this;
	}

	public TimeLineBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	public TimeLineBuilder useer(Useer useer) {
		this.useer = useer;
		return this;
	}

	public TimeLineBuilder task(Task task) {
		this.task = task;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public String getLabel() {
		return label;
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

	public Useer getUseer() {
		return useer;
	}

	public Task getTask() {
		return task;
	}

	/**
	 * @return new TimeLine instance constructed based on the values that have been set into this builder
	 */
	public TimeLine build() {
		TimeLine obj = new TimeLine();
		obj.setDate(date);
		obj.setLabel(label);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);
		obj.setUseer(useer);
		obj.setTask(task);

		return obj;
	}
}
