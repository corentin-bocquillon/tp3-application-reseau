package fr.univamu.tp3;

import java.net.Socket;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class EchoTCPClient {
    private Socket server;

    public EchoTCPClient(String hostname, int port) throws Exception {
        this.server = new Socket(hostname, port);
    }

    public void send(String msg) throws java.io.IOException {
        OutputStreamWriter writer = new OutputStreamWriter(server.getOutputStream());
        writer.write(msg, 0, msg.length());
        writer.flush();
    }

    public String recv() throws java.io.IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
        return reader.readLine();
    }
}
