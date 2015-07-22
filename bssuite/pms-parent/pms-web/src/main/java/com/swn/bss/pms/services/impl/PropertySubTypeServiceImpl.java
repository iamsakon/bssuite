/**
 * 
 */
package com.swn.bss.pms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swn.bss.pms.entity.PropertySubTypeDomain;
import com.swn.bss.pms.repositories.PropertySubTypeRepository;
import com.swn.bss.pms.services.PropertySubTypeService;
import com.swn.bss.pms.specification.PropertySubTypeSpecifications;

/**
 * @author MrMai
 *
 */
@Service
@Transactional
public class PropertySubTypeServiceImpl implements PropertySubTypeService {

	@Autowired
	PropertySubTypeRepository propertySubTypeRepository;
	
	/* (non-Javadoc)
	 * @see com.swn.bss.pms.services.PropertySubTypeService#savePropertySubType(com.swn.bss.pms.entity.PropertySubTypeDomain)
	 */
	public PropertySubTypeDomain savePropertySubType(PropertySubTypeDomain domain) {
		propertySubTypeRepository.save(domain);
		return domain;
	}

	/* (non-Javadoc)
	 * @see com.swn.bss.pms.services.PropertySubTypeService#getPropertySubType(java.lang.Long)
	 */
	public PropertySubTypeDomain getPropertySubType(Long id) {
		return propertySubTypeRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.swn.bss.pms.services.PropertySubTypeService#PropertySubType(com.swn.bss.pms.entity.PropertySubTypeDomain, int, int)
	 */
	public List<PropertySubTypeDomain> findPropertySubType(
			PropertySubTypeDomain domain, int firstResult, int maxResult) {
		PageRequest pageRequest = new PageRequest(firstResult / maxResult,
				maxResult);

		Specification<PropertySubTypeDomain> codeLikeSpec = PropertySubTypeSpecifications
				.codeLike(domain.getName(), 1);

		Specification<PropertySubTypeDomain> nameLikeSpec = PropertySubTypeSpecifications
				.nameLike(domain.getName(), 1);

		Specification<PropertySubTypeDomain> dataActiveSpec = PropertySubTypeSpecifications
				.active();
		Specification<PropertySubTypeDomain> searchSpec = Specifications
				.where(codeLikeSpec).and(nameLikeSpec).and(dataActiveSpec);

		Page<PropertySubTypeDomain> pageResult = propertySubTypeRepository.findAll(
				searchSpec, pageRequest);

		return pageResult.getContent();
	}

	/* (non-Javadoc)
	 * @see com.swn.bss.pms.services.PropertySubTypeService#deletePropertySubType(java.lang.Long)
	 */
	public boolean deletePropertySubType(Long id) {
		boolean result = false;
		try {
			PropertySubTypeDomain propertySubTypeDomain = this.getPropertySubType(id);
			propertySubTypeDomain.setActive(false);
			this.savePropertySubType(propertySubTypeDomain);
			result = true;
		} catch (Exception ex) {
			// TODO Remove PrintStackTrace to Logger
			ex.printStackTrace();
		}
		return result;
	}

}
