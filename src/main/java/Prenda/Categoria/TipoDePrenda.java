package Prenda.Categoria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TipoDePrenda {
  List<Material> materialesValidos = new ArrayList<>();
  Categoria categoria;

  public TipoDePrenda(List<Material> materialesValidos, Categoria categoria) {
    this.materialesValidos = Objects.requireNonNull(materialesValidos, "Debe ingresar materiales validos");
    this.categoria = Objects.requireNonNull(categoria, "Usted debe elegir la categoria");
  }

  public void verificarMaterial(Material material) {
    if (!this.materialesValidos.contains(material)) {
      throw new RuntimeException("Usted no indico material valido");
    }
  }

  public Boolean soyDeCategoria(Categoria categoria) {
    return categoria == categoria;
  }
}
