package com.zgw.quartz.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MyFirstJob {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  public void myJobExerciseJob(){
    this.logger.info("这是一个任务job");
  }

}
