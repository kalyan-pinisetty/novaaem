package com.nova.core.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nova.core.core.config.NovaSchedulerConfig;

@Component(immediate = true, service = Runnable.class)
@Designate(ocd = NovaSchedulerConfig.class)
public class NovaScheduler implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(NovaScheduler.class);

    private int schedulerId;

    @Reference
    private Scheduler scheduler;

    @Activate
    protected void activate(NovaSchedulerConfig config) {
        schedulerId = config.schedulerName().hashCode();
        addScheduler(config);
    }

    @Deactivate
    protected void deactivate(NovaSchedulerConfig config) {
        removeScheduler();
    }

    protected void removeScheduler() {
        scheduler.unschedule(String.valueOf(schedulerId));
    }

    protected void addScheduler(NovaSchedulerConfig config) {
        ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(true);
        scheduler.schedule(this, scheduleOptions);
        LOG.info("\n ====> Scheduler added=======>");
        ScheduleOptions scheduleOptionNow = scheduler.NOW(4,3);
        scheduler.schedule(this, scheduleOptionNow);
    }
   @Override
    public void run() {
       LOG.info("\n ====> RUN METHOD");
    }
}
