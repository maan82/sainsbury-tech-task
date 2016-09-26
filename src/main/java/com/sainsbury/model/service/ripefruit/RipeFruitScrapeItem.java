package com.sainsbury.model.service.ripefruit;

import com.sainsbury.model.ScrapeItem;

public class RipeFruitScrapeItem implements ScrapeItem {
    private String title;
    private String size;
    private double unitPrice;
    private String description;
    private String link;

    public RipeFruitScrapeItem(String title, String size, double unitPrice, String description, String link) {
        this.title = title;
        this.size = size;
        this.unitPrice = unitPrice;
        this.description = description;
        this.link = link;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }
}
