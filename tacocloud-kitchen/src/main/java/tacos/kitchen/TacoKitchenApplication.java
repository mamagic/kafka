package tacos.kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;

@SpringBootApplication(exclude = JmsAutoConfiguration.class)
public class TacoKitchenApplication {

  public static void main(String[] args) {
    SpringApplication.run(TacoKitchenApplication.class, args);
  }

}
