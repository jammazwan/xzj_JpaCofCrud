package jammazwan.xzj;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XzjTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	@Test
	public void testXzjWithMultiple() throws Exception {
		Exchange exchange = consumer.receive(
				"jpa://jammazwan.xzj.City?consumer.nativeQuery=select * from City&consumeDelete=false&joinTransaction=false");
		// "jpa:jammazwan.xzj.City?consumer.query=select o from
		// jammazwan.xzj.City o where
		// o.rank=1&consumeDelete=false&joinTransaction=false");
		Object[] cities = (Object[]) exchange.getIn().getBody();
		if (null != cities && cities[0] != null) {
			System.err.println("CITIES NOT NULL YEAH "+ cities.length + " "+ cities[0].toString());
			
		} else {
			System.err.println("CITIES NULL");
		}
	}

	@Test
	public void testXzjWithSingle() throws Exception {
		City city = new City(22, "ATX", "USA", 111, 111, 11);
		Object myobj = template.requestBody("jpa:jammazwan.entity.City", city);
		Exchange exchange = (Exchange) consumer.receive(
				"jpa://jammazwan.xzj.City?consumer.nativeQuery=select * from City&consumeDelete=false&joinTransaction=false");
		System.err.println(exchange.getIn().getBody());
		Object[] cities = (Object[]) exchange.getIn().getBody();
		if (null != cities && cities[0] != null) {
			System.err.println("CITIES NOT NULL YEAH "+ cities.length + " "+ cities[1].toString());
			
		} else {
			System.err.println("CITIES NULL");
		}
	}

}
