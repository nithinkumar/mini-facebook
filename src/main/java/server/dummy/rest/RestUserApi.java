package server.dummy.rest;

import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import server.dummy.domain.User;
import server.dummy.helper.RestResponse;
import server.dummy.helper.RestUtil;
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
	
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@POST
	public Response addUser(@BeanParam User user){
		RestResponse<Map<String, Object>> response = new RestResponse<Map<String,Object>>();
		try{
			Long.valueOf(user.getPhone());
		}
		catch(Exception e){
			response.setStatus(Status.BAD_REQUEST.getStatusCode());
			response.setMessage("phone input is of wrong format 0-9(10)");
			return RestUtil.parseResponse(response);
		}
		int userCountByEmailorPhone = userService.getUserCountByEmailorPhone(user.getEmail(), String.valueOf(user.getPhone()));
		if(userCountByEmailorPhone>0){
			response.setStatus(Status.BAD_REQUEST.getStatusCode());
			response.setMessage("user exists with given email or phone");
		}
		userService.addUser(user);
		response.setStatus(Status.OK.getStatusCode());
		response.setMessage("User created Successfully");
		return RestUtil.parseResponse(response);
	}
}
