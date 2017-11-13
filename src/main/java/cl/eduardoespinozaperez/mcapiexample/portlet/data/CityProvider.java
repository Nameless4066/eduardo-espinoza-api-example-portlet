package cl.eduardoespinozaperez.mcapiexample.portlet.data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import cl.eduardoespinozaperez.mcapiexample.portlet.data.model.City;

public class CityProvider {
	
	private static final CityProvider INSTANCE = new CityProvider();
	private static final List<City> citiesList = new ArrayList<>();
	
	private CityProvider() {
		initData();
	}
	
	private void initData() {
		if(citiesList.isEmpty()) {
			citiesList.add(new City(6693562, "Arica", City.ZONA_NORTE));
			citiesList.add(new City(3893656, "Copiapó", City.ZONA_NORTE));
			citiesList.add(new City(3893623, "Coquimbo", City.ZONA_NORTE));
			citiesList.add(new City(0, "Valparaíso", City.ZONA_CENTRO));
			citiesList.add(new City(0, "Santiago", City.ZONA_CENTRO));
			citiesList.add(new City(0, "Rancagua", City.ZONA_CENTRO));
			citiesList.add(new City(0, "Talca", City.ZONA_CENTRO));
			citiesList.add(new City(0, "Concepción", City.ZONA_SUR));
			citiesList.add(new City(0, "Temuco", City.ZONA_SUR));
			citiesList.add(new City(0, "Valdivia", City.ZONA_SUR));
			citiesList.add(new City(0, "Puerto Montt", City.ZONA_SUR));
			citiesList.add(new City(0, "Coyhaique", City.ZONA_SUR));
			citiesList.add(new City(0, "Punta Arenas", City.ZONA_SUR));
		}
	}
	
	public static CityProvider getInstance() {
		return INSTANCE;
	}
	
	public List<City> getCities(Predicate<City> cityPredicate) throws Exception{
		List<City> citiesListTmp = new ArrayList<>();
		
		for(City c : getCities()) {
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
