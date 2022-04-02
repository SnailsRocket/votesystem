package com.xubo.votesystem.MQ.RabbitMQ;

import com.xubo.votesystem.constant.MQConstant;
import io.lettuce.core.dynamic.annotation.Key;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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


    @RabbitListener(bindings = @QueueBinding(
            key = MQConstant.DELAY_QUEUE + "_QUEUE",
            value =@Queue(value = MQConstant.DELAY_QUEUE + "_QUEUE", durable = "true"),
            exchange = @Exchange(value = MQConstant.DELAY_QUEUE, durable = "true", type = ExchangeTypes.DIRECT, delayed = "true", arguments = @Argument(name = "x-delayed-type", value = "direct"))
    ))
    public void receiveDelayMessage(String receive) {
        log.info(LocalDateTime.now().toString() + " - 消费数据：" + receive);
    }

    public static void main(String[] args) {

        List<Integer> i2 = Arrays.asList(3,5,6);
        List<Integer> i1= Arrays.asList(1,2,3,4);

        System.out.println(i2.containsAll(i1));
        Integer integer = Integer.valueOf(2);
        Integer integer1 = Integer.valueOf(1);
        Integer integer2 = Integer.valueOf(2);
        System.out.println(integer.compareTo(integer2));

    }



}
