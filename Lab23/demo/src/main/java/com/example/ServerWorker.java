//Name: Ariana Rocha
//AndrewID: afrocha
//Assignment: LAB23

package com.example;
//TCP server makes a connection for each client and then echoes the client’s request
import java.net.*; 
import java.io.*;
import java.util.Scanner;

public class ServerWorker extends Thread {
    private static int clientCounter = 0;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private Scanner scanner;

    public ServerWorker(Socket socket) {
        this.socket = socket;
        try {
            this.input = new DataInputStream(socket.getInputStream());
            this.output = new DataOutputStream(socket.getOutputStream());
            this.scanner = new Scanner(System.in);
        } catch (IOException e) { System.out.println("Error initializing streams: " + e.getMessage());}
        this.start();
    } 

    @Override public void run() {
        clientCounter++;
        String message;
        String reply;
        System.out.println("Starting new connection for client " + clientCounter);
        try{
            while(true) {
                message = input.readUTF();
                if(message.equalsIgnoreCase("QUIT")) break;
                System.out.println(clientCounter + ") Server received: " + message);

                //keyboard reply
                System.out.print(clientCounter + "Enter a reply: ");
                reply = scanner.nextLine();
                output.writeUTF(reply);
            }
        } catch (EOFException e) {System.out.println("Client disconnected.");
        } catch (IOException e) {System.out.println("I/O Error: " + e.getMessage());
        } finally {
            try{
                socket.close();
                if(scanner !=null) scanner.close();
            } catch (IOException e) {System.out.println("Error closing socket: " + e.getMessage());}
        }
    }
}