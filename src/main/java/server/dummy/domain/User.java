package server.dummy.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label="User")
public class User {
	
	public User(){}
	
	@GraphId
	private Long id;
	
	@Property(name="name")
	private String name;
	@Property(name="email")
	private String email;
	
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
}
