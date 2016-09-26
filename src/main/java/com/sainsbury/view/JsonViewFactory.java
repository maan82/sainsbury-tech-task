package com.sainsbury.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sainsbury.model.ScrapeResult;
import org.springframework.stereotype.Component;

@Component
public class JsonViewFactory implements ViewFactory {
    @Override
    public String create(ScrapeResult scrapeResult) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(scrapeResult);
    }
}
