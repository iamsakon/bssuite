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

import com.swn.bss.pms.entity.RentalOwnerDomain;
import com.swn.bss.pms.repositories.RentalOwnerRepository;
import com.swn.bss.pms.services.RentalOwnerService;
import com.swn.bss.pms.specification.RentalOwnerSpecifications;

/**
 * @author MrMai
 *
 */
@Service
@Transactional
public class RentalOwnerServiceImpl extends AbstractPmsServiceImpl implements RentalOwnerService {

	@Autowired
	RentalOwnerRepository rentalOwnerRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.RentalOwnerService#saveRentalOwner(com.swn.bss
	 * .pms.entity.RentalOwnerDomain)
	 */
	public RentalOwnerDomain saveRentalOwner(RentalOwnerDomain domain) {
		domain =(RentalOwnerDomain) (domain.getOid()==null?this.assemblyCreateAuditor(domain):this.assemblyUpdateAuditor(domain));
		return rentalOwnerRepository.saveAndFlush(domain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.RentalOwnerService#updateRentalOwner(com.swn
	 * .bss.pms.entity.RentalOwnerDomain)
	 */
	public RentalOwnerDomain updateRentalOwner(
			RentalOwnerDomain rentalOwnerDomain) {
		return rentalOwnerRepository.saveAndFlush(rentalOwnerDomain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.RentalOwnerService#deleteRentalOwner(com.swn
	 * .bss.pms.entity.RentalOwnerDomain)
	 */
	public boolean deleteRentalOwner(long oid) {
		boolean result = false;
		if (rentalOwnerRepository.exists(oid)) {
			RentalOwnerDomain domain = rentalOwnerRepository.findOne(oid);
			domain.setActive(false);
			this.updateRentalOwner(domain);
			result = true;
		} else {

		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.swn.bss.pms.services.RentalOwnerService#findRentalOwner(java.lang
	 * .Long)
	 */
	public RentalOwnerDomain findRentalOwner(Long oid) {
		return rentalOwnerRepository.findOne(oid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.swn.bss.pms.services.RentalOwnerService#countActiveRentalOwner()
	 */
	public long countActiveRentalOwner() {
		// TODO RentalOwnerServiceImpl.countActiveRentalOwner Auto-generated
		// method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.swn.bss.pms.services.RentalOwnerService#findActiveRentalOwner()
	 */
	public List<RentalOwnerDomain> findActiveRentalOwner() {
		return rentalOwnerRepository.findByIsActive(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.swn.bss.pms.services.RentalOwnerService#findRentalOwner(int,
	 * int)
	 */
	public List<RentalOwnerDomain> findRentalOwner(int firstResult,
			int maxResults) {
		return rentalOwnerRepository.findByIsActive(
				true,
				new org.springframework.data.domain.PageRequest(firstResult
						/ maxResults, maxResults)).getContent();
	}

	public Page<RentalOwnerDomain> findRentalOwner(RentalOwnerDomain domain,
			int firstResult, int maxResults) {
		PageRequest pageRequest = new PageRequest(firstResult / maxResults,
				maxResults);
		Specification<RentalOwnerDomain> nameLikeSpec = RentalOwnerSpecifications
				.nameLike(domain.getName(), 1);
		Specification<RentalOwnerDomain> lastNameLikeSpec = RentalOwnerSpecifications
				.lastNameLike(domain.getLastName(), 1);
		Specification<RentalOwnerDomain> emailLikeSpec = RentalOwnerSpecifications
				.primaryEmailLike(domain.getPrimaryEmail(), 1);
		Specification<RentalOwnerDomain> mobileNumberSpec = RentalOwnerSpecifications
				.mobileNumberLike(domain.getMobileNumber(), 1);
		Specification<RentalOwnerDomain> dataActiveSpec = RentalOwnerSpecifications
				.active();

		Specifications<RentalOwnerDomain> searchSpec = Specifications
				.where(nameLikeSpec).and(lastNameLikeSpec).and(emailLikeSpec)
				.and(mobileNumberSpec).and(dataActiveSpec);

		Page<RentalOwnerDomain> pageResult = rentalOwnerRepository.findAll(
				searchSpec, pageRequest);
		return pageResult;
	}

	public List<RentalOwnerDomain> loadAll() {
		return rentalOwnerRepository.findByIsActive(true);
	}

}
