package com.nova.core.core.services.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.nova.core.core.services.DemoService;
import com.nova.core.core.services.DemoServiceB;

@Component(service = DemoServiceB.class, immediate = true)
public class DemoServiceBImpl implements DemoServiceB {

    @Reference
    DemoService demoService;

    private static final Logger LOG = LoggerFactory.getLogger(DemoServiceBImpl.class);

    @Override
    public List<String> getPages() {

        List<String> listPages = new ArrayList<>();

        try {
            Iterator<Page> pages = demoService.getPages();
            while (pages.hasNext()) {
                listPages.add(pages.next().getTitle());
            }
            return listPages;

        } catch (Exception e) {
            LOG.info("exception {}", e.getMessage());
        }
        return null;

    }

}
