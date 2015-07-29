/**
 * 
 */
package com.swn.bss.pms.services.impl;

import com.swn.bss.pms.entity.AbstractPmsDomain;
import com.swn.bss.pms.services.AbstractPmsService;
import java.util.Calendar;
/**
 * @author MrMai
 *
 */
public class AbstractPmsServiceImpl implements AbstractPmsService {

	/* (non-Javadoc)
	 * @see com.swn.bss.pms.services.AbstractPmsService#getCurrentUserId()
	 */
	public Long getCurrentUserId() {
		// TODO Change Mock getCurrentUserId
		return new Long(999);
	}

	public String getCurrentIpAddress() {
		// TODO Change Mock CurrentIpAddress
		return "99.99.99.99";
	}

	public AbstractPmsDomain assemblyCreateAuditor(AbstractPmsDomain domain) {
		domain.setCreatedBy(getCurrentUserId());
		domain.setCreatedDate(Calendar.getInstance().getTime());
		domain.setLastAccessIp(getCurrentIpAddress());
		domain.setActive(true);
		return domain;
	}

	public AbstractPmsDomain assemblyUpdateAuditor(AbstractPmsDomain domain) {
		domain.setUpdatedBy(getCurrentUserId());
		domain.setUpdatedDate(Calendar.getInstance().getTime());
		domain.setLastAccessIp(getCurrentIpAddress());
		return domain;
	}



}
