/**
 * 
 */
package com.swn.bss.pms.controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;

import com.swn.bss.pms.entity.PropertySubTypeDomain;
import com.swn.bss.pms.services.PropertySubTypeService;

/**
 * @author MrMai
 *
 */
@FacesConverter
public class PropertySubTypeConverter implements Converter {

	@Autowired
    PropertySubTypeService propertySubTypeService;
	
	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value == null || value.length() == 0) {
            return null;
        }
        Long id = Long.parseLong(value);
        return propertySubTypeService.getPropertySubType(id);
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return value instanceof PropertySubTypeDomain ? ((PropertySubTypeDomain) value).getOid().toString() : "";
	}

}
