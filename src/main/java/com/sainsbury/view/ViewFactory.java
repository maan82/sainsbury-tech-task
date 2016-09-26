package com.sainsbury.view;

import com.sainsbury.model.ScrapeResult;

public interface ViewFactory {
    String create(ScrapeResult scrapeResult) throws Exception;
}
