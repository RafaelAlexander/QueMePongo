package Prenda;

import Prenda.Categoria.Material;
import Prenda.Categoria.TipoDePrenda;

import java.util.Objects;

public class Prenda {
  private TipoDePrenda tipoDePrenda;
  private Material material;
  private Color primario;
  private Color secundario;
  private Trama trama;

  public Prenda(TipoDePrenda tipoDePrenda, Material material, Color primario, Color secundario, Trama trama) {
    this.tipoDePrenda = Objects.requireNonNull(tipoDePrenda, "Debe indicar la categoria");
    this.material = Objects.requireNonNull(material, "Debe indicar la composion de la prenda");
    this.primario = Objects.requireNonNull(primario, "Debe indicar el color primario");
    this.secundario = secundario;
    this.trama = trama;
  }
}
