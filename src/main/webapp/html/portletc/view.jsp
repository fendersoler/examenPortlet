<%@ page import="com.examen.entidad.Persona"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<h2>Portlet C</h2>.

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

<form action="" method="post">		
	<div>Nombre<input type = "text" name="nombre" value="<%=nombre%>"></div>
	<div>Direccion<input type = "text" name="direccion" value="<%=direccion%>"></div>
	<div>Telefono<input type = "text" name="telefono" value="<%=telefono%>"></div>
</form>