package com.swn.bss.pms.controller;

import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;

public class AbstractMasterController<T> extends LazyDataModel<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8212532190577685616L;
	
	private String backScreen = "";

	protected void setCurrentView(String newView){
		FacesContext context = FacesContext.getCurrentInstance();
		ApplicationBean bean = (ApplicationBean) context.getApplication()
				.evaluateExpressionGet(context, "#{applicationBean}",
						ApplicationBean.class);
		this.backScreen = bean.getCurrentView();
		bean.setCurrentView(newView);
	}
	
	public String getBackScreen() {
		return backScreen;
	}

	public void setBackScreen(String backScreen) {
		this.backScreen = backScreen;
	}
}