package accionNoPermanente;

import Prenda.Prenda;
import Prenda.Usuario;

import java.util.List;

public class AderirPrenda implements ModificacionGuardarropa {
  private Boolean estaRatificado;
  private Usuario propietario;
  private Prenda prenda;

  public AderirPrenda(Prenda prenda) {
    this.prenda = prenda;
  }

  public AderirPrenda(Usuario propietario, Prenda prenda) {
    this.prenda = prenda;
    this.propietario = propietario;
  }

  @Override
  public List<Prenda> accionSobre(List<Prenda> prendasList) {
    prendasList.add(this.prenda);
    return prendasList;
  }

  @Override
  public void cambiarStatusDeModificacion(Usuario usuario, Boolean aprobacion) {
    if (!this.propietario.equals(usuario)) {
      throw new RuntimeException("Usted no es propietario");
    }
    this.estaRatificado = aprobacion;
  }

  @Override
  public Boolean getEstaRatificado() {
    return estaRatificado;
  }

  public Prenda getPrenda() {
    return prenda;
  }

  @Override
  public boolean soyAdicion() {
    return true;
  }
}
