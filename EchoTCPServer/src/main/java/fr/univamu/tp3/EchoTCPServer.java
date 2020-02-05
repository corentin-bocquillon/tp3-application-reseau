package fr.univamu.tp3;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class EchoTCPServer {
    private ServerSocket server;

    public EchoTCPServer(int port) throws IOException {
        server = new ServerSocket(port);
    }

    public void run() throws IOException {
        while (true) {
            Socket client = server.accept();
            handleClient(client);
        }
    }

    private void handleClient(Socket client) {
        try {
            BufferedReader reader = new BufferedReader
                (new InputStreamReader(client.getInputStream()));
            OutputStreamWriter writer = new OutputStreamWriter(client.getOutputStream());

            while (true) {
                String msg = reader.readLine();

                if (msg == null) {
                    break;
                }

                msg = "> " + msg + "\n";
                writer.write(msg, 0, msg.length());
                writer.flush();
            }
        } catch(Exception e) {
            System.out.println(e);
        }

        try {
            client.close();
        } catch(IOException ioe) {
            return;
        }
    }
}
