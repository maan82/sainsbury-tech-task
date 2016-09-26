package com.sainsbury.model.service;

import com.sainsbury.model.ScrapeResult;

/**
 * Interface to be implemented by each scraping service.
 */
public interface ScrapeService {
    /**
     * Scrapes webpage for given url
     * @param url to scrape
     * @return
     * @throws Exception
     */
    ScrapeResult scrape(String url) throws Exception;
}
