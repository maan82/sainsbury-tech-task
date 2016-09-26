package com.sainsbury.model;

/**
 * This interface ensure that each item in the search result provides
 * Title, Size, Unit Price and Description.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"link"})
public interface ScrapeItem {
    public String getTitle();

    public String getSize();

    public double getUnitPrice();

    public String getDescription();

    public String getLink();
}
