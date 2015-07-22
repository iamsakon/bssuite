/**
 * 
 */
package com.swn.bss.pms.services;

import java.util.List;

import com.swn.bss.pms.entity.PropertyUnitDomain;

/**
 * @author sakon
 *
 */
public interface PropertyUnitService {
	public PropertyUnitDomain savePropertyUnit(PropertyUnitDomain domain);

	public PropertyUnitDomain getPropertyUnit(Long id);

	public List<PropertyUnitDomain> findPropertyUnit(PropertyUnitDomain domain,
			int firstResult, int maxResult);

	public boolean deletePropertyUnit(Long id);
}
