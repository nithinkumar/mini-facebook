package server.dummy.server_dummy;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.webapp.WebAppContext;

public class WebServer {

	public final Server server = new Server(8000);
	private final String contextPath;
	private static final String PROJECT_RELATIVE_PATH_TO_WEBAPP = "src/main/resources/META-INF/webapp";
	
	public WebServer(){
		contextPath="/";
		server.setHandler(createHandlers());
	}
	
	public void start() throws Exception {
		server.start();
	}

	public void join() throws InterruptedException {
		server.join();
	}
	
	private Handler createHandlers() {
		WebAppContext ctx = new WebAppContext();
		ctx.setContextPath(contextPath);

		ctx.setWar(PROJECT_RELATIVE_PATH_TO_WEBAPP);

		//        RequestLogHandler _log = new RequestLogHandler();
		//        _log.setRequestLog(createRequestLog());

		HandlerList handlers = new HandlerList();
		handlers.addHandler(ctx);
		return handlers;
	}
}
