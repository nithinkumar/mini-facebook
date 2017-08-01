package server.dummy.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest")
public class RestConfig extends ResourceConfig {

	public RestConfig() {
		super();
		packages("server.dummy.rest");
//		register(MultiPartFeature.class);

	}
}
