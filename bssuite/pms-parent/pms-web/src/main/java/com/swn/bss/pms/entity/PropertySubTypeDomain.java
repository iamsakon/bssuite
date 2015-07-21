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
 * @author MrMai
 *
 */
@Entity
@Table(name = "pms_property_sub_type")
@SequenceGenerator(name = "SEQ_PMS_PROPERTY_SUB_TYPE", sequenceName = "seq_pms_property_sub_type")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PropertySubTypeDomain extends AbstractPmsDomain {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4459180466649860537L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long oid;
	
	/**
     * Property Sub Type Code
     */
    @NotNull
    @Column(name = "code")
    @Size(max = 128)
    private String code;

    /**
     * Property Sub Type Name
     */
    @NotNull
    @Column(name = "name")
    @Size(max = 128)
    private String name;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PropertySubTypeDomain [oid=");
		builder.append(oid);
		builder.append(", code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		PropertySubTypeDomain other = (PropertySubTypeDomain) obj;
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
		return true;
	}
}
