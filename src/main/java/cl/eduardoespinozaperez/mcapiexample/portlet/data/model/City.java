package cl.eduardoespinozaperez.mcapiexample.portlet.data.model;

public class City {
	private String cityName;
	private String zona;
	
	public static final String ZONA_NORTE = "norte";
	public static final String ZONA_CENTRO = "centro";
	public static final String ZONA_SUR = "sur";
	
	public City() {
		this.cityName = "";
		this.zona = "";
	}
	
	public City(String cityName, String zona) {
		this.cityName = cityName;
		this.zona = zona;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getZona() {
		return zona;
	}
	
	public void setZona(String zona) {
		this.zona = zona;
	}
}
