package Meteorologo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class AdapterAccuWeather implements Meteorologo {
  private static AccuWeatherAPI apiClima = new AccuWeatherAPI();
  private static List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");

  @Override
  public BigDecimal obtenerTemperatura() {
    String[] partes = this.getTemperature();
    return new BigDecimal(partes[3]);
  }

  private String[] getTemperature() {
    return condicionesClimaticas.get(0).get("Temperature").toString().replace(" ", "").replace("{", "").split("[=,]");
  }

  public void actualizar() {
    condicionesClimaticas = apiClima.getWeather("Buenos Aires, Argentina");
  }

}
