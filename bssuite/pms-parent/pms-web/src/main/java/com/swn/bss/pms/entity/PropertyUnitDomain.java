/**
 * 
 */
package com.swn.bss.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author sakon
 *
 */
@Entity
@Table(name = "pms_property_unit")
@SequenceGenerator(name = "SEQ_PMS_PROPERTY_UNIT", sequenceName = "seq_pms_property_unit")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PropertyUnitDomain extends AbstractPmsDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8208243682411807206L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long oid;
	/**
	 * Property Unit Code
	 */
	@NotNull
	@Column(name = "code")
	@Size(max = 128)
	private String code;
	/**
	 * Property Unit name
	 */
	@NotNull
	@Column(name = "name")
	@Size(max = 128)
	private String name;
	
	@Column(name = "market_rent")
	private double marketRent;
    /**
     * Property Unit description
     */
    @NotNull
    @Column(name = "description")
    @Size(max = 128)
	private String description;
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
	public double getMarketRent() {
		return marketRent;
	}
	public void setMarketRent(double marketRent) {
		this.marketRent = marketRent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		long temp;
		temp = Double.doubleToLongBits(marketRent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
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
		PropertyUnitDomain other = (PropertyUnitDomain) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Double.doubleToLongBits(marketRent) != Double
				.doubleToLongBits(other.marketRent))
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
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropertyUnitDomain [oid=");
		builder.append(oid);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", marketRent=");
		builder.append(marketRent);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
}
