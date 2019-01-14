package io.tpd.rabbitmqexample;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqExampleApplication {

    public static final String EXACHANGE_NAME="tips_tx";
	public static final String DEFAULT_PARSING_QUEUE="default_parser_q";
	public static final String ROUTING_KEY="tips";



	public static void main(String[] args) {
		SpringApplication.run(RabbitmqExampleApplication.class, args);
	}


	@Bean
  public TopicExchange tipsExachnage()
  {
  	return new TopicExchange((EXACHANGE_NAME));
  }


 @Bean
  public Queue defaultParsingQueue(){

		return new Queue(DEFAULT_PARSING_QUEUE);
  }

@Bean
  public Binding queueToExchangeBinding(){

		return BindingBuilder.bind(defaultParsingQueue()).to(tipsExachnage()).with(ROUTING_KEY);

  }
}

