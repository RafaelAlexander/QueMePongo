package Meteorologo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class TemporizadorAdapterAccuWether {
  private Scheduler scheduler;

  public void iniciarActualizacionPeriodica() {
    JobDetail job = JobBuilder.newJob(Actualizador.class)
        .withIdentity("ActualizadorAccu", "AccuWeather").build();
    Trigger trigger = TriggerBuilder
        .newTrigger()
        .withIdentity("TemporizadorAccu", "AccuWeather")
        .withSchedule(simpleSchedule()
            .withIntervalInMinutes(144)//Esto es igual 2.4 que es 24/10 en minutos
            .repeatForever()
            .withMisfireHandlingInstructionNextWithExistingCount())
        .build();

    //schedule it
    try {
      this.scheduler = new StdSchedulerFactory().getScheduler();
      this.scheduler.start();
      this.scheduler.scheduleJob(job, trigger);
    } catch (SchedulerException e) {
      throw new RuntimeException("El temporizador no inicio correctamente. ID:" + e);
    }
  }
}
