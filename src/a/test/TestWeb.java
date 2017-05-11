package a.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class TestWeb {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHello(){
		return "<html><font color='red'>" + "Hello" + "</font></html>";
	}
	
	

}
