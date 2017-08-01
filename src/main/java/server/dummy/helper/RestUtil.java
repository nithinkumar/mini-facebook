package server.dummy.helper;

import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestUtil {

	public static final ObjectMapper _mapper;
	
	static{
		_mapper = new ObjectMapper();
	}
	
	public static Response parseResponse(RestResponse<?> restResponse){
		try{
			return Response.ok().entity(_mapper.writeValueAsString(restResponse)).build();	
		}catch( Exception e){
			throw new RuntimeException(e);
		}
	}
}
