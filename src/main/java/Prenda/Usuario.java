package Prenda;

import java.util.List;

public class Usuario {
  private String name;
  private String email;

  public Usuario(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public void agregarGuardarropas(List<Prenda> prendas, Criterio criterio, List<Usuario> copropietarios) {
    new Guardarropa(prendas, criterio, this, copropietarios);
  }
}
