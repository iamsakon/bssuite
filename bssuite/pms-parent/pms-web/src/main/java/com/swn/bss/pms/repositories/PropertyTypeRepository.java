package com.swn.bss.pms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.swn.bss.pms.entity.PropertyTypeDomain;
import com.swn.bss.pms.entity.RentalOwnerDomain;

public interface PropertyTypeRepository extends
		JpaRepository<PropertyTypeDomain, Long>,
		JpaSpecificationExecutor<RentalOwnerDomain> {

}
