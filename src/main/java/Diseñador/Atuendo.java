package Diseñador;

import Prenda.Categoria.Categoria;
import Prenda.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
  private List<Prenda> prendas = new ArrayList<>();

  Atuendo(Prenda accesorio, Prenda calzado, Prenda parteInf, Prenda parteSup) {
    this.verificarQueEs(accesorio, Categoria.ACCESORIO);
    this.prendas.add(accesorio);
    this.verificarQueEs(calzado, Categoria.CALZADO);
    this.prendas.add(calzado);
    this.verificarQueEs(parteInf, Categoria.PARTEINFERIOR);
    this.prendas.add(parteInf);
    this.verificarQueEs(parteSup, Categoria.PARTESUPERIOR);
    this.prendas.add(parteSup);
  }

  private void verificarQueEs(Prenda prenda, Categoria categoria) {
    if (prenda.soyDeCategoria(categoria)) {
      throw new RuntimeException("No es de esa categoria: " + categoria.toString());
    }
  }
}
