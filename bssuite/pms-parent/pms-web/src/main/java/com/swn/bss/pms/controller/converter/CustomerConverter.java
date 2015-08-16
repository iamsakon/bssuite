/**
 * 
 */
package com.swn.bss.pms.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swn.bss.pms.entity.CustomerDomain;
import com.swn.bss.pms.services.CustomerService;

/**
 * @author MrMai
 *
 */
@Component
public class CustomerConverter implements Converter {

	@Autowired
	CustomerService customerService;
	
	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null || value.length() == 0) {
            return null;
        }
		CustomerDomain domain = null;
		try{
	        Long id = Long.parseLong(value);
	        domain = customerService.getCustomer(id);
		}catch(Exception ex)
		{
			return null;
			//ex.printStackTrace();
			//TODO waiting set Loging
		}
        return domain;
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null) {
            return "";            
        }
		
		if (!(value instanceof CustomerDomain)) {
	        throw new ConverterException("Value is not a valid instance of CustomerDomain.");
	    }
		
		Long id = ((CustomerDomain) value).getOid();
		
		return (id != null) ? id.toString() : "";
	}

}