<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="eduardo-espinoza-mc-api-example-portlet.caption"/></b>
</p>

<div>
	<fieldset>
		<legend>Seleccione Zona</legend>
		
		<input type="radio" name="zona" value="todas" checked /> Todas
		<input type="radio" name="zona" value="norte" /> Zona Norte
		<input type="radio" name="zona" value="centro" /> Zona Centro
		<input type="radio" name="zona" value="sur" /> Zona Sur
	</fieldset>
	<fieldset>
		<legend>Seleccione Ciudad</legend>
		
		<select name="cityName">
			<option value="">Seleccione...</option>
			
		</select>
	</fieldset>
</div>


