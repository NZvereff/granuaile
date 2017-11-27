package org.gehennas.granuaile.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class RestServer {

    private final Server server;

    public RestServer(int port) {
        this.server = new Server(port);
    }

    public void configure() {
        ResourceConfig config = new ResourceConfig();
        config.packages("org.gehennas.granuaile.server.api");
        ServletHolder servletHolder = new ServletHolder(new ServletContainer(config));
        ServletContextHandler contextHandler = new ServletContextHandler(server,"/*");
        contextHandler.addServlet(servletHolder, "/*");
    }

    public void startAndJoin() {
        try {
            server.start();
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.destroy();
        }
    }
}
