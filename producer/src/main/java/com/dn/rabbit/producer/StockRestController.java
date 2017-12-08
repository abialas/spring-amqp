package com.dn.rabbit.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adam.
 */
@RestController
public class StockRestController {

    private StockProducer producer;

    public StockRestController(StockProducer stockProducer) {
        this.producer = stockProducer;
    }

    @GetMapping("/stocks/docs")
    public void processDocOnStock(@RequestParam("docId") Long docId) {
        producer.processDocOnStock(docId);
    }

}
