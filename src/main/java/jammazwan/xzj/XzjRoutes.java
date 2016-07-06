package jammazwan.xzj;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;


public class XzjRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//		from("file://src/main/resources/data/?noop=true&idempotent=true&fileName=city.csv")
//		.unmarshal(new BindyCsvDataFormat(City.class)).transacted().split(body()).to("jpa:jammazwan.entity.City").end();
}
}
