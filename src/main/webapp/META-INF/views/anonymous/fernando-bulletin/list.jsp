<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list readonly="true">
	<acme:list-column code="anonymous.bullentin.fernando.list.label.author" path="author" width="20%"/>
	<acme:list-column code="anonymous.bullentin.fernando.list.label.text" path="text" width="50%"/>
	<acme:list-column code="anonymous.bullentin.fernando.list.label.moment" path="moment" width="15%"/>
	<acme:list-column code="anonymous.bullentin.fernando.list.label.title" path="title" width="15%"/>
</acme:list>