package server.dummy.domain;

import javax.ws.rs.FormParam;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label="User")
public class User {
	
	public User(){}
	
	@GraphId
	private Long id;
	
	@FormParam("name")
	@Property(name="name")
	private String name;
	
	@FormParam("email")
	@Property(name="email")
	private String email;
	
	@FormParam("phone")
	@Property(name="phone")
	private Long phone;
	
	@FormParam("password")
	@Property(name="password")
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String toString(){
		return new StringBuffer("name: ").append(name).append(", email: ").append(email).toString();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
