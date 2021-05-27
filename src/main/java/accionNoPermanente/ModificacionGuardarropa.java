package accionNoPermanente;

import Prenda.Prenda;
import Prenda.Usuario;

import java.util.List;

public interface ModificacionGuardarropa {
  public List<Prenda> accionSobre(List<Prenda> prendas);

  public void cambiarStatusDeModificacion(Usuario usuario, Boolean aprobacion);

  public Boolean getEstaRatificado();

  Prenda getPrenda();

  boolean soyAdicion();
}
