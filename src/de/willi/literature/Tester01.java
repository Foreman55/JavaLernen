package de.willi.literature;

import java.net.ServerSocket;
import java.net.Socket;

public class Tester01{
    public static void main(String[] args) {
        int port = 8080;  // Port number to listen on

        try {
            // Create a new ServerSocket that listens on the specified port
            ServerSocket serverSocket = new ServerSocket(port);

            // Wait for incoming connections
            while (true) {
                System.out.println("Waiting for client on port " + port);
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress());

                // Do something with the clientSocket, such as read/write data or start a new thread to handle the connection
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

