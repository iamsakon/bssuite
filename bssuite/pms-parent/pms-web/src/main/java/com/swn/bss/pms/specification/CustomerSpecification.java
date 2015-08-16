/**
 * 
 */
package com.swn.bss.pms.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.swn.bss.pms.entity.CustomerDomain;

import java.util.List;
import java.util.ArrayList;
/**
 * A class which is used to create Specification objects which are used to
 * create JPA criteria queries for CustomerDomain information.
 * 
 * @author MrMai
 *
 */
public class CustomerSpecification extends AbstractSpecification{

	public static Specification<CustomerDomain> customer(final CustomerDomain domain) {
		return new Specification<CustomerDomain>() {
			public Predicate toPredicate(Root<CustomerDomain> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicateReturn = null;
				List<Predicate> list = new ArrayList<Predicate>();
				if(domain.getName() != null){
					String nameLikePattern = getLikePattern(domain.getName());
					Predicate name  = createPredicate(root,cb,"name",nameLikePattern);
					list.add(name);
				}
				if(domain.getSurname() != null){
					String surNameLikePattern = getLikePattern(domain.getSurname());
					Predicate surname = createPredicate(root,cb,"surName",surNameLikePattern);
					list.add(surname);
				}
				if(list.size()>0)
					predicateReturn = and(cb,list);
				return predicateReturn;
			}
		};
	}
	
}
