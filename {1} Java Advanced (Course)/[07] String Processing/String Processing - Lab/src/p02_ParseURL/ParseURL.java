package p02_ParseURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseURL {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        String protocol;
        String server;
        String reseources;

        if(input.contains("://")) {
            protocol = input.substring(0, input.indexOf("://"));
            input = input.replace(protocol + "://", "");

            if(input.contains("/") && !input.contains("://")) {
                server = input.substring(0, input.indexOf("/"));

                input = input.replace(server + "/", "");

                reseources = input;

                System.out.println("Protocol = " + protocol);
                System.out.println("Server = " + server);
                System.out.println("Resources = " + reseources);
            } else {
                System.out.println("Invalid URL");
            }
        } else {
            System.out.println("Invalid URL");
        }
    }
}
