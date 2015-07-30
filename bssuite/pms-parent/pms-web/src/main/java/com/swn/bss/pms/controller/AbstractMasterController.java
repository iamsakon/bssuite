package com.swn.bss.pms.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import com.swn.bss.pms.controller.util.MessageFactory;

public class AbstractMasterController<T> extends LazyDataModel<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8212532190577685616L;
	
	protected String searchScreen = "";
	
	protected String viewScreen = "";
	
	protected String editScreen = "";
	
	protected String backScreen = "";
	
	protected String createSuccessMessageId = "message_successfully_created";
	
	protected String updateSuccessMessageId = "message_successfully_updated";
	
	protected String deleteSuccessMessageId = "message_successfully_deleted";

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
	
	public void info(String messageId,Object... params) {
		FacesContext.getCurrentInstance().addMessage(null,MessageFactory.getMessage(messageId, FacesMessage.SEVERITY_INFO, params));
    }
     
    public void warn(String messageId,Object... params) {
        FacesContext.getCurrentInstance().addMessage(null, MessageFactory.getMessage(messageId, FacesMessage.SEVERITY_WARN, params));
    }
     
    public void error(String messageId,Object... params) {
        FacesContext.getCurrentInstance().addMessage(null, MessageFactory.getMessage(messageId, FacesMessage.SEVERITY_ERROR, params));
    }
     
    public void fatal(String messageId,Object... params) {
        FacesContext.getCurrentInstance().addMessage(null, MessageFactory.getMessage(messageId, FacesMessage.SEVERITY_FATAL, params));
    }
}
