/**
 * 
 */
package com.swn.bss.pms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swn.bss.pms.entity.PropertyUnitDomain;

/**
 * @author sakon
 *
 */
public interface PropertyUnitRepository extends
		JpaRepository<PropertyUnitDomain, Long>,
		JpaSpecificationExecutor<PropertyUnitDomain> {

}
