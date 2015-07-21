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

import com.swn.bss.pms.entity.PropertyTypeDomain;
import com.swn.bss.pms.repositories.PropertyTypeRepository;
import com.swn.bss.pms.services.PropertyTypeService;
import com.swn.bss.pms.specification.PropertyTypeSpecifications;

/**
 * @author MrMai
 *
 */
@Service
@Transactional
public class PropertyTypeServiceImpl implements PropertyTypeService {

	@Autowired
	PropertyTypeRepository propertyTypeRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.PropertyTypeService#savePropertyType(com.swn
	 * .bss.pms.entity.PropertyTypeDomain)
	 */
	public PropertyTypeDomain savePropertyType(PropertyTypeDomain domain) {
		propertyTypeRepository.save(domain);
		return domain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.PropertyTypeService#getPropertyType(java.lang
	 * .Long)
	 */
	public PropertyTypeDomain getPropertyType(Long id) {
		return propertyTypeRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.PropertyTypeService#findRentalOwner(com.swn.
	 * bss.pms.entity.PropertyTypeDomain, int, int)
	 */
	public List<PropertyTypeDomain> findRentalOwner(PropertyTypeDomain domain,
			int firstResult, int maxResult) {
		PageRequest pageRequest = new PageRequest(firstResult / maxResult,
				maxResult);

		Specification<PropertyTypeDomain> codeLikeSpec = PropertyTypeSpecifications
				.codeLike(domain.getName(), 1);

		Specification<PropertyTypeDomain> nameLikeSpec = PropertyTypeSpecifications
				.nameLike(domain.getName(), 1);

		Specification<PropertyTypeDomain> dataActiveSpec = PropertyTypeSpecifications
				.active();
		Specification<PropertyTypeDomain> searchSpec = Specifications
				.where(codeLikeSpec).and(nameLikeSpec).and(dataActiveSpec);

		Page<PropertyTypeDomain> pageResult = propertyTypeRepository.findAll(
				searchSpec, pageRequest);

		return pageResult.getContent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.PropertyTypeService#deletePropertyType(java.
	 * lang.Long)
	 */
	public boolean deletePropertyType(Long id) {
		boolean result = false;
		try {
			PropertyTypeDomain propertyTypeDomain = this.getPropertyType(id);
			propertyTypeDomain.setActive(false);
			this.savePropertyType(propertyTypeDomain);
			result = true;
		} catch (Exception ex) {
			// TODO Remove PrintStackTrace to Logger
			ex.printStackTrace();
		}
		return result;
	}

}
