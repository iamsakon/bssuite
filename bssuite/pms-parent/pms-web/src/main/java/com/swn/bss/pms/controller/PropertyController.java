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
import org.springframework.data.domain.Page;
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
public class PropertyController extends
		AbstractMasterController<PropertyDomain> {
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

	private PropertyDomain criteria = null;
	private RentalOwnerDomain criteriaRentalOwner = null;
	private PropertySubTypeDomain criteriaPropertySubType = null;

	private Page<PropertyDomain> pageResult;

	// **************************
	List<RentalOwnerDomain> listRentalOwner;
	List<PropertySubTypeDomain> listPropertySubType;

	// **************************

	public PropertyController() {
		searchScreen = "../pms-pages/property.xhtml";
		viewScreen = "../pms-pages/propertyView.xhtml";
		editScreen = "../pms-pages/propertyEdit.xhtml";
	}

	@PostConstruct
	public void init() {
		criteria = new PropertyDomain();
		criteriaRentalOwner = new RentalOwnerDomain();
		criteriaPropertySubType = new PropertySubTypeDomain();
		criteria.setRentalOwner(criteriaRentalOwner);
		criteria.setPropertySubType(criteriaPropertySubType);
		listRentalOwner = rentalOwnerService.loadAll();
		listPropertySubType = propertySubTypeService.loadAll();
	}

	public void search() {

	}

	public void openViewMode() {
		this.setCurrentView(this.viewScreen);
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
		} else {
			// TODO In case selectedValue == null or oid = 0
		}
	}

	public void openCreate() {
		this.selectedValue = new PropertyDomain();
		this.setCurrentView(this.editScreen);
	}

	public void saveProperty() {
		Object[] params = {"Property"};
		if (this.selectedValue != null) {
			boolean flagNew = this.selectedValue.getOid() == null?true:false;
			propertyService.saveProperty(this.selectedValue);
			this.info(flagNew?this.createSuccessMessageId:this.updateSuccessMessageId, params);
			this.openViewMode();
		}
	}

	public void deleteProperty(PropertyDomain domain){
		Object[] params = {"Property"};
		if(domain != null){
			rentalOwnerService.deleteRentalOwner(domain.getOid());
			this.info(this.deleteSuccessMessageId, params);
		}
	}
	
	public void reset() {
		criteria = new PropertyDomain();
		this.init();
	}

	@Override
	public PropertyDomain getRowData(String rowKey) {
		if (pageResult != null && pageResult.getContent() != null) {
			for (PropertyDomain domain : pageResult.getContent()) {
				if (("" + domain.getOid()).equals(rowKey))
					return domain;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(PropertyDomain domain) {
		return domain.getOid();
	}

	public int getRowCount() {
		return pageResult != null ? pageResult.getNumberOfElements() : 0;
	}

	@Override
	public List<PropertyDomain> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
				
		pageResult = propertyService.findProperty(criteria, first, pageSize);
		// TODO Add Feature filters
		// TODO Add Feature sortOrder
		return pageResult.getContent();
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

	public List<RentalOwnerDomain> getListRentalOwner() {
		return listRentalOwner;
	}

	public void setListRentalOwnerDomain(
			List<RentalOwnerDomain> listRentalOwner) {
		this.listRentalOwner = listRentalOwner;
	}

	public List<PropertySubTypeDomain> getListPropertySubType() {
		return listPropertySubType;
	}

	public void setListPropertySubType(
			List<PropertySubTypeDomain> listPropertySubType) {
		this.listPropertySubType = listPropertySubType;
	}

	public RentalOwnerDomain getCriteriaRentalOwner() {
		return criteriaRentalOwner;
	}

	public void setCriteriaRentalOwner(RentalOwnerDomain criteriaRentalOwner) {
		this.criteriaRentalOwner = criteriaRentalOwner;
	}

	public PropertySubTypeDomain getCriteriaPropertySubType() {
		return criteriaPropertySubType;
	}

	public void setCriteriaPropertySubType(
			PropertySubTypeDomain criteriaPropertySubType) {
		this.criteriaPropertySubType = criteriaPropertySubType;
	}
}
