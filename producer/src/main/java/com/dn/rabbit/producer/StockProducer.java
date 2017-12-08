package com.dn.rabbit.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by adam.
 */
@Component
public class StockProducer {

    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.doc.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.doc.queue.stock.routing.key}")
    private String stockRoutingKey;

    public StockProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void processDocOnStock(Long docId) {
        rabbitTemplate.convertAndSend(exchangeName, stockRoutingKey, docId);
    }

}
