package com.sharism.blog_server.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

/**
 * @author DYS
 * @Package com.sharism.user_server.kafka.consumer
 * @Description:
 * @date 2018/3/23-17:31
 * @Version: 1.0
 */
@Component
public class ConsumerReceiver {
    Logger logger = LoggerFactory.getLogger(this.getClass());
  /*  @KafkaListener(topics = {"test1"})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            logger.info("接收到消息："+message);
            System.out.println(message);
        }

    }*/

    @KafkaListener(topics = {"test3"})
    public void listen1(String value) {

     logger.info("接收到的kafka的value: " +value);

    }



}
