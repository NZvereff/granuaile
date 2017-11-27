package org.gehennas.granuaile;

import org.gehennas.granuaile.server.RestServer;

public class AppLauncher {

    public static void main(String... args) {
        Preferences preferences = new Preferences(args);
        RestServer server = new RestServer(preferences.getPort());
        server.configure();
        server.startAndJoin();
    }

}