package Notificaciones;

public class AlertaGeneral implements Alerta{
  @Override
  public String darMensaje() {
   return RepoMeteorologo.getInstance().getMeteorologoConAlerta().getAlertas();
  }
}
