package com.swn.bss.pms.controller;

import com.swn.bss.pms.controller.ApplicationBean;
import org.springframework.beans.factory.annotation.Configurable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Configurable
@ManagedBean
@SessionScoped
public class ApplicationBean {
	String currentView = "../pms-pages/rentalOwner.xhtml";

	public String getCurrentView() {
		return currentView;
	}

	public void setCurrentView(String currentView) {
		this.currentView = currentView;
	}

	public String getAppName() {
		return "PMS-Property Management System";
	}
}
