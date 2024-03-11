package com.nova.core.core.schedulers;

import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nova.core.core.config.NovaSchedulerConfig;

@Component(service = Runnable.class)
@Designate(ocd = NovaSchedulerConfig.class)
public class SchedulerExample implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(SchedulerExample.class);

    private int schedulerName;

    @Reference
    private Scheduler scheduler;

    @Activate
    protected void activate(NovaSchedulerConfig config) {
        schedulerName = config.schedulerName().hashCode();
        addScheduler(config);
    }

    @Deactivate
    protected void deactivate(NovaSchedulerConfig config) {
        removeScheduler();
    }

    protected void removeScheduler() {
        scheduler.unschedule(String.valueOf(schedulerName));
    }

    protected void addScheduler(NovaSchedulerConfig config) {
        ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerName));
        scheduleOptions.canRunConcurrently(true);
        scheduler.schedule(this, scheduleOptions);
        logger.info("\n ====> Scheduler added=======>");
    }

    @Override
    public void run() {
        logger.debug("Scheduler is now running, myParameter='{}'");
    }

}
