package com.dn.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by adam.
 */
@Component
public class ConsumerStock {

    @RabbitListener(queues = "${rabbitmq.doc.queue.stockProcess.name}")
    public void processDocOnStock(Long docId) {
        System.out.println("Process doc on stock: " + docId);
    }

}
