package jammazwan.xzj;

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
		Thread.sleep(5000);// to give time for csv import
		consumer.receive("jpa:jammazwan.entity.City?consumer.nativeQuery=select * from City&consumeDelete=false");
	}

	/*
	 * I have successfully run this one, but no longer.
	 */
	@Test
	public void testXzjWithSingle() throws Exception {
		City city = new City(22, "ATX", "USA", 111, 111, 11);
		Object myobj = template.requestBody("jpa:jammazwan.entity.City", city);
		Thread.sleep(500);
		Object obj = consumer
				.receive("jpa:jammazwan.entity.City?consumer.nativeQuery=select * from City&consumeDelete=false");
		System.err.println("********************** " + obj.toString());
	}

}
