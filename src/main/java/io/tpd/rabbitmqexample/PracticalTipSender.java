package io.tpd.rabbitmqexample;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PracticalTipSender {

    private final RabbitTemplate rabbitTemplate;


    public PracticalTipSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @Scheduled(fixedDelay=3000L)
    public void sendPracticalTip(){

        PracticalTipMessage tip=new PracticalTipMessage("Always use Immutable classes in java",1,false);

        rabbitTemplate.convertAndSend(RabbitmqExampleApplication.EXACHANGE_NAME,RabbitmqExampleApplication.ROUTING_KEY,tip);

    }
}
