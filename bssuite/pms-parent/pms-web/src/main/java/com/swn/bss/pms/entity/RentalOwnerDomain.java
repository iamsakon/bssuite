/**
 * 
 */
package com.swn.bss.pms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author MrMai
 * 
 */
@Entity
@Table(name = "pms_rental_owner")
@SequenceGenerator(name = "SEQ_PMS_RENTAL_OWNER", sequenceName = "seq_pms_rental_owner")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RentalOwnerDomain extends AbstractPmsDomain implements
		Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7443424291621559680L;

	/**
	 * Rental Owner Name
	 */
	@NotNull
	@Column(name = "name")
	@Size(max = 128)
	private String name;

	/**
	 * Rental Owner Middle Name
	 */
	@Column(name = "middle_name")
	@Size(max = 128)
	private String middleName;

	/**
	 * Rental Owner Last Name
	 */
	@Column(name = "last_name")
	@Size(max = 128)
	private String lastName;

	/**
	 * Rental Owner Primary Email
	 */
	@Column(name = "primary_email")
	@Size(max = 128)
	private String primaryEmail;

	/**
	 * Rental Owner Alternate Email
	 */
	@Column(name = "alternate_email")
	@Size(max = 128)
	private String alternateEmail;

	/**
	 * Rental Owner Mobile number
	 */
	@Column(name = "mobile_number")
	@Size(max = 20)
	private String mobileNumber;

	/**
	 * Rental Owner Home Phone
	 */
	@Column(name = "home_phone")
	@Size(max = 20)
	private String homePhone;

	/**
	 * Rental Owner Comment
	 */
	@Column(name = "comment")
	@Size(max = 256)
	private String comment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RentalOwnerDomain [name=");
		builder.append(name);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", primaryEmail=");
		builder.append(primaryEmail);
		builder.append(", alternateEmail=");
		builder.append(alternateEmail);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", homePhone=");
		builder.append(homePhone);
		builder.append(", comment=");
		builder.append(comment);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((alternateEmail == null) ? 0 : alternateEmail.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result
				+ ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result
				+ ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((primaryEmail == null) ? 0 : primaryEmail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentalOwnerDomain other = (RentalOwnerDomain) obj;
		if (alternateEmail == null) {
			if (other.alternateEmail != null)
				return false;
		} else if (!alternateEmail.equals(other.alternateEmail))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (primaryEmail == null) {
			if (other.primaryEmail != null)
				return false;
		} else if (!primaryEmail.equals(other.primaryEmail))
			return false;
		return true;
	}

}
