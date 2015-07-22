/**
 * 
 */
package com.swn.bss.pms.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.swn.bss.pms.entity.RentalOwnerDomain;
import com.swn.bss.pms.services.RentalOwnerService;

/**
 * @author MrMai
 *
 */
@Component
@ManagedBean
@SessionScoped
public class RentalOwnerController extends AbstractMasterController<RentalOwnerDomain>
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4505793523777164945L;
	
	private String searchScreen = "../pms-pages/rentalOwner.xhtml";
	
	private String viewScreen = "../pms-pages/rentalOwnerView.xhtml";
	
	private String editScreen = "../pms-pages/rentalOwnerEdit.xhtml";
	
	private String backScreen = "";

	@Autowired
	RentalOwnerService rentalOwnerService;

	private RentalOwnerDomain selectedValue;

	private RentalOwnerDomain criteria = new RentalOwnerDomain();

	private List<RentalOwnerDomain> datasource;

	@PostConstruct
	public void search() {
		this.load(1, 10, null, null, null);
	}

	public void openViewMode() {
		this.setCurrentView(this.searchScreen);
	}

	public void openViewMode(RentalOwnerDomain selectedValue) {
		this.selectedValue = selectedValue;
		this.setCurrentView(this.viewScreen);
	}

	public void openSearch() {
		this.setCurrentView(this.searchScreen);
	}

	public void openEdit() {
		if (this.selectedValue != null && this.selectedValue.getOid() > 0) {
			this.setCurrentView(this.editScreen);
		}else{
			//TODO In case selectedValue == null or oid = 0
		}
	}

	public void openCreate() {
		this.selectedValue = new RentalOwnerDomain();
		this.setCurrentView(this.editScreen);
	}
	
	public void goBack(){
		this.setCurrentView(this.backScreen);
	}

	public void saveRentalOwner() {
		if (this.selectedValue != null) {
			rentalOwnerService.saveRentalOwner(this.selectedValue);
			this.openSearch();
		}
	}

	public void reset() {
		criteria = new RentalOwnerDomain();
		this.search();
	}

	public RentalOwnerService getRentalOwnerService() {
		return rentalOwnerService;
	}

	public void setRentalOwnerService(RentalOwnerService rentalOwnerService) {
		this.rentalOwnerService = rentalOwnerService;
	}

	public List<RentalOwnerDomain> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<RentalOwnerDomain> datasource) {
		this.datasource = datasource;
	}

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

	public int getRowCount() {
		return 1;
	}

	@Override
	public List<RentalOwnerDomain> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		// datasource = rentalOwnerService.findRentalOwner(first, pageSize);
		datasource = rentalOwnerService.findRentalOwner(criteria, first,
				pageSize);
		// TODO Add Feature filters
		// TODO Add Feature sortOrder
		return datasource;
	}

	public RentalOwnerDomain getCriteria() {
		return criteria;
	}

	public void setCriteria(RentalOwnerDomain criteria) {
		this.criteria = criteria;
	}

	public RentalOwnerDomain getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(RentalOwnerDomain selectedValue) {
		this.selectedValue = selectedValue;
	}

}
