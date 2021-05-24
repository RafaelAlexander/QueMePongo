package Prenda;

import java.util.ArrayList;
import java.util.List;

public class TipoDePrenda {
  List<Material> materiales = new ArrayList<>();

  public TipoDePrenda(List<Material> materiales){
    this.materiales = materiales;
  }

  public void verificarMaterial(Material material) {
    if(!this.materiales.contains(material)){
      throw new RuntimeException("Material no valido");
    }
  }
}
