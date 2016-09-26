package com.sainsbury.model.service.ripefruit;

import com.sainsbury.model.ScrapeItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RipeFruitScrapeResultFactoryTest {

    @Test
    public void testCreate_shouldCreateItem() throws Exception {
        double somePrice = 10.1;
        String someTitle = "SOME_TITLE";
        String someLink = "SOME_LINK";

        Document document = Jsoup.parse("<div class=\"product\"><div class=\"productInfo\">\n" +
                "<a href=\"" + someLink + "\" >\n" +
                " " + someTitle + "\n" +
                "</a></div>" +
                "<p class=\"pricePerUnit\">&pound" + somePrice + "<abbr title=\"per\">/</abbr><abbr title=\"unit\"><span class=\"pricePerUnitUnit\">unit</span></abbr>\n" +
                "</p>" +
                "</div>");

        String unitPrice = ".pricePerUnit";
        String title = ".productInfo";
        String descriptionLink = ".productInfo a[href]";

        RipeFruitScrapeResultFactory factory = new RipeFruitScrapeResultFactory("product", title, unitPrice, "description", descriptionLink, "\\d+\\.\\d+");

        ScrapeItem scrapeItem = factory.create(document.select(".product").first());

        assertEquals(someTitle, scrapeItem.getTitle());
        assertEquals(somePrice, scrapeItem.getUnitPrice(), 0);
        assertEquals(someLink, scrapeItem.getLink());
    }

    @Test
    public void testCreate_whenDocumentAndItem_shouldAddDescriptionAndSize() throws Exception {

        final String descriptionPath = "h3:contains(Description) + div.productText";
        final String someDescription = "Apricots";
        final Document document = Jsoup.parse("<div class=\"product\"><h3 class=\"productDataItemHeader\">Description</h3>" +
                "<div class=\"productText\">\n" +
                "<p>" + someDescription + "</p>\n" +
                "</div>" +
                "</div>");


        final String someTitle = "SOME_TITLE";
        final String someLink = "SOME_LINK";
        final double somePrice = 2.3;
        final ScrapeItem scrapeItem = mock(ScrapeItem.class);


        when(scrapeItem.getTitle()).thenReturn(someTitle);
        when(scrapeItem.getUnitPrice()).thenReturn(somePrice);
        when(scrapeItem.getLink()).thenReturn(someLink);

        RipeFruitScrapeResultFactory factory = new RipeFruitScrapeResultFactory("product", "title", "unitPrice", descriptionPath, "descriptionLink", "\\d+\\.\\d+");

        ScrapeItem actual = factory.create(document, scrapeItem);

        assertEquals(someTitle, actual.getTitle());
        assertEquals(somePrice, actual.getUnitPrice(), 0);
        assertEquals(someLink, actual.getLink());
        assertEquals("0.189453125kb", actual.getSize());
        assertEquals(someDescription, actual.getDescription());
    }
}