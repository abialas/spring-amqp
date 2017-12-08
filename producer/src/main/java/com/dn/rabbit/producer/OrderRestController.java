package com.dn.rabbit.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adam.
 */
@RestController
public class OrderRestController {

    private OrderProducer producer;

    public OrderRestController(OrderProducer stockProducer) {
        this.producer = stockProducer;
    }

    @GetMapping("/orders/docs")
    public void processDocOrder(@RequestParam("docId") Long docId) {
        producer.processDocOrder(docId);
    }

}
