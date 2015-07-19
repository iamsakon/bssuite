/**
 * 
 */
package com.swn.bss.pms.controller.lazy;

import java.util.List;
import java.util.Map;
import org.primefaces.model.SortOrder;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;

import com.swn.bss.pms.entity.RentalOwnerDomain;
import com.swn.bss.pms.services.RentalOwnerService;

/**
 * @author MrMai
 *
 */
public class LazyRentalOwnerDataModel extends LazyDataModel<RentalOwnerDomain> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9126930711225566086L;

	@Autowired
	RentalOwnerService rentalOwnerService;

	private List<RentalOwnerDomain> datasource;

	@Override
	public RentalOwnerDomain getRowData(String rowKey) {
		for (RentalOwnerDomain domain : datasource) {
			if (("" + domain.getOid()).equals(rowKey))
				return domain;
		}

		return null;
	}

	@Override
	public Object getRowKey(RentalOwnerDomain domain) {
		return domain.getOid();
	}

	@Override
	public List<RentalOwnerDomain> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		datasource = rentalOwnerService.findRentalOwner(first, pageSize);
		// TODO Add Feature filters
		// TODO Add Feature sortOrder
		return datasource;
	}
}
