package Prenda;

import Notificaciones.*;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;
import java.util.stream.Collectors;

public class Usuario implements Job {
  private String name;
  private String email;
  private List<Atuendo> sugerenciaDiarias;
  private List<Notificacion> notificacions;

  public Usuario(String name, String email, List<Notificacion> notificacions) {
    this.name = name;
    this.email = email;
    this.notificacions = notificacions;
  }

  public void agregarGuardarropas(List<Prenda> prendas, Criterio criterio, List<Usuario> copropietarios) {
    new Guardarropa(prendas, criterio, this, copropietarios);
  }

  public void darNotificacionesAUsuario(){
    notificacions.stream().forEach(notificacion -> notificacion.notificar());
  }

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    List<Guardarropa> guardarropas = RepoGuardarropas.getIntance().darGuardarropasDe(this);
    this.sugerenciaDiarias = guardarropas.stream().map(guardarropa -> guardarropa.generarAtuendoDelDia()).collect(Collectors.toList());
    //Si solo se requiere uno hacer FirstFist y Cambiar la lista por Objecto
  }
}
