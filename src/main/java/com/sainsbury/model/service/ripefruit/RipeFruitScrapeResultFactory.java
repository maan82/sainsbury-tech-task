package com.sainsbury.model.service.ripefruit;

import com.sainsbury.model.ScrapeItem;
import com.sainsbury.model.service.ScrapeResultFactory;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RipeFruitScrapeResultFactory implements ScrapeResultFactory {

    final private String product;

    final private String title;

    final private String unitPrice;

    final private String description;

    final private String descriptionLink;

    final private Pattern pattern;

    public RipeFruitScrapeResultFactory(@Value("${scrapper.path.product}")String product,
                                        @Value("${scrapper.path.product.title}")String title,
                                        @Value("${scrapper.path.product.unitprice}")String unitPrice,
                                        @Value("${scrapper.path.product.description}")String description,
                                        @Value("${scrapper.path.product.descriptionlink}")String descriptionLink,
                                        @Value("${scrapper.pattern.unitprice}")String pattern) {
        this.product = product;
        this.title = title;
        this.unitPrice = unitPrice;
        this.description = description;
        this.descriptionLink = descriptionLink;
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public ScrapeItem create(Element element) {
        Matcher matcher = pattern.matcher(element.select(unitPrice).text());
        matcher.find();
        return new RipeFruitScrapeItem(element.select(title).text(),
                null, Double.parseDouble(matcher.group()), null, element.select(descriptionLink).attr("href"));
    }

    @Override
    public ScrapeItem create(Document document, ScrapeItem item) {
        return new RipeFruitScrapeItem(item.getTitle(), "" + ((double) document.toString().length() / 1024 +"kb"),
                item.getUnitPrice(), document.select(description).text(), item.getLink());
    }
}
