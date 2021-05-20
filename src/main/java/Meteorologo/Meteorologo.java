package Meteorologo;

import java.math.BigDecimal;

public interface Meteorologo {
  BigDecimal obtenerTemperatura() throws NoSuchFieldException;
}
