package Prenda;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class ModistaDeMañana {
  //Esto lo inicia en alguna parte en un main
  public static void iniciarTemporizadorDiario() {
    Scheduler scheduler;
    JobDetail job = JobBuilder.newJob(Usuario.class)
        .withIdentity("AtuendosDelDia", "group1").build();
    Trigger trigger = TriggerBuilder
        .newTrigger()
        .withIdentity("TemporizadorDeAtuendoDelDia", "group1")
        .withSchedule(CronScheduleBuilder.cronSchedule("0 8 * * ?"))
        .build();
    try {
      scheduler = new StdSchedulerFactory().getScheduler();
      scheduler.start();
      scheduler.scheduleJob(job, trigger);

    } catch (SchedulerException e) {
      throw new RuntimeException("El temporizador no inicio correctamente. ID:" + e);
    }
  }

  public static void IniciarTemporizadorDeAlerta() {
    Scheduler scheduler;
    JobDetail job = JobBuilder.newJob(Guardarropa.class)
        .withIdentity("AtuendosDelAlerta", "group1").build();
    Trigger trigger = TriggerBuilder
        .newTrigger()
        .withIdentity("TemporizadorDeAtuendoDeAlerta", "group1")
        .withSchedule(CronScheduleBuilder.cronSchedule("0 15 * * * ?"))//Cada 15 minutos dice pregunta si hay tormenta
        .build();
    try {
      scheduler = new StdSchedulerFactory().getScheduler();
      scheduler.start();
      scheduler.scheduleJob(job, trigger);

    } catch (SchedulerException e) {
      throw new RuntimeException("El temporizador no inicio correctamente. ID:" + e);
    }
  }
}
