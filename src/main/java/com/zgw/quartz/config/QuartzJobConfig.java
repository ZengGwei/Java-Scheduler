package com.zgw.quartz.config;

import com.zgw.quartz.job.MyFirstJob;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;


@Configuration
public class QuartzJobConfig {

  /**
   * 方法调用任务明细工厂Bean
   */
  @Bean("myFirstJobBean")
  public MethodInvokingJobDetailFactoryBean myFirstExerciseJobBean(MyFirstJob myFirstJob){
    MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
    jobDetailFactoryBean.setConcurrent(false);
    jobDetailFactoryBean.setName("job1-myFirstJob");
    jobDetailFactoryBean.setGroup("job1");
    jobDetailFactoryBean.setTargetObject(myFirstJob);
    jobDetailFactoryBean.setTargetMethod("myJobExerciseJob");
    return jobDetailFactoryBean;
  }
  /**
   * 表达式触发器工厂Bean
   */
  @Bean(name = "myFirstJobBeanTrigger")
  public CronTriggerFactoryBean myFirstExerciseJobTrigger(@Qualifier("myFirstJobBean") MethodInvokingJobDetailFactoryBean myFirstExerciseJobBean) {
    CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
    tigger.setJobDetail(myFirstExerciseJobBean.getObject());
    tigger.setCronExpression("0/10 * * * * ?"); // 什么是否触发，Spring Scheduler Cron表达式
    tigger.setName("job1-myFirstJobBeanTrigger");
    return tigger;
  }


}
