/**
 * 
 */
package com.swn.bss.pms.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swn.bss.pms.entity.PropertyDomain;
import com.swn.bss.pms.entity.RentalOwnerDomain;
import com.swn.bss.pms.repositories.PropertyRepository;
import com.swn.bss.pms.services.PropertyService;
import com.swn.bss.pms.specification.PropertySpecifications;

/**
 * @author MrMai
 *
 */
@Service
@Transactional
public class PropertyServiceImpl extends AbstractPmsServiceImpl implements
		PropertyService {

	@Autowired
	PropertyRepository propertyRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.PropertyService#saveProperty(com.swn.bss.pms
	 * .entity.PropertyDomain)
	 */
	public PropertyDomain saveProperty(PropertyDomain domain) {
		domain = (PropertyDomain) (domain.getOid() == null ? this
				.assemblyCreateAuditor(domain) : this
				.assemblyUpdateAuditor(domain));
		propertyRepository.save(domain);
		return domain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.PropertyService#getPropertyType(java.lang.Long)
	 */
	public PropertyDomain getProperty(Long id) {
		return propertyRepository.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.PropertyService#findProperty(com.swn.bss.pms
	 * .entity.PropertyDomain, int, int)
	 */
	public Page<PropertyDomain> findProperty(PropertyDomain domain,
			int firstResult, int maxResult) {
		PageRequest pageRequest = new PageRequest(firstResult / maxResult,
				maxResult);

		Specification<PropertyDomain> codeLikeSpec = null;
		if (domain != null && domain.getCode() != null
				&& !domain.getCode().equals(""))
			codeLikeSpec = PropertySpecifications.codeLike(domain.getCode(), 1);

		Specification<PropertyDomain> nameLikeSpec = null;
		if (domain != null && domain.getName() != null
				&& !domain.getName().equals(""))
			nameLikeSpec = PropertySpecifications.nameLike(domain.getName(), 1);

		Specification<PropertyDomain> zipcodeLikeSpec = PropertySpecifications
				.zipcodeLike(domain.getZipcode(), 1);

		Specification<PropertyDomain> dataActiveSpec = PropertySpecifications
				.active();

		Specification<PropertyDomain> joinRentalOwner = PropertySpecifications
				.joinRentalOwner(domain.getRentalOwner());

		Specification<PropertyDomain> joinPropertySubType = PropertySpecifications
				.joinPropertySubType(domain.getPropertySubType());

		Specification<PropertyDomain> searchSpec = Specifications
				.where(codeLikeSpec).and(nameLikeSpec).and(zipcodeLikeSpec)
				.and(dataActiveSpec);

		Page<PropertyDomain> pageResult = propertyRepository.findAll(
				searchSpec, pageRequest);

		return pageResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.PropertyService#deleteProperty(java.lang.Long)
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
