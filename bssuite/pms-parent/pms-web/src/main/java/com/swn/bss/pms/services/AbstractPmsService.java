package com.swn.bss.pms.services;

import com.swn.bss.pms.entity.AbstractPmsDomain;

public interface AbstractPmsService {

	/**
	 * get current user id
	 * @return
	 */
	public Long getCurrentUserId();
	/**
	 * get current ip address
	 * @return
	 */
	public String getCurrentIpAddress();
	
	public AbstractPmsDomain assemblyCreateAuditor(AbstractPmsDomain domain);
	
	public AbstractPmsDomain assemblyUpdateAuditor(AbstractPmsDomain domain);
	
}
