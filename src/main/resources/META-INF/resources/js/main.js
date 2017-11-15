$(document).ready(function(){
	$('.city-name').change(function(){
		var nombreCiudad = this.value;
		var temperatura = obtenerTemperatura(nombreCiudad);
		console.log('Temperatura: ', temperatura);
		
		$('.result').find('h2').text('Temperatura Actual: ' + temperatura + '°C');
		$('.result').fadeIn(500);
	});
	
	$('input[name=zona]').change(function(){
		console.log(this.value);
		$.post($('#portlet-url').val(),
				{
					zona: this.value
				},
				function(d){
					$('.city-name').empty();
					$('.city-name').append('<option value="">Seleccione...</option>');
					$.each(d, function(){
						$('.city-name').append('<option value="' + this.cityName + '">' + this.cityName + '</option>');
					})
				}
		);
	});
	
	function obtenerTemperatura(q){
		var temp = "";
		$.get('http://dataservice.accuweather.com/locations/v1/cities/CL/search', 
				{
					apikey: $('#api-key').val(),
					q: q
				}, 
				function(x){
					$.get('http://dataservice.accuweather.com/currentconditions/v1/' + x[0].Key, 
							{
								apikey: $('#api-key').val()
							}, 
							function(d){
								temp = d[0].Temperature.Metric.Value;
							}
					);
				}
		);
		
		return temp;
	}
});


