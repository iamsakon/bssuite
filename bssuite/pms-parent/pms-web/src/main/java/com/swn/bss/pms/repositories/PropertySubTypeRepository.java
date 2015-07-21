/**
 * 
 */
package com.swn.bss.pms.repositories;

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

}
