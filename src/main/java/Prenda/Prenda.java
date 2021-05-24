package Prenda;

import java.math.BigDecimal;

public class Prenda {
  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Color primario;
  private Color secundario;
  private Trama trama;
  private BigDecimal tempMax;
  private Criterio criterio;

  public Prenda(TipoDePrenda tipoDePrenda, Material material, Color primario, Color secundario, Trama trama, BigDecimal tempMax, Criterio criterio) {
    this.tipoDePrenda = tipoDePrenda;
    this.material = material;
    this.primario = primario;
    this.secundario = secundario;
    this.trama = trama;
    this.tempMax = tempMax;
    this.criterio = criterio;
  }

  public TipoDePrenda getTipoDePrenda() {
    return tipoDePrenda;
  }

  public Boolean soyAdecuadoParaClima(BigDecimal tempMax) {
    return this.tempMax.compareTo(tempMax) != -1;
  }

  public Criterio getCriterio() {
    return criterio;
  }
}
