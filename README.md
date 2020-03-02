# Java-Scheduler
quartz 集成 springboot 集成定时任务


###使用Quartz[Quartz](https://www.w3cschool.cn/quartz_doc/quartz_doc-1xbu2clr.html)
在使用Scheduler之前，需要实例化（谁猜到了？）。为此，您可以使用SchedulerFactory。Quartz的一些用户可能会在JNDI存储中保留factory的实例，其他用户可能会发现直接初始化会更加简单（例如下面的示例）。

scheduler实例化后，可以启动(start)、暂停(stand-by)、停止(shutdown)。注意：scheduler被停止后，除非重新实例化，否则不能重新启动；只有当scheduler启动后，即使处于暂停状态也不行，trigger才会被触发（job才会被执行）。

下面的代码片段，实例化并启动一个scheduler，调度执行一个job：
 ``SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

  Scheduler sched = schedFact.getScheduler();

  sched.start();

  // define the job and tie it to our HelloJob class
  JobDetail job = newJob(HelloJob.class)
      .withIdentity("myJob", "group1")
      .build();

  // Trigger the job to run now, and then every 40 seconds
  Trigger trigger = newTrigger()
      .withIdentity("myTrigger", "group1")
      .startNow()
      .withSchedule(simpleSchedule()
          .withIntervalInSeconds(40)
          .repeatForever())
      .build();

  // Tell quartz to schedule the job using our trigger
  sched.scheduleJob(job, trigger);``
