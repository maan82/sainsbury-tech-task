package com.sainsbury.controller;

import com.sainsbury.model.ScrapeResult;
import com.sainsbury.model.service.ScrapeService;
import com.sainsbury.view.ViewFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ScrapingController {
    public static final String PROBLEM = "Problem : ";

    @Autowired
    private ScrapeService scrapeService;

    @Autowired
    private ViewFactory viewFactory;

    public String scrape(String url) {
        try {
            ScrapeResult scrape = scrapeService.scrape(url);
            return viewFactory.create(scrape);
        } catch (Exception e) {
            return PROBLEM + e.getMessage();
        }
    }
}
