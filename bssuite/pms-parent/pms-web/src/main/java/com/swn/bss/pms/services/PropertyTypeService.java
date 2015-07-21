/**
 * 
 */
package com.swn.bss.pms.services;

import java.util.List;

import com.swn.bss.pms.entity.PropertyTypeDomain;

/**
 * @author MrMai
 *
 */
public interface PropertyTypeService {

	public PropertyTypeDomain savePropertyType(PropertyTypeDomain domain);	
	
	public PropertyTypeDomain getPropertyType(Long id);
	
	public List<PropertyTypeDomain> findPropertyType(PropertyTypeDomain domain,
			int firstResult, int maxResult);
	
	public boolean deletePropertyType(Long id);
}
