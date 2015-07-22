/**
 * 
 */
package com.swn.bss.pms.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.swn.bss.pms.entity.PropertyTypeDomain;

/**
 * A class which is used to create Specification objects which are used to
 * create JPA criteria queries for PropertyTypeDomain information.
 * 
 * @author MrMai
 */
public class PropertyTypeSpecifications {

	public static Specification<PropertyTypeDomain> codeLike(final String name,
			final long type) {
		return new Specification<PropertyTypeDomain>() {
			public Predicate toPredicate(Root<PropertyTypeDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(name);
				return cb
						.like(cb.lower(root.<String> get("code")), likePattern);
			}
		};
	}
	
	public static Specification<PropertyTypeDomain> nameLike(final String name,
			final long type) {
		return new Specification<PropertyTypeDomain>() {
			public Predicate toPredicate(Root<PropertyTypeDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(name);
				return cb
						.like(cb.lower(root.<String> get("name")), likePattern);
			}
		};
	}
	
	public static Specification<PropertyTypeDomain> active() {
		return new Specification<PropertyTypeDomain>() {

			public Predicate toPredicate(Root<PropertyTypeDomain> root,
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
