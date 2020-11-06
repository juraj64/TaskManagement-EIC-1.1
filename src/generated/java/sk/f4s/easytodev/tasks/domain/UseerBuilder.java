package sk.f4s.easytodev.tasks.domain;

import java.util.Date;
import sk.f4s.easytodev.tasks.domain.Useer;

/**
 * Builder for Useer class.
 */
public class UseerBuilder {

	private String name;
	private String role;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	/**
	 * Static factory method for UseerBuilder
	 */
	public static UseerBuilder useer() {
		return new UseerBuilder();
	}

	public UseerBuilder() {
	}

	public UseerBuilder name(String val) {
		this.name = val;
		return this;
	}

	public UseerBuilder role(String val) {
		this.role = val;
		return this;
	}

	public UseerBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public UseerBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public UseerBuilder lastUpdated(Date val) {
		this.lastUpdated = val;
		return this;
	}

	public UseerBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
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

	/**
	 * @return new Useer instance constructed based on the values that have been set into this builder
	 */
	public Useer build() {
		Useer obj = new Useer();
		obj.setName(name);
		obj.setRole(role);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);

		return obj;
	}
}
