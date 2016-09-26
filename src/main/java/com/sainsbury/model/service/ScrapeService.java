package com.sainsbury.model.service;

import com.sainsbury.model.ScrapeResult;

public interface ScrapeService {
    ScrapeResult scrape(String url) throws Exception;
}
