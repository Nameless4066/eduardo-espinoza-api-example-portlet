package cl.eduardoespinozaperez.mcapiexample.portlet.data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import cl.eduardoespinozaperez.mcapiexample.portlet.data.model.City;

public class CityProvider {
	
	private List<City> citiesList = new ArrayList<>();
	
	public CityProvider() {
		initData();
	}
	
	private void initData() {
		if(citiesList.isEmpty()) {
			citiesList.add(new City("Arica", City.ZONA_NORTE));
			citiesList.add(new City("Copiapó", City.ZONA_NORTE));
			citiesList.add(new City("Coquimbo", City.ZONA_NORTE));
			citiesList.add(new City("Valparaíso", City.ZONA_CENTRO));
			citiesList.add(new City("Santiago", City.ZONA_CENTRO));
			citiesList.add(new City("Rancagua", City.ZONA_CENTRO));
			citiesList.add(new City("Talca", City.ZONA_CENTRO));
			citiesList.add(new City("Concepción", City.ZONA_SUR));
			citiesList.add(new City("Temuco", City.ZONA_SUR));
			citiesList.add(new City("Valdivia", City.ZONA_SUR));
			citiesList.add(new City("Puerto Montt", City.ZONA_SUR));
			citiesList.add(new City("Coyhaique", City.ZONA_SUR));
			citiesList.add(new City("Punta Arenas", City.ZONA_SUR));
		}
	}
	
	public List<City> getCities(Predicate<City> cityPredicate) throws Exception{
		List<City> citiesListTmp = new ArrayList<>();
		
		for(City c : citiesList) {
			if(cityPredicate.test(c)) {
				citiesListTmp.add(c);
			}
		}
		
		return citiesListTmp;
	}
	
	public List<City> getCities(){
		return citiesList;
	}
}
