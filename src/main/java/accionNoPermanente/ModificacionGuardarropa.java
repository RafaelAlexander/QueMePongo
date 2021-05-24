package accionNoPermanente;

import Prenda.Prenda;
import Prenda.Usuario;

import java.util.List;

public interface ModificacionGuardarropa {
  public Prenda accionSobre();

  public void cambiarStatusDeModificacion(Usuario usuario, Boolean aprobacion);

  public Boolean getEstaRatificado();

  public Boolean soyAdicion();
}
