package tacos.kitchen.messaging.jms;

import tacos.Order;

public interface OrderMessagingService {
	 public void sendOrder(Order order);
}
