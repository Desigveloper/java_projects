import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    ArrayList<PrintWriter> clientOutputStreams;

    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket sock;

        public ClientHandler(Socket clientSocket) {
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    broadcast(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } // end of run methd
    } // end clientHandler class

    public static void main(String arg[]) {
        new ChatServer().go();
    } // end of main

    public void go() {
        clientOutputStreams = new ArrayList<>();

        ServerSocket serverSock = null;
        try {
            serverSock = new ServerSocket(5000);

            while (true) {
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                // Create a new ClientHandler instance and start it in a new thread
                Thread clienThread = new Thread(new ClientHandler(clientSocket));
                clienThread.start();
                System.out.println("got a connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } // end of catch
    }

    public void broadcast(String message) {
        Iterator<PrintWriter> it = clientOutputStreams.iterator();

        while (it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } // close broadcast
} // end of sever class
