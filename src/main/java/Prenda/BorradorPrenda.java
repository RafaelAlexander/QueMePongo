package Prenda;


import Prenda.Categoria.Material;
import Prenda.Categoria.TipoDePrenda;

import java.math.BigDecimal;
import java.util.Objects;

public class BorradorPrenda {
  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Color primario;
  private Color secundario;
  private Trama trama = Trama.LISA;
  private BigDecimal tempMax;

  void especificarTipoDePrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = Objects.requireNonNull(tipoDePrenda, "Usted no indico la categoria");
  }

  void especificarMaterial(Material material) {
    this.verficarQueHizoPaso1();
    Objects.requireNonNull(material, "No ingreso una composicionDePrenda");
    this.tipoDePrenda.verificarMaterial(material);
  }

  void especificarTrama(Trama trama) {
    if (Objects.nonNull(trama)) {
      this.trama = trama;
    }
  }

  void especificarColorPrimario(Color color) {
    this.primario = Objects.requireNonNull(color, "Debe indicar color primario");
  }

  void especificarColorSecundario(Color color) {
    this.secundario = secundario;
  }

  void especificarTempMax(BigDecimal tempMax) {
    this.tempMax = Objects.requireNonNull(tempMax, "Debe indicar temperatura maxima");
  }

  Prenda guardarPrenda() {
    this.verficarQueHizoPaso1();
    Objects.requireNonNull(this.material, "No ingreso una composicionDePrenda");
    Objects.requireNonNull(this.primario, "Debe indicar color primario");
    Objects.requireNonNull(this.tempMax, "Debe indicar temperatura maxima");

    return new Prenda(this.tipoDePrenda, this.material, this.primario, this.secundario, this.trama, this.tempMax);
  }

  private void verficarQueHizoPaso1() {
    Objects.requireNonNull(this.tipoDePrenda, "No especifico anteriormente la categoria");
  }
}
