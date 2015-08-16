/**
 * 
 */
package com.swn.bss.pms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swn.bss.pms.entity.CustomerDomain;

/**
 * @author MrMai
 *
 */
public interface CustomerRepository extends
		JpaRepository<CustomerDomain, Long>,
		JpaSpecificationExecutor<CustomerDomain> {

}
