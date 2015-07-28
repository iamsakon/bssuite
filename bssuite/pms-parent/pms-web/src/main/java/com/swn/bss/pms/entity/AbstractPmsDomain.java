package com.swn.bss.pms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractPmsDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4539283985100678916L;

	/**
     */
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date createdDate;

	/**
     */
	@Column(name = "created_by")
	private long createdBy;

	/**
     */
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date updatedDate;

	/**
     */
	@Column(name = "updated_by")
	private long updatedBy;

	/**
	 * Last Access IP
	 */
	@Column(name = "last_access_ip")
	@Size(max = 128)
	private String lastAccessIp;

	/**
	 * Active data
	 */
	@NotNull
	@Column(name = "is_active")
	private boolean isActive;

	@Version
	@Column(name = "version")
	private int version;



	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getLastAccessIp() {
		return lastAccessIp;
	}

	public void setLastAccessIp(String lastAccessIp) {
		this.lastAccessIp = lastAccessIp;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", lastAccessIp=");
		builder.append(lastAccessIp);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (createdBy ^ (createdBy >>> 32));
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result
				+ ((lastAccessIp == null) ? 0 : lastAccessIp.hashCode());
		result = prime * result + (int) (updatedBy ^ (updatedBy >>> 32));
		result = prime * result
				+ ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractPmsDomain other = (AbstractPmsDomain) obj;
		if (createdBy != other.createdBy)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (isActive != other.isActive)
			return false;
		if (lastAccessIp == null) {
			if (other.lastAccessIp != null)
				return false;
		} else if (!lastAccessIp.equals(other.lastAccessIp))
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

}
