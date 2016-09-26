package com.sainsbury.model;

import java.util.List;

/**
 * Contract between controller and service layer. All the services should return
 * implementation of this interface.
 */
public interface ScrapeResult {
    /**
     * Return search result list containing ScrapeItem objects.
     * @return
     */
    List<? extends ScrapeItem> getResults();

    /**
     * Return total of unit price for search result list.
     * @return
     */
    double getTotal();
}
