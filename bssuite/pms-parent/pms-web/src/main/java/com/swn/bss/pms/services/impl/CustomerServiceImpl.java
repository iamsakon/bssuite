/**
 * 
 */
package com.swn.bss.pms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swn.bss.pms.entity.CustomerDomain;
import com.swn.bss.pms.repositories.CustomerRepository;
import com.swn.bss.pms.services.CustomerService;
import com.swn.bss.pms.specification.CustomerSpecification;

/**
 * @author MrMai
 *
 */
@Service
@Transactional
public class CustomerServiceImpl extends AbstractPmsServiceImpl implements
		CustomerService {

	@Autowired
	CustomerRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.CustomerService#saveCustomer(com.swn.bss.pms
	 * .entity.CustomerDomain)
	 */
	public CustomerDomain saveCustomer(CustomerDomain domain) {
		domain = (CustomerDomain) (domain.getOid() == null ? this
				.assemblyCreateAuditor(domain) : this
				.assemblyUpdateAuditor(domain));
		repository.save(domain);
		return domain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.swn.bss.pms.services.CustomerService#getCustomer(java.lang.Long)
	 */
	public CustomerDomain getCustomer(Long id) {
		return repository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.CustomerService#findCustomer(com.swn.bss.pms
	 * .entity.CustomerDomain, int, int)
	 */
	public Page<CustomerDomain> findCustomer(CustomerDomain domain,
			int firstResult, int maxResult) {
		PageRequest pageRequest = new PageRequest(firstResult / maxResult,
				maxResult);
		Page<CustomerDomain> pageResult = repository.findAll(CustomerSpecification.customer(domain), pageRequest);
		return pageResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.CustomerService#deleteCustomer(java.lang.Long)
	 */
	public boolean deleteCustomer(Long id) {
		boolean result = false;
		try {
			CustomerDomain obj = this.getCustomer(id);
			obj.setActive(false);
			this.saveCustomer(obj);
			result = true;
		} catch (Exception ex) {
			// TODO Remove PrintStackTrace to Logger
			ex.printStackTrace();
		}
		return result;
	}

}
