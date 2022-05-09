package pubsubmin;


import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic = session.createTopic("India");
		MessageProducer producer = session.createProducer(topic);
		TextMessage message = session.createTextMessage();
		message.setText("Score is 200/5");
		producer.send(message);
		System.out.println("Sent message '" + message.getText() + "'");
		connection.close();
                
                
                
                
        ConnectionFactory connectionFactory1 = new ActiveMQConnectionFactory(url);
		Connection connection1 = connectionFactory1.createConnection();
		connection1.start();
		Session session1 = connection1.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Topic topic1 = session1.createTopic("Australia");
		MessageProducer producer1 = session1.createProducer(topic1);
		TextMessage message1 = session1.createTextMessage();
		message1.setText("Score is 190/6");
		producer1.send(message1);
		System.out.println("Sent message '" + message1.getText() + "'");
		connection1.close();
	}
}