package com.sainsbury.model;

import java.util.List;

/**
 * Contract between controller and service layer. All the services should return
 * implementation of this interface.
 */
public interface ScrapeResult {
    List<? extends ScrapeItem> getResults();

    double getTotal();
}
