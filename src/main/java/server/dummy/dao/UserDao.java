package server.dummy.dao;

import java.util.Collection;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.ogm.session.Session;
import org.springframework.stereotype.Repository;

import server.dummy.domain.User;

@Repository
public class UserDao {
	
	protected Session session = Neo4jSessionFactory.getInstance().getSession();

	public static void addDummyNode(){
		Driver driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( "neo4j", "ne04j" ) );
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
}
