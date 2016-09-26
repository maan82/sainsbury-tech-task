package com.sainsbury.controller;

import com.sainsbury.model.ScrapeResult;
import com.sainsbury.model.service.ScrapeService;
import com.sainsbury.view.ViewFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.sainsbury.controller.ScrapingController.PROBLEM;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ScrapingControllerTest {

    @Mock
    private ScrapeService scrapeService;

    @Mock
    private ViewFactory viewFactory;

    @InjectMocks
    private ScrapingController controller = new ScrapingController();

    @Test
    public void testScrape_whenServiceReturnResult_shouldCreateJson() throws Exception {
        final String url = "SOME_URL";
        final String expected = "SOME_STRING";
        final ScrapeResult scrapeResult = mock(ScrapeResult.class);

        when(scrapeService.scrape(url)).thenReturn(scrapeResult);
        when(viewFactory.create(scrapeResult)).thenReturn(expected);

        assertEquals(expected, controller.scrape(url));
    }

    @Test
    public void testScrape_whenServiceThrows_shouldReturnMessage() throws Exception {
        final String url = "SOME_URL";
        final String expected = "SOME_STRING";

        doThrow(new Exception(expected)).when(scrapeService).scrape(url);

        assertEquals(PROBLEM + expected, controller.scrape(url));
        verifyZeroInteractions(viewFactory);
    }

    @Test
    public void testScrape_whenViewFactoryThrows_shouldReturnMessage() throws Exception {
        final String url = "SOME_URL";
        final String expected = "SOME_STRING";
        final ScrapeResult scrapeResult = mock(ScrapeResult.class);

        when(scrapeService.scrape(url)).thenReturn(scrapeResult);
        doThrow(new Exception(expected)).when(viewFactory).create(scrapeResult);

        assertEquals(PROBLEM + expected, controller.scrape(url));
    }

}