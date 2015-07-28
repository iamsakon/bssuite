package com.swn.bss.pms.services;

import org.springframework.data.domain.Page;

import com.swn.bss.pms.entity.PropertyDomain;

/**
 * @author MrMai
 *
 */
public interface PropertyService {
	public PropertyDomain saveProperty(PropertyDomain domain);

	public PropertyDomain getProperty(Long id);

	public Page<PropertyDomain> findProperty(
PropertyDomain domain, int firstResult, int maxResult);

	public boolean deleteProperty(Long id);
}
