package server.dummy.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import server.dummy.domain.User;
import server.dummy.service.UserService;

@Path("user")
@Controller
public class RestUserApi {

	@Autowired
	private UserService userService;
	
	@GET
	@Path("/dummy/add")
	public Response addDummy(){
		userService.dummy();
		System.out.println("here");
		return Response.ok().build();
	}
	
	@GET
	@Path("/{id}")
	public Response getUser(@PathParam("id")  String id){
		User user = userService.getDataById(id);
		return Response.ok().entity(user.toString()).build();
	}
}
