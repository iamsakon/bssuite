/**
 * 
 */
package com.swn.bss.pms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swn.bss.pms.entity.PropertyDomain;

/**
 * @author MrMai
 *
 */
public interface PropertyRepository extends
		JpaRepository<PropertyDomain, Long>,
		JpaSpecificationExecutor<PropertyDomain> {
	
	public List<PropertyDomain> findByIsActive(boolean isActive);
}
