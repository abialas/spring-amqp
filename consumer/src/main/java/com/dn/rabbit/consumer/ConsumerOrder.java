package com.dn.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by adam.
 */
@Component
public class ConsumerOrder {

    @RabbitListener(queues = "${rabbitmq.doc.queue.orderProcess.name}")
    public void processDocOrder(Long docId) {
        System.out.println("Process doc order: " + docId);
    }

}
