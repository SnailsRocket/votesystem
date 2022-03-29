package com.xubo.votesystem.MQ.RabbitMQ;

import com.xubo.votesystem.constant.MQConstant;
import io.lettuce.core.dynamic.annotation.Key;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author xubo
 * @Date 2022/3/29 11:18
 */
@Component
@Slf4j
public class OrderConsumer {

    @RabbitListener(bindings = @QueueBinding(
                key = MQConstant.ORDER_EXCHANGE + "_QUEUE",
                exchange = @Exchange(value = MQConstant.ORDER_EXCHANGE, durable = "true", type = ExchangeTypes.DIRECT),
                value = @Queue(value = MQConstant.ORDER_EXCHANGE + "_QUEUE", durable = "true")
            ))
    public void receiveOrder(String receive) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("消费数据：" +receive);
    }


}
