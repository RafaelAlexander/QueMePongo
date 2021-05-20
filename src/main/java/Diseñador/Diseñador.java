package Diseñador;

import Meteorologo.Meteorologo;
import Prenda.Categoria.Categoria;
import Prenda.Prenda;

import java.util.*;
import java.util.stream.Collectors;


public class Diseñador {
  Meteorologo meteorologo;

  Diseñador(Meteorologo meteorologo) {
    this.meteorologo = Objects.requireNonNull(meteorologo, "Debe designar un meteorologo");
  }

  Set<Atuendo> generarAtuendos(List<Prenda> prendas) {
    //Toda esta logica de separacion tendria que estar en Usuario
    Set<Prenda> calzados = this.separarPrendasPorCategoria(prendas, Categoria.CALZADO);
    Set<Prenda> accesorio = this.separarPrendasPorCategoria(prendas, Categoria.ACCESORIO);
    Set<Prenda> parteSup = this.separarPrendasPorCategoria(prendas, Categoria.PARTESUPERIOR);
    Set<Prenda> parteInf = this.separarPrendasPorCategoria(prendas, Categoria.PARTEINFERIOR);
    return this.permutacionDeAccesorios(accesorio, calzados, parteInf, parteSup);
  }

  private Set<Atuendo> permutacionDeAccesorios(Set<Prenda> accesorios, Set<Prenda> calzados, Set<Prenda> parteInfs, Set<Prenda> partSups) {
    Set<Atuendo> atuendos = new HashSet<>();
    accesorios.stream().forEach(accesorio -> atuendos.addAll(permutacionDeCalzados(accesorio, calzados, parteInfs, partSups)));
    return atuendos;
  }

  private Set<Atuendo> permutacionDeCalzados(Prenda accesorio, Set<Prenda> calzados, Set<Prenda> parteInfs, Set<Prenda> partSups) {
    Set<Atuendo> atuendos = new HashSet<>();
    calzados.stream().forEach(calzado -> atuendos.addAll(this.permutacionDeParteInfs(accesorio, calzado, parteInfs, partSups)));
    return atuendos;
  }

  private Set<Atuendo> permutacionDeParteInfs(Prenda accesorio, Prenda calzado, Set<Prenda> parteInfs, Set<Prenda> parteSups) {
    Set<Atuendo> atuendos = new HashSet<>();
    parteInfs.stream().forEach(parteInf -> atuendos.addAll(this.permutacionDeParteSup(accesorio, calzado, parteInf, parteSups)));
    return atuendos;
  }

  private Set<Atuendo> permutacionDeParteSup(Prenda accesorio, Prenda calzado, Prenda parteInf, Set<Prenda> parteSups) {
    Set<Atuendo> atuendos = new HashSet<>();
    parteSups.stream().forEach(parteSup -> atuendos.add(new Atuendo(accesorio, calzado, parteInf, parteSup)));
    return atuendos;
  }

  private Set<Prenda> separarPrendasPorCategoria(List<Prenda> prendas, Categoria categoria) {
    return prendas.stream().filter(prenda -> {
      try {
        return prenda.soyDeCategoria(categoria) && prenda.soyAdecuadoParaClima(meteorologo.obtenerTemperatura());
      } catch (NoSuchFieldException e) {
        throw new RuntimeException("Se provoco un error tipo:" + e);
      }
    }).collect(Collectors.toSet());
  }
}
