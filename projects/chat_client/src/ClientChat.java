import java.io.*;
import java.net.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientChat {
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    JTextArea incoming;
    BufferedReader reader;

    // make gui and regist8r a listener with the send button
    // call the setOpNe tworkiDg () method
    public void go() {
        JFrame frame = new JFrame("Ludicrous Simple Chat Client");
        JPanel maiPanel = new JPanel();
        incoming = new JTextArea(15, 50);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        maiPanel.add(qScroller);
        maiPanel.add(outgoing);
        maiPanel.add(sendButton);
        setUpNetwork();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, maiPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    // make a Socket, then malc.e a PrintWriter
    // assign the PrintWriter to writer instance variable
    private void setUpNetwork() {
        String localhost = "127.0.0.1";
        int tcpPort = 5000;
        try {
            sock = new Socket(localhost, tcpPort);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Network established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // close setUpNetworking

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    } // close send inner class

    public class IncomingReader implements Runnable {
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    // Debug print statements on message from the server
                    /* System.out.println("Received message from server " + message);
                    System.out.println("Message length: " + message.length());

                    if (message.isEmpty()) {
                        System.out.println("Message is empty");
                    } */
                    
                    // Message from the server
                    System.out.println("Read " + message);
                    final String finalMessage = message;
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            incoming.setEditable(true);
                            incoming.append(finalMessage + "\n");
                            incoming.setEditable(false);
                            incoming.setCaretPosition(incoming.getDocument().getLength());
                        }
                    });
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    } // close receive inner class
}
