package com.sainsbury.model.service;

import com.sainsbury.model.ScrapeItem;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public interface ScrapeResultFactory {
    ScrapeItem create(Element element);

    ScrapeItem create(Document document, ScrapeItem item);
}
