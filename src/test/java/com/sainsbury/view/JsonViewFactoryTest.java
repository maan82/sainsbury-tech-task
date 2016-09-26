package com.sainsbury.view;

import com.sainsbury.model.ScrapeItem;
import com.sainsbury.model.service.ripefruit.RipeFruitScrapeItem;
import com.sainsbury.model.service.ripefruit.RipeFruitScrapeResult;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.Assert.assertEquals;

public class JsonViewFactoryTest {

    @Test
    public void testCreate_shouldReturnPrettyPrintJson() throws Exception {
        final String expected = "{\n" +
                "  \"results\" : [ {\n" +
                "    \"title\" : \"1\",\n" +
                "    \"size\" : \"1.1\",\n" +
                "    \"unitPrice\" : 10.1,\n" +
                "    \"description\" : \"description1\"\n" +
                "  }, {\n" +
                "    \"title\" : \"2\",\n" +
                "    \"size\" : \"2.2\",\n" +
                "    \"unitPrice\" : 20.2,\n" +
                "    \"description\" : \"description2\"\n" +
                "  } ],\n" +
                "  \"total\" : 30.299999999999997\n" +
                "}";

        final List<? extends ScrapeItem> scrapeItems = newArrayList(
                new RipeFruitScrapeItem("1", "1.1", 10.10, "description1", "link1"),
                new RipeFruitScrapeItem("2", "2.2", 20.20, "description2", "link2")
        );
        final RipeFruitScrapeResult scrapeResult = new RipeFruitScrapeResult(scrapeItems);

        String actualJson = new JsonViewFactory().create(scrapeResult);

        assertEquals(expected, actualJson);
    }


}