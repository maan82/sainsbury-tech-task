package com.sainsbury.model.service.ripefruit;

import com.sainsbury.model.ScrapeItem;
import com.sainsbury.model.ScrapeResult;
import com.sainsbury.model.service.ScrapeResultFactory;
import com.sainsbury.model.service.ScrapeService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RipeFruitScrapeService implements ScrapeService {

    @Value("${scrapper.path.product}")
    private String product;

    @Autowired
    private ScrapeResultFactory factory;

    @Override
    public ScrapeResult scrape(String url) throws Exception {
        List<? extends ScrapeItem> ripeFruitScrapeItems = get(url).select(product).stream()
                .map(e -> factory.create(e))
                .map(e -> factory.create(get(e.getLink()), e))
                .collect(Collectors.toList());

        return new RipeFruitScrapeResult(ripeFruitScrapeItems);
    }

    Document get(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setFactory(ScrapeResultFactory factory) {
        this.factory = factory;
    }
}
