package Prenda;

import Prenda.Categoria.Categoria;
import Prenda.Categoria.Material;
import Prenda.Categoria.TipoDePrenda;

import java.math.BigDecimal;
import java.util.Objects;

public class Prenda {
  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Color primario;
  private Color secundario;
  private Trama trama;
  private BigDecimal tempMax;

  public Prenda(TipoDePrenda tipoDePrenda, Material material, Color primario, Color secundario, Trama trama, BigDecimal tempMax) {
    this.tipoDePrenda = tipoDePrenda;
    this.material = material;
    this.primario = primario;
    this.secundario = secundario;
    this.trama = trama;
    this.tempMax = tempMax;
  }

  public TipoDePrenda getTipoDePrenda() {
    return tipoDePrenda;
  }

  public Boolean soyDeCategoria(Categoria categoria) {
    return this.tipoDePrenda.soyDeCategoria(categoria);
  }

  public Boolean soyAdecuadoParaClima(BigDecimal tempMax) {
    return this.tempMax.compareTo(tempMax) != -1;
  }
}
