package hello;

import hello.order.gague.StockConfigV1;
import hello.order.gague.StockConfigV2;
import hello.order.v0.OrderConfigV0;
import hello.order.v1.OrderConfigV1;
import hello.order.v2.OrderConfigV2;
import hello.order.v3.OrderConfigV3;
import hello.order.v4.OrderConfigV4;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Slf4j
//@Import(OrderConfigV0.class)
//@Import(OrderConfigV1.class)
//@Import(OrderConfigV2.class)
//@Import(OrderConfigV3.class)
//@Import(OrderConfigV4.class)
//@Import({OrderConfigV4.class, StockConfigV1.class})
@Import({OrderConfigV4.class, StockConfigV2.class})
@SpringBootApplication(scanBasePackages = {"hello.controller"})
public class ActuatorApplication {
    @Autowired
    MeterRegistry meterRegistry;

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }

    @Bean
    public InMemoryHttpExchangeRepository httpExchangeRepository() {
        return new InMemoryHttpExchangeRepository();
    }
}
