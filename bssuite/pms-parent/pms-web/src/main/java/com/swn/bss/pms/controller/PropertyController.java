/**
 * 
 */
package com.swn.bss.pms.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swn.bss.pms.entity.PropertyDomain;
import com.swn.bss.pms.entity.PropertySubTypeDomain;
import com.swn.bss.pms.entity.RentalOwnerDomain;
import com.swn.bss.pms.services.PropertyService;
import com.swn.bss.pms.services.PropertySubTypeService;
import com.swn.bss.pms.services.RentalOwnerService;

/**
 * @author MrMai
 *
 */
@Component
@ManagedBean
@SessionScoped
public class PropertyController extends AbstractMasterController<PropertyDomain> {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3484872012478506846L;

	@Autowired
	PropertyService propertyService;
	@Autowired
	PropertySubTypeService propertySubTypeService;
	@Autowired
	RentalOwnerService rentalOwnerService;
	
	private PropertyDomain selectedValue;

	private PropertyDomain criteria = new PropertyDomain();

	private List<PropertyDomain> datasource;
	
	//**************************
	List<RentalOwnerDomain> listRentalOwnerDomain;
	List<PropertySubTypeDomain> listPropertySubType;
	//**************************
	
	public PropertyController(){
		searchScreen = "../pms-pages/property.xhtml";
		viewScreen = "../pms-pages/propertyView.xhtml";
		editScreen = "../pms-pages/propertyEdit.xhtml";
	}	
	
	@PostConstruct
	public void init(){
		listRentalOwnerDomain = rentalOwnerService.loadAll();
		listPropertySubType = propertySubTypeService.loadAll();
		this.search();
	}
	
	
	public void search() {
		this.load(1, 10, null, null, null);
	}

	public void openViewMode() {
		this.setCurrentView(this.searchScreen);
	}

	public void openViewMode(PropertyDomain selectedValue) {
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
		this.selectedValue = new PropertyDomain();
		this.setCurrentView(this.editScreen);
	}
	
	public void saveRentalOwner() {
		if (this.selectedValue != null) {
			propertyService.saveProperty(this.selectedValue);
			this.openSearch();
		}
	}

	public void reset() {
		criteria = new PropertyDomain();
		this.search();
	}
	
	@Override
	public PropertyDomain getRowData(String rowKey) {
		for (PropertyDomain domain : datasource) {
			if (("" + domain.getOid()).equals(rowKey))
				return domain;
		}
		return null;
	}

	@Override
	public Object getRowKey(PropertyDomain domain) {
		return domain.getOid();
	}

	public int getRowCount() {
		//TOOD getRowCount()
		return 1;
	}

	@Override
	public List<PropertyDomain> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		datasource = propertyService.findProperty(criteria, first,
				pageSize);
		// TODO Add Feature filters
		// TODO Add Feature sortOrder
		return datasource;
	}

	public PropertyService getPropertyService() {
		return propertyService;
	}

	public void setPropertyService(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	public PropertyDomain getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(PropertyDomain selectedValue) {
		this.selectedValue = selectedValue;
	}

	public PropertyDomain getCriteria() {
		return criteria;
	}

	public void setCriteria(PropertyDomain criteria) {
		this.criteria = criteria;
	}

	public List<PropertyDomain> getDatasource() {
		return datasource;
	}

	public void setDatasource(List<PropertyDomain> datasource) {
		this.datasource = datasource;
	}

	public List<RentalOwnerDomain> getListRentalOwnerDomain() {
		return listRentalOwnerDomain;
	}

	public void setListRentalOwnerDomain(
			List<RentalOwnerDomain> listRentalOwnerDomain) {
		this.listRentalOwnerDomain = listRentalOwnerDomain;
	}

	public List<PropertySubTypeDomain> getListPropertySubType() {
		return listPropertySubType;
	}

	public void setListPropertySubType(
			List<PropertySubTypeDomain> listPropertySubType) {
		this.listPropertySubType = listPropertySubType;
	}
}
