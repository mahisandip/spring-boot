package com.thales.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version;

	@Column(name = "CREATED_TIME", nullable = false)
	private Date createdTime;

	@Column(name = "LAST_UPDATED_TIME", nullable = false)
	private Date lastUpdatedTime;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

}
