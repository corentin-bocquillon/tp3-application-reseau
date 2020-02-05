package fr.univamu.tp3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    public static void main( String[] args ) {
        if (args.length < 2) {
            print_help();
            return;
        }

        try {
            EchoTCPClient client = new EchoTCPClient(args[0], new Integer(args[1]));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String msg = null;

                try {
                    msg = reader.readLine();
                    if (msg == null) {
                        break;
                    }
                    client.send(msg + "\n");
                    System.out.println(client.recv());
                } catch (Exception e) {
                    System.out.println("Échec de l’envoi du message." + e);
                    continue;
                }
            }
        } catch(Exception e) {
            System.out.println("Échec de la connexion au serveur." + e);
        }
    }

    public static void print_help() {
        System.out.println("Usage: EchoTCPClient.jar server port");
    }
}
