<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="anonymous.bullentin.fernando.form.label.author" path="author"/>
	<acme:form-textbox code="anonymous.bullentin.fernando.form.label.title" path="title"/>
	<acme:form-textarea code="anonymous.bullentin.fernando.form.label.text" path="text"/>
	
	<acme:form-submit code="anonymous.bullentin.fernando.form.label.create" action="/anonymous/fernando-bulletin/create"/>
	<acme:form-return code="anonymous.bullentin.fernando.form.label.return"/>

</acme:form>