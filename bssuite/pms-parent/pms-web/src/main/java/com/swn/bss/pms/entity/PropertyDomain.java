/**
 * 
 */
package com.swn.bss.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author MrMai
 *
 */
@Entity
@Table(name = "pms_property")
@SequenceGenerator(name = "SEQ_PMS_PROPERTY", sequenceName = "seq_pms_property")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PropertyDomain extends AbstractPmsDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6758460448443606092L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long oid;
	/**
     * Property Code
     */
    @NotNull
    @Column(name = "code")
    @Size(max = 128)
	private String code;
    /**
     * Property name
     */
    @NotNull
    @Column(name = "name")
    @Size(max = 128)
	private String name;
    /**
     * Property address line 1
     */
    @NotNull
    @Column(name = "address_line_1")
    @Size(max = 128)
	private String addressLine1;
    /**
     * Property address line 2
     */
    @NotNull
    @Column(name = "address_line_2")
    @Size(max = 128)
	private String addressLine2;
    
    /**
     * Property address line 3
     */
    @NotNull
    @Column(name = "address_line_3")
    @Size(max = 128)
	private String addressLine3;
    
    /**
     * Property city locate
     */
    @NotNull
    @Column(name = "city")
    @Size(max = 128)
    private String city;
    /**
     * Property zipcode
     */
    @NotNull
    @Column(name = "zipcode")
    @Size(max = 128)
    private String zipcode;
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private PropertySubTypeDomain propertySubType;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private RentalOwnerDomain rentalOwner;
    
	public Long getOid() {
		return oid;
	}
	public void setOid(Long oid) {
		this.oid = oid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result
				+ ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result
				+ ((addressLine3 == null) ? 0 : addressLine3.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result
				+ ((propertySubType == null) ? 0 : propertySubType.hashCode());
		result = prime * result
				+ ((rentalOwner == null) ? 0 : rentalOwner.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		PropertyDomain other = (PropertyDomain) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (addressLine3 == null) {
			if (other.addressLine3 != null)
				return false;
		} else if (!addressLine3.equals(other.addressLine3))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (propertySubType == null) {
			if (other.propertySubType != null)
				return false;
		} else if (!propertySubType.equals(other.propertySubType))
			return false;
		if (rentalOwner == null) {
			if (other.rentalOwner != null)
				return false;
		} else if (!rentalOwner.equals(other.rentalOwner))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropertyDomain [oid=");
		builder.append(oid);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine2);
		builder.append(", addressLine3=");
		builder.append(addressLine3);
		builder.append(", city=");
		builder.append(city);
		builder.append(", zipcode=");
		builder.append(zipcode);
		builder.append(", propertySubType=");
		builder.append(propertySubType);
		builder.append(", rentalOwner=");
		builder.append(rentalOwner);
		builder.append("]");
		return builder.toString();
	}
	public PropertySubTypeDomain getPropertySubType() {
		return propertySubType;
	}
	public void setPropertySubType(PropertySubTypeDomain propertySubType) {
		this.propertySubType = propertySubType;
	}
	public RentalOwnerDomain getRentalOwner() {
		return rentalOwner;
	}
	public void setRentalOwner(RentalOwnerDomain rentalOwner) {
		this.rentalOwner = rentalOwner;
	}
	
}
