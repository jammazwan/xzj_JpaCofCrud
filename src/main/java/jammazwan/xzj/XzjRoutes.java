package jammazwan.xzj;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;


public class XzjRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
		from("file:../jammazwan.shared/src/main/resources/data/csv/?noop=true&fileName=city.csv")
		.unmarshal(new BindyCsvDataFormat(City.class)).transacted().split(body()).to("jpa:jammazwan.entity.City").end();
}
}
