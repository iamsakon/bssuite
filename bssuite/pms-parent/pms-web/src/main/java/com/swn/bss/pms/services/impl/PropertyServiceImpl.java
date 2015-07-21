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

import com.swn.bss.pms.entity.PropertyDomain;
import com.swn.bss.pms.repositories.PropertyRepository;
import com.swn.bss.pms.services.PropertyService;
import com.swn.bss.pms.specification.PropertySpecifications;

/**
 * @author MrMai
 *
 */
@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	PropertyRepository propertyRepository;
	
	/* (non-Javadoc)
	 * @see com.swn.bss.pms.services.PropertyService#saveProperty(com.swn.bss.pms.entity.PropertyDomain)
	 */
	public PropertyDomain saveProperty(PropertyDomain domain) {
		propertyRepository.save(domain);
		return domain;
	}

	/* (non-Javadoc)
	 * @see com.swn.bss.pms.services.PropertyService#getPropertyType(java.lang.Long)
	 */
	public PropertyDomain getProperty(Long id) {
		return propertyRepository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.swn.bss.pms.services.PropertyService#findProperty(com.swn.bss.pms.entity.PropertyDomain, int, int)
	 */
	public List<PropertyDomain> findProperty(PropertyDomain domain,
			int firstResult, int maxResult) {
		PageRequest pageRequest = new PageRequest(firstResult / maxResult,
				maxResult);

		Specification<PropertyDomain> codeLikeSpec = PropertySpecifications
				.codeLike(domain.getName(), 1);

		Specification<PropertyDomain> nameLikeSpec = PropertySpecifications
				.nameLike(domain.getName(), 1);

		Specification<PropertyDomain> zipcodeLikeSpec = PropertySpecifications
				.zipcodeLike(domain.getName(), 1);
		
		Specification<PropertyDomain> dataActiveSpec = PropertySpecifications
				.active();
		Specification<PropertyDomain> searchSpec = Specifications
				.where(codeLikeSpec).and(nameLikeSpec).and(zipcodeLikeSpec).and(dataActiveSpec);

		Page<PropertyDomain> pageResult = propertyRepository.findAll(
				searchSpec, pageRequest);

		return pageResult.getContent();
	}

	/* (non-Javadoc)
	 * @see com.swn.bss.pms.services.PropertyService#deleteProperty(java.lang.Long)
	 */
	public boolean deleteProperty(Long id) {
		boolean result = false;
		try {
			PropertyDomain obj = this.getProperty(id);
			obj.setActive(false);
			this.saveProperty(obj);
			result = true;
		} catch (Exception ex) {
			// TODO Remove PrintStackTrace to Logger
			ex.printStackTrace();
		}
		return result;
	}

}
