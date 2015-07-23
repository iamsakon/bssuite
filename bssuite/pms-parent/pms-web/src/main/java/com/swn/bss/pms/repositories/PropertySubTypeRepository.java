/**
 * 
 */
package com.swn.bss.pms.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swn.bss.pms.entity.PropertySubTypeDomain;

/**
 * @author MrMai
 *
 */
public interface PropertySubTypeRepository extends
		JpaRepository<PropertySubTypeDomain, Long>,
		JpaSpecificationExecutor<PropertySubTypeDomain> {

	public List<PropertySubTypeDomain> findByIsActive(boolean isActive);
	
}
