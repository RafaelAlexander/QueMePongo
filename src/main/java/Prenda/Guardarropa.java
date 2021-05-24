package Prenda;

import accionNoPermanente.AderirPrenda;
import accionNoPermanente.ModificacionGuardarropa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {
  Usuario propietario;
  List<Usuario> copropietarios;
  //Faltaria agregar el meterologo para hacer las sugerencias
  List<Prenda> prendas = new ArrayList<>();
  List<ModificacionGuardarropa> modificacionesExternas = new ArrayList<>();

  Criterio criterio;

  Guardarropa(List<Prenda> prendas, Criterio criterio, Usuario propietario, List<Usuario> copropietarios) {
    this.prendas = prendas;
    this.comprobarCriterioExiste(criterio);
    this.criterio = criterio;
  }

  public void comprobarCriterioExiste(Criterio criterio) {
    if (!new RepoCriterio().getIntance().existeCriterio(criterio)) {
      throw new RuntimeException("Criterio no existe");
    }
  }

  public void agregarPrenda(Usuario propietario, Prenda prenda) {
    if (!this.propietario.equals(propietario)) {
      throw new RuntimeException("Usted no esta autorizado");
    }
    this.prendas.add(prenda);
  }

  public void sugerenciaDeAgregarPrenda(Usuario copropietario, Prenda prenda) {
    if (!this.copropietarios.contains(copropietario)) {
      throw new RuntimeException("Usted no esta autorizado");
    }
    if (this.criterio != prenda.getCriterio()) {
      throw new RuntimeException("Prenda no cumple con criterio");
    }
    this.modificacionesExternas.add(new AderirPrenda(this.propietario, prenda));
  }

  public List<Prenda> getPrendas() {
    List<Prenda> prendasConSugerencia = new ArrayList<>(this.prendas);
    prendasConSugerencia.addAll(darPrendasAditivas());
    prendasConSugerencia.removeAll(darPrendasSustractivas());
    return prendasConSugerencia;
  }

  public List<Prenda> darPrendasAditivas() {
    return this.modificacionesExternas.stream().filter(mod -> mod.soyAdicion()).map(modificacionGuardarropa -> modificacionGuardarropa.accionSobre()).collect(Collectors.toList());
  }

  public List<Prenda> darPrendasSustractivas() {
    return this.modificacionesExternas.stream().filter(mod -> !mod.soyAdicion()).map(modificacionGuardarropa -> modificacionGuardarropa.accionSobre()).collect(Collectors.toList());
  }
}
