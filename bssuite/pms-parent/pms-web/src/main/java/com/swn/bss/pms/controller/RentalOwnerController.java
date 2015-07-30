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
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class RentalOwnerController extends
		AbstractMasterController<RentalOwnerDomain> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4505793523777164945L;

	@Autowired
	RentalOwnerService rentalOwnerService;

	private RentalOwnerDomain selectedValue;

	private RentalOwnerDomain criteria = new RentalOwnerDomain();

	private Page<RentalOwnerDomain> pageSearchResult;

	public RentalOwnerController() {
		searchScreen = "../pms-pages/rentalOwner.xhtml";
		viewScreen = "../pms-pages/rentalOwnerView.xhtml";
		editScreen = "../pms-pages/rentalOwnerEdit.xhtml";
	}

	@PostConstruct
	public void search() {
		// this.load(1, 10, null, null, null);
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
		} else {
			// TODO In case selectedValue == null or oid = 0
		}
	}

	public void openCreate() {
		this.selectedValue = new RentalOwnerDomain();
		this.setCurrentView(this.editScreen);
	}

	public void saveRentalOwner() {
		Object[] params = {"Rental Owner"};
		if (this.selectedValue != null) {
			boolean flagNew = this.selectedValue.getOid() == null?true:false;
			rentalOwnerService.saveRentalOwner(this.selectedValue);
			this.info(flagNew?this.createSuccessMessageId:this.updateSuccessMessageId, params);
			this.openViewMode();
		}
	}

	public void deleteRentalOwner(RentalOwnerDomain domain){
		Object[] params = {"Rental Owner"};
		if(domain != null){
			rentalOwnerService.deleteRentalOwner(domain.getOid());
			this.info(this.deleteSuccessMessageId, params);
		}
	}
	
	public void reset() {
		criteria = new RentalOwnerDomain();
	}

	public RentalOwnerService getRentalOwnerService() {
		return rentalOwnerService;
	}

	public void setRentalOwnerService(RentalOwnerService rentalOwnerService) {
		this.rentalOwnerService = rentalOwnerService;
	}

	@Override
	public RentalOwnerDomain getRowData(String rowKey) {
		if (pageSearchResult != null
				&& pageSearchResult.getContent().size() > 0) {
			for (RentalOwnerDomain domain : pageSearchResult.getContent()) {
				if (("" + domain.getOid()).equals(rowKey))
					return domain;
			}
		}
		return null;
	}

	@Override
	public Object getRowKey(RentalOwnerDomain domain) {
		return domain.getOid();
	}

	public int getRowCount() {
		return pageSearchResult != null?pageSearchResult.getContent().size():0;
	}

	@Override
	public List<RentalOwnerDomain> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		pageSearchResult = rentalOwnerService.findRentalOwner(criteria, first,
				pageSize);
		// TODO Add Feature filters
		// TODO Add Feature sortOrder
		return pageSearchResult.getContent();
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
