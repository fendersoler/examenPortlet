<%@ page import="com.examen.controladores.PortletA"%>
<%@ page import="com.examen.entidad.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h2>Portlet A</h2>.

<portlet:actionURL name="formularioB" var="urlFormularioB" />
<portlet:actionURL name="formularioC" var="urlFormularioC" />

<% Persona persona = (Persona)renderRequest.getAttribute("persona");

String nombre="Nombre";
String direccion="Direccion";
String telefono="Telefono";

if(persona!= null){	
	nombre= persona.getNombre();
	direccion=persona.getDireccion();
	telefono= persona.getTelefono();
}
%>

<form action ="" method="post">
	<input type="submit" formaction="<%=urlFormularioB%>" value= "Portlet B">
	<input type="submit" formaction="<%=urlFormularioC%>" value= "Portlet C">	
	<div>Nombre<input type = "text" placeholder="Nombre" name="<%=PortletA.NOMBRE %>" value="<%=nombre%>"></div>
	<div>Direccion<input type = "text" placeholder="Direccion" name="<%=PortletA.DIRECCION %>" value="<%=direccion%>"></div>
	<div>Telefono<input type = "text" placeholder="Telefono" name="<%=PortletA.TELEFONO %>" value="<%=telefono%>"></div>
</form>