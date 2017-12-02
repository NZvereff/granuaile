package org.gehennas.granuaile;

import org.apache.commons.cli.*;

public class Preferences {

    private static final String PORT = "port";
    private static final String USER_DATA = "userData";

    private int port = 8080;
    private String userDataLocation = System.getProperty("user.home") + "\\.granuaile";

    public Preferences(String... args) throws PrepareException{
        CommandLine cmdOptions = createOptions(args);
        if (cmdOptions.hasOption(PORT)) {
            try {
                port = Integer.parseInt(cmdOptions.getOptionValue(PORT));
            } catch (NumberFormatException e) {
                throw new PrepareException(e);
            }
        }
        if (cmdOptions.hasOption(USER_DATA)) {
            userDataLocation = cmdOptions.getOptionValue(USER_DATA);
        }
    }

    public int getPort() {
        return port;
    }

    private CommandLine createOptions(String... args) throws PrepareException{
        final Options options = new Options();
        options.addOption(Option.builder().longOpt(USER_DATA).hasArg(true).desc("Application data location").build());
        options.addOption(Option.builder().longOpt(PORT).hasArg(true).desc("Server Port").build());

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            throw new PrepareException(e);
        }
    }
}
