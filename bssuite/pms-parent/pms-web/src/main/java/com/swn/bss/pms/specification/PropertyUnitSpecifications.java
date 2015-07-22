/**
 * 
 */
package com.swn.bss.pms.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.swn.bss.pms.entity.PropertyUnitDomain;

/**
 * A class which is used to create Specification objects which are used to
 * create JPA criteria queries for PropertyUnitDomain information.
 * 
 * @author MrMai
 */
public class PropertyUnitSpecifications {

	public static Specification<PropertyUnitDomain> codeLike(final String name,
			final long type) {
		return new Specification<PropertyUnitDomain>() {
			public Predicate toPredicate(Root<PropertyUnitDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(name);
				return cb
						.like(cb.lower(root.<String> get("code")), likePattern);
			}
		};
	}
	
	public static Specification<PropertyUnitDomain> nameLike(final String name,
			final long type) {
		return new Specification<PropertyUnitDomain>() {
			public Predicate toPredicate(Root<PropertyUnitDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(name);
				return cb
						.like(cb.lower(root.<String> get("name")), likePattern);
			}
		};
	}
	
	public static Specification<PropertyUnitDomain> active() {
		return new Specification<PropertyUnitDomain>() {

			public Predicate toPredicate(Root<PropertyUnitDomain> root,
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
