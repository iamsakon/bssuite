/**
 * 
 */
package com.swn.bss.pms.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.swn.bss.pms.entity.RentalOwnerDomain;

/**
 * @author MrMai
 *
 */
@Repository
public interface RentalOwnerRepository extends
		JpaRepository<RentalOwnerDomain, Long>,
		JpaSpecificationExecutor<RentalOwnerDomain> {

	public List<RentalOwnerDomain> findByIsActive(boolean isActive);

	public Page<RentalOwnerDomain> findByIsActive(boolean isActive,
			Pageable page);
}
