package server.dummy.server_dummy;

import org.eclipse.jetty.server.Server;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) throws Exception
    {
    	WebServer server = new WebServer();
    	server.start();
    	server.join();
    }
}