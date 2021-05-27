package Prenda;

import accionNoPermanente.AderirPrenda;
import accionNoPermanente.ModificacionGuardarropa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guardarropa {
  Usuario propietario;
  List<Usuario> copropietarios = new ArrayList<>();
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
    this.verificarCriterio(prenda);
    this.prendas.add(prenda);
  }

  public void agregarSugerencia(Usuario copropietario, ModificacionGuardarropa modificacionGuardarropa) {
    this.verificarCopropietario(copropietario);
    if (modificacionGuardarropa.soyAdicion()) {
      this.verificarCriterio(modificacionGuardarropa.getPrenda());
    }
    this.modificacionesExternas.add(modificacionGuardarropa);
  }

  public void eliminarSugerencia(Usuario copropietario, ModificacionGuardarropa modificacionGuardarropa) {
    this.verificarCopropietario(copropietario);
    this.modificacionesExternas.remove(modificacionGuardarropa);
  }

  private void verificarCopropietario(Usuario copropietario) {
    if (!this.copropietarios.contains(copropietario)) {
      throw new RuntimeException("Usted no esta autorizado");
    }
  }

  private void verificarCriterio(Prenda prenda) {
    if (this.criterio != prenda.getCriterio()) {
      throw new RuntimeException("Prenda no cumple con criterio");
    }
  }

  public List<Prenda> getPrendas() {
    return this.prendasConModificaciones(this.prendas, this.modificacionesExternas.stream().filter(mod -> mod.getEstaRatificado()).collect(Collectors.toList()));
  }

  public List<Prenda> prendasConModificaciones(List<Prenda> prendas, List<ModificacionGuardarropa> modificaciones) {

    if (!modificaciones.isEmpty()) {
      ModificacionGuardarropa modificacionNula = new AderirPrenda(null);
      ModificacionGuardarropa modificacionActual = modificaciones.stream().findFirst().orElse(modificacionNula);
      modificaciones.remove(modificacionActual);
      prendas = this.prendasConModificaciones(modificacionActual.accionSobre(prendas), modificaciones);
    }
    return prendas;
  }
}
