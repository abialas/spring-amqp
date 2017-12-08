package com.dn.rabbit.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by adam.
 */
@Component
public class OrderProducer {

    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.doc.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.doc.queue.order.routing.key}")
    private String orderRoutingKey;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void processDocOrder(Long docId) {
        rabbitTemplate.convertAndSend(exchangeName, orderRoutingKey, docId);
    }

}
