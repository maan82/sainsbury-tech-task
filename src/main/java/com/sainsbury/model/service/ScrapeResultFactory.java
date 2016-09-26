package com.sainsbury.model.service;

import com.sainsbury.model.ScrapeItem;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Factory to map information on webpage to ScrapeItem objects
 */
public interface ScrapeResultFactory {

    /**
     * Creates ScrapeItem object from Element
     * @param element
     * @return
     */
    ScrapeItem create(Element element);

    /**
     * Decorates ScrapeItem object with extra information from Document.
     * @param document
     * @param item
     * @return
     */
    ScrapeItem create(Document document, ScrapeItem item);
}
