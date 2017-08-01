package server.dummy.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.functors.ComparatorPredicate.Criterion;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.ogm.cypher.Filter;
import org.neo4j.ogm.cypher.Filters;
import org.neo4j.ogm.session.Session;
import org.springframework.stereotype.Repository;

import server.dummy.domain.User;

@Repository
public class UserDao {
	
	protected Session session = Neo4jSessionFactory.getInstance().getSession();
	private static final String neouser = "neo4j";
	private static final String neopass = "ne04j";

	public static void addDummyNode(){
		Driver driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( neouser, neopass ) );
		org.neo4j.driver.v1.Session session = driver.session();
		StatementResult result = session.run( "MATCH (a:User) RETURN a.name As name" );
		while ( result.hasNext() )
		{
			Record record = result.next();
			System.out.println( record.get( "name" ).asString() );
		}
	}
	
	public Collection<User> getUsers(){
		return session.loadAll(User.class);
	}
	
	public User getUserById(Long id){
		return session.load(User.class, id, 1);
	}
	
	public List<User> getUser(String propertyName, String propertyValue){
		Filters filters = new Filters();
		filters.add(new Filter(propertyName, propertyValue));
		
		Collection<User> loadAll = session.loadAll(User.class, filters);
		return (List<User>) loadAll;
	}
	
	public int getUserCountByEmailorPhone(String email, String phone){

		Driver driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( neouser, neopass ) );
		org.neo4j.driver.v1.Session session = driver.session();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("email", email);
		parameters.put("phone", Integer.valueOf(phone));
		 
		StatementResult result = session.run( "MATCH (a:User) where a.email={email} OR a.phone={phone} RETURN a", parameters);
		int count = 0;
		while ( result.hasNext() )
		{
			count++;
		}
		return count;
	} 
	
	public void save(User user){
		session.save(user);
	}
}
