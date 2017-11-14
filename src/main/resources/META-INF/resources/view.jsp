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
</div>
<script>
	$(document).ready(function(){
		$('.city-name').change(function(){
			$.get('http://dataservice.accuweather.com/locations/v1/cities/CL/search', {
					apikey: '<liferay-ui:message key="eduardo-espinoza-mc-api-example-portlet-accuweather-apikey"/>',
					q: this.value
				 }, function(x){
					 $.get('http://dataservice.accuweather.com/currentconditions/v1/' + x[0].Key, {
							apikey: '<liferay-ui:message key="eduardo-espinoza-mc-api-example-portlet-accuweather-apikey"/>'
						 }, function(d){
							 $('.result').find('h2').text('Temperatura Actual: ' + d[0].Temperature.Metric.Value + '°C');
							 $('.result').fadeIn(500);
						 });
				 });
		});
	});
</script>


