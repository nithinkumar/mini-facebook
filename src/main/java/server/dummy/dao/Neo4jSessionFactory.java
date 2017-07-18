package server.dummy.dao;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class Neo4jSessionFactory {

	private static SessionFactory sessionFactory = null;
	private static Neo4jSessionFactory factory = new Neo4jSessionFactory();
	
	private static Configuration getConfig(){
		Configuration config = new Configuration();
		config.driverConfiguration()
		    .setDriverClassName("org.neo4j.ogm.drivers.bolt.driver.BoltDriver")
		    .setURI("bolt://neo4j:ne04j@localhost")
		    .setConnectionPoolSize(10);
		return config;
	}
	
	public static SessionFactory getSessionFactory(){
		
		if(sessionFactory == null){
			sessionFactory = new SessionFactory(getConfig(),"server.dummy.domain");
		}
		return sessionFactory;
	}
	
	public Session getSession(){
		return getSessionFactory().openSession();
	}
	//https://graphaware.com/neo4j/2016/09/30/upgrading-to-sdn-42.html
	//try this
	
	 public static Neo4jSessionFactory getInstance() {
	     return factory;
    }

    // prevent external instantiation
    private Neo4jSessionFactory() {
    }

}
