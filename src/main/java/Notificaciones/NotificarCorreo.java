package Notificaciones;

import java.util.ArrayList;
import java.util.List;

public class NotificarCorreo implements Notificacion {
  List<Alerta> alertaList = new ArrayList<>();

  @Override
  public void notificar() {
    alertaList.stream().forEach(alerta -> NotificationService>>notify(alerta.darMensaje()));
  }
}
