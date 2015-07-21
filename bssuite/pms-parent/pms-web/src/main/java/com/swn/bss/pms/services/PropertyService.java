package com.swn.bss.pms.services;

import java.util.List;

import com.swn.bss.pms.entity.PropertyDomain;

/**
 * @author MrMai
 *
 */
public interface PropertyService {
	public PropertyDomain saveProperty(PropertyDomain domain);

	public PropertyDomain getProperty(Long id);

	public List<PropertyDomain> findProperty(
PropertyDomain domain, int firstResult, int maxResult);

	public boolean deleteProperty(Long id);
}
