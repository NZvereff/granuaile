package org.gehennas.granuaile;

import org.apache.commons.cli.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Preferences {

    private static final String PORT = "port";
    private static final String USER_DATA = "userData";

    private final int port;
    private final Path userDataLocation;

    public Preferences(String... args) throws PrepareException{
        CommandLine cmd = createOptions(args);
        try {
            port = cmd.hasOption(PORT) ? (Integer) cmd.getParsedOptionValue(PORT) : 8080;
            userDataLocation = cmd.hasOption(USER_DATA) ? Paths.get(cmd.getOptionValue(USER_DATA)) : Paths.get(System.getProperty("user.home"), ".granuaile");
        } catch (ParseException| NumberFormatException e) {
            throw new PrepareException(e);
        }
    }

    public int getPort() {
        return port;
    }

    public Path getUserDataLocation() {
        return userDataLocation;
    }

    private CommandLine createOptions(String... args) throws PrepareException{
        final Options options = new Options();
        options.addOption(Option.builder().longOpt(USER_DATA).hasArg(true).desc("Application data location").build());
        options.addOption(Option.builder().longOpt(PORT).hasArg(true).desc("Server Port").type(Integer.class).build());

        CommandLineParser parser = new DefaultParser();
        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            throw new PrepareException(e);
        }
    }
}
