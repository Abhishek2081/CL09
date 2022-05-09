package pubsubmin;


import java.io.IOException;
import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Subscriber {
// URL of the JMS server
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

// Name of the topic from which we will receive messages from = " CL9"
	public static void main(String[] args) throws JMSException {
// Getting JMS connection from the server
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("India");
		MessageConsumer consumer = session.createConsumer(topic);
		MessageListener listner = new MessageListener() {
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					System.out.println("Received message: " + textMessage.getText() + "'");
				}
			}
		};
		consumer.setMessageListener(listner);
		System.in.read();
		connection.close();
	}
}