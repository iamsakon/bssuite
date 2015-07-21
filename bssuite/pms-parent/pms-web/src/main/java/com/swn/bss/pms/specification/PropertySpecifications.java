/**
 * 
 */
package com.swn.bss.pms.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.swn.bss.pms.entity.PropertyDomain;

/**
 * A class which is used to create Specification objects which are used to
 * create JPA criteria queries for PropertyDomain information.
 * 
 * @author MrMai
 *
 */
public class PropertySpecifications {
	
	
	public static Specification<PropertyDomain> codeLike(final String name,
			final long type) {
		return new Specification<PropertyDomain>() {
			public Predicate toPredicate(Root<PropertyDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(name);
				return cb
						.like(cb.lower(root.<String> get("code")), likePattern);
			}
		};
	}
	
	public static Specification<PropertyDomain> nameLike(final String name,
			final long type) {
		return new Specification<PropertyDomain>() {
			public Predicate toPredicate(Root<PropertyDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(name);
				return cb
						.like(cb.lower(root.<String> get("name")), likePattern);
			}
		};
	}

	public static Specification<PropertyDomain> zipcodeLike(final String name,
			final long type) {
		return new Specification<PropertyDomain>() {
			public Predicate toPredicate(Root<PropertyDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(name);
				return cb
						.like(cb.lower(root.<String> get("zipcode")), likePattern);
			}
		};
	}
	
	public static Specification<PropertyDomain> active() {
		return new Specification<PropertyDomain>() {

			public Predicate toPredicate(Root<PropertyDomain> root,
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
