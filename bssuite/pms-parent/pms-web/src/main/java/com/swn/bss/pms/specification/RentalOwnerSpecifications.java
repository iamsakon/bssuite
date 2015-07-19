package com.swn.bss.pms.specification;

import javax.persistence.criteria.*;

import org.springframework.data.jpa.domain.Specification;
import com.swn.bss.pms.entity.*;

/**
 * A class which is used to create Specification objects which are used to
 * create JPA criteria queries for RentalOwnerDomain information.
 * 
 * @author MrMai
 */
public class RentalOwnerSpecifications {

	public static Specification<RentalOwnerDomain> nameLike(final String name,
			final long type) {
		return new Specification<RentalOwnerDomain>() {
			public Predicate toPredicate(Root<RentalOwnerDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(name);
				return cb
						.like(cb.lower(root.<String> get("name")), likePattern);
			}
		};
	}

	public static Specification<RentalOwnerDomain> lastNameLike(
			final String lastName, final long type) {
		return new Specification<RentalOwnerDomain>() {
			public Predicate toPredicate(Root<RentalOwnerDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(lastName);
				return cb.like(cb.lower(root.<String> get("lastName")),
						likePattern);
			}
		};
	}

	public static Specification<RentalOwnerDomain> primaryEmailLike(
			final String primaryEmail, final long type) {
		return new Specification<RentalOwnerDomain>() {
			public Predicate toPredicate(Root<RentalOwnerDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(primaryEmail);
				return cb.like(cb.lower(root.<String> get("primaryEmail")),
						likePattern);
			}
		};
	}

	public static Specification<RentalOwnerDomain> mobileNumberLike(
			final String mobileNumber, final long type) {
		return new Specification<RentalOwnerDomain>() {
			public Predicate toPredicate(Root<RentalOwnerDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(mobileNumber);
				return cb.like(cb.lower(root.<String> get("mobileNumber")),
						likePattern);
			}
		};
	}

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
