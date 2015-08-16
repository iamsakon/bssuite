/**
 * 
 */
package com.swn.bss.pms.services;

import org.springframework.data.domain.Page;

import com.swn.bss.pms.entity.CustomerDomain;

/**
 * @author MrMai
 *
 */
public interface CustomerService {
	
	public CustomerDomain saveCustomer(CustomerDomain domain);

	public CustomerDomain getCustomer(Long id);

	public Page<CustomerDomain> findCustomer(CustomerDomain domain,
			int firstResult, int maxResult);

	public boolean deleteCustomer(Long id);
}
