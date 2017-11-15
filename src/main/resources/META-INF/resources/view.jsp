<%@ include file="/init.jsp" %>
<portlet:resourceURL var="portletUrl" />

<p>
	<b><!--<liferay-ui:message key="eduardo-espinoza-mc-api-example-portlet.caption"/>--></b>
</p>

<div>
	<fieldset>
		<legend>Seleccione Zona</legend>
		
		<input type="radio" name="zona" value="todas" checked /> Todas
		<input type="radio" name="zona" value="norte" /> Zona Norte
		<input type="radio" name="zona" value="centro" /> Zona Centro
		<input type="radio" name="zona" value="sur" /> Zona Sur
	</fieldset>
	<br /><br />
	<fieldset>
		<legend>Seleccione Ciudad</legend>
		
		<select name="cityName" class="city-name">
			<option value="">Seleccione...</option>
			<c:forEach items="${citiesList}" var="city">
    			<option value="${city.cityName}">${city.cityName}</option>
			</c:forEach>
		</select>
	</fieldset>
	<br /><br />
	<fieldset class="result" style="display:none;">
		<legend>Resultados</legend>
		<h2></h2>
	</fieldset>
	<input type="hidden" id="api-key" value="<liferay-ui:message key="eduardo-espinoza-mc-api-example-portlet-accuweather-apikey"/>" />
	<input type="hidden" id="portlet-url" value="<c:out value="${portletUrl}" />" />
	<input type="hidden" id="portlet-namespace" value="<portlet:namespace />" />
</div>


