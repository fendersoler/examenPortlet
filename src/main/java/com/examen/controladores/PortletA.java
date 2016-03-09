package com.examen.controladores;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.examen.entidad.Persona;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class PortletA
 */
public class PortletA extends GenericPortlet {

    public static final String TELEFONO = "telefono";
	public static final String DIRECCION = "direccion";
	public static final String NOMBRE = "nombre";

	protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(PortletA.class);
	
    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        include(viewTemplate, renderRequest, renderResponse);
    }

    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    @ProcessAction(name="formularioB")
    public void formularioB(ActionRequest actionRequest, ActionResponse actionResponse) 
    		throws PortletException, IOException {
    	
    	String nombre= actionRequest.getParameter(NOMBRE);
    	String direccion=actionRequest.getParameter(DIRECCION);
    	String telefono= actionRequest.getParameter(TELEFONO);
    	
    	Persona persona = new Persona(nombre, direccion, telefono);
    	
    	QName qname = new QName("http://examen.portlet.com","personaB","x");
    	actionResponse.setEvent(qname, persona);    	
    }
    
   
    @ProcessAction(name="formularioC")
    public void formularioC(ActionRequest actionRequest, ActionResponse actionResponse) 
    		throws PortletException, IOException {
    	
    	String nombre= actionRequest.getParameter(NOMBRE);
    	String direccion=actionRequest.getParameter(DIRECCION);
    	String telefono= actionRequest.getParameter(TELEFONO);
    	
    	Persona persona = new Persona(nombre, direccion, telefono);
    	
    	QName qname = new QName("http://examen.portlet.com","personaC","x");
    	actionResponse.setEvent(qname, persona);    	
    }
    
    @ProcessEvent(qname="{http://examen.portlet.com}personaB")
    public void formularioB(EventRequest eventRequest, EventResponse eventResponse) 
    		throws PortletException, IOException {
    	
    	Event evento= eventRequest.getEvent();
    	Persona persona= (Persona)evento.getValue(); 
    	eventRequest.setAttribute("persona",persona);
    }
   
    @ProcessEvent(qname="{http://examen.portlet.com}personaC")
    public void formularioC(EventRequest eventRequest, EventResponse eventResponse) 
    		throws PortletException, IOException {
    	
    	Event evento= eventRequest.getEvent();
    	Persona persona= (Persona)evento.getValue(); 
    	eventRequest.setAttribute("persona",persona);
    }
}