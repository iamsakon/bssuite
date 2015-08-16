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

/**
 * @author MrMai
 *
 */
@Entity
@Table(name = "pms_customer")
@SequenceGenerator(name = "SEQ_PMS_CUSTOMER", sequenceName = "seq_pms_customer")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CustomerDomain extends AbstractPmsDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8772852097038672983L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long oid;
	
	@Column
	private String name;
	
	@Column
	private String surname;

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	 
}
