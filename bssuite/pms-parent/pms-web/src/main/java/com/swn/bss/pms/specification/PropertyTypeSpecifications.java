/**
 * 
 */
package com.swn.bss.pms.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.swn.bss.pms.entity.RentalOwnerDomain;

/**
 * * A class which is used to create Specification objects which are used to
 * create JPA criteria queries for Property Type information.
 * 
 * @author MrMai
 */
public class PropertyTypeSpecifications {

	public static Specification<RentalOwnerDomain> active() {
		return new Specification<RentalOwnerDomain>() {

			public Predicate toPredicate(Root<RentalOwnerDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("isActive"), true);
			}

		};
	}

	private static String getLikePattern(final String searchTerm) {
		StringBuilder pattern = new StringBuilder();
		pattern.append((searchTerm == null ? "" : searchTerm).toLowerCase());
		pattern.append("%");
		return pattern.toString();
	}
}
