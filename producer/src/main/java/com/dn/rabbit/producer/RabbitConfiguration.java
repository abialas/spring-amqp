package com.dn.rabbit.producer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by adam.
 */
@Configuration
public class RabbitConfiguration {

    @Bean
    public TopicExchange topicExchange(@Value("${rabbitmq.doc.exchange.name}") String exchangeName) {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue queueStock(@Value("${rabbitmq.doc.queue.stockProcess.name}") String stockProcessQueueName) {
        return new Queue(stockProcessQueueName);
    }

    @Bean
    public Queue queueOrder(@Value("${rabbitmq.doc.queue.orderProcess.name}") String orderProcessQueueName) {
        return new Queue(orderProcessQueueName);
    }

    @Bean
    public Binding bindingStock(Queue queueStock, TopicExchange topicExchange,
                                @Value("${rabbitmq.doc.queue.stock.routing.key}") String stockRoutingKey) {
        return BindingBuilder.bind(queueStock).to(topicExchange).with(stockRoutingKey);
    }

    @Bean
    public Binding bindingOrder(Queue queueOrder, TopicExchange topicExchange,
                                @Value("${rabbitmq.doc.queue.order.routing.key}") String orderRoutingKey) {
        return BindingBuilder.bind(queueOrder).to(topicExchange).with(orderRoutingKey);
    }

}
