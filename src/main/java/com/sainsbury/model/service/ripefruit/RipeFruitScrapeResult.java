package com.sainsbury.model.service.ripefruit;

import com.sainsbury.model.ScrapeItem;
import com.sainsbury.model.ScrapeResult;

import java.util.List;

public class RipeFruitScrapeResult implements ScrapeResult {

    private List<? extends ScrapeItem> searchItems;

    public RipeFruitScrapeResult(List<? extends ScrapeItem> searchItems) {
        this.searchItems = searchItems;
    }

    @Override
    public List<? extends ScrapeItem> getResults() {
        return searchItems;
    }

    @Override
    public double getTotal() {
        return searchItems.stream().mapToDouble(p -> p.getUnitPrice()).reduce(0, (p, q) -> p + q);
    }
}
