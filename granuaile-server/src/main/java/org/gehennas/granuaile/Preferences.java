package org.gehennas.granuaile;

public class Preferences {

    private int port = 8080;

    public Preferences(String... args) {

    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
