package com.zgw.quartz;


import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import com.zgw.quartz.job.HelloWord;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {

  public static void main(String[] args) {
    try {
      Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
      defaultScheduler.start();

      JobDetail jobDetail = newJob(HelloWord.class)
          .withIdentity("job1", "group1").usingJobData("user",1000)
          .build();

      Trigger trigger = newTrigger()
          .withIdentity("trigger1", "group1")
          .startNow()
          .withSchedule(simpleSchedule()
              .withIntervalInSeconds(10)
              .repeatForever())
          .build();
      defaultScheduler.scheduleJob(jobDetail,trigger);
//      defaultScheduler.shutdown();

    } catch (SchedulerException e) {
      e.printStackTrace();
    }


  }


}
