package com.sainsbury.model.service.ripefruit;

import com.sainsbury.model.ScrapeItem;
import com.sainsbury.model.ScrapeResult;
import com.sainsbury.model.service.ScrapeResultFactory;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RipeFruitScrapeServiceTest {
    @Mock
    private ScrapeResultFactory factory;

    @Test
    public void testScrape_whenDocument_shouldReturnResult() throws Exception {
        final String url = "SOME_URL";
        final String productPath = "PRODUCT_PATH";
        final Document document = mock(Document.class);
        final ScrapeItem scrapeItem = mock(ScrapeItem.class);
        final Element element = mock(Element.class);
        final ScrapeItem expected = mock(ScrapeItem.class);

        RipeFruitScrapeService service = new RipeFruitScrapeService(){
            @Override
            Document get(String url) {
                return document;
            }
        };
        service.setProduct(productPath);
        service.setFactory(factory);

        Elements elements = new Elements();
        elements.add(element);

        when(document.select(productPath)).thenReturn(elements);
        when(factory.create(element)).thenReturn(scrapeItem);
        when(factory.create(document, scrapeItem)).thenReturn(expected);

        ScrapeResult scrapeResult = service.scrape(url);

        assertEquals(expected, scrapeResult.getResults().get(0));
        assertEquals(1, scrapeResult.getResults().size());

    }

    @Test
    public void testGet_shouldFetchFromUrl() throws Exception {
        RipeFruitScrapeService ripeFruitScrapeService = new RipeFruitScrapeService();
        Document document = ripeFruitScrapeService.get("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html");

        assertEquals("Ripe & ready | Sainsbury's", document.title());
    }
}