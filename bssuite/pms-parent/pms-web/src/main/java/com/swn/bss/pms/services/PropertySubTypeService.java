/**
 * 
 */
package com.swn.bss.pms.services;

import java.util.List;

import com.swn.bss.pms.entity.PropertySubTypeDomain;

/**
 * @author MrMai
 *
 */
public interface PropertySubTypeService {
	
	public PropertySubTypeDomain savePropertyType(PropertySubTypeDomain domain);	
	
	public PropertySubTypeDomain getPropertyType(Long id);
	
	public List<PropertySubTypeDomain> findRentalOwner(PropertySubTypeDomain domain,
			int firstResult, int maxResult);
	
	public boolean deletePropertyType(Long id);
}
