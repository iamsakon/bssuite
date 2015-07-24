package com.swn.bss.pms.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;

public class AbstractMasterController<T> extends LazyDataModel<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8212532190577685616L;
	
	protected String searchScreen = "";
	
	protected String viewScreen = "";
	
	protected String editScreen = "";
	
	protected String backScreen = "";

	protected void setCurrentView(String newView){
		FacesContext context = FacesContext.getCurrentInstance();
		ApplicationBean bean = (ApplicationBean) context.getApplication()
				.evaluateExpressionGet(context, "#{applicationBean}",
						ApplicationBean.class);
		this.backScreen = bean.getCurrentView();
		bean.setCurrentView(newView);
	}
	
	protected void goBack(){
		this.setCurrentView(this.getBackScreen());
	}
	
	public String getBackScreen() {
		return backScreen;
	}

	public void setBackScreen(String backScreen) {
		this.backScreen = backScreen;
	}
	
	public void info(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
    }
     
    public void warn(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", message));
    }
     
    public void error(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
    }
     
    public void fatal(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", message));
    }
}
