package tacos.kitchen.messaging.jms;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import tacos.Order;

@Profile("jms-template")
@Service
public class JmsOrderMessagingService implements OrderMessagingService {

    private JmsTemplate jmsTemplate;

    @Autowired
    public JmsOrderMessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

	@Override
	public void sendOrder(Order order) {
		System.out.println("sendOrder function called");
		//jmsTemplate.send(session -> session.createObjectMessage((Serializable) order));
		jmsTemplate.convertAndSend("tacocloud.order.queue", order,
	            this::addOrderSource);
	}


	private Message addOrderSource(Message message) throws JMSException {
	    message.setStringProperty("X_ORDER_SOURCE", "WEB");
	    return message;
	}
}