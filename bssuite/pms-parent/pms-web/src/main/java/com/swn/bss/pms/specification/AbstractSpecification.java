package com.swn.bss.pms.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class AbstractSpecification {

	public static Predicate and(CriteriaBuilder cb,List<Predicate> predicates){	
		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}
	
	public static Predicate createPredicate(Root<?> root,CriteriaBuilder cb,String name,String value){
		Predicate predicate = null;
		if(value != null){
			if(value.contains("%")){
				predicate = cb.like(cb.lower(root.<String> get(name)), value);
			}else{
				predicate = cb.equal(root.get(name), value);
			}
		}
		return predicate;
	}
	
	public static String getLikePattern(final String searchTerm) {
		StringBuilder pattern = new StringBuilder("%");
		pattern.append((searchTerm == null ? "" : searchTerm).toLowerCase());
		pattern.append("%");
		return pattern.toString();
	}
	
}
