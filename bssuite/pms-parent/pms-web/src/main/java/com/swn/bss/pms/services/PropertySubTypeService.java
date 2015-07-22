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
	
	public PropertySubTypeDomain savePropertySubType(PropertySubTypeDomain domain);	
	
	public PropertySubTypeDomain getPropertySubType(Long id);
	
	public List<PropertySubTypeDomain> findPropertySubType(PropertySubTypeDomain domain,
			int firstResult, int maxResult);
	
	public boolean deletePropertySubType(Long id);
}
