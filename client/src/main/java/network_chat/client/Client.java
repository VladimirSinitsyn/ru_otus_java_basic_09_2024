package network_chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket clientSocket;
    private final DataInputStream in;
    private final DataOutputStream out;
    private final Scanner scanner;


    public Client() throws IOException {
        scanner = new Scanner(System.in);
        clientSocket = new Socket("127.0.0.1", 8888);
        out = new DataOutputStream(clientSocket.getOutputStream());
        in = new DataInputStream(clientSocket.getInputStream());
        {
            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        if (message.startsWith("/")) {
                            if (message.equalsIgnoreCase("/exitOK")) {
                                break;
                            }
                        } else {
                            System.out.println(message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    disconnect();
                }
            }).start();

            while (true) {
                String message = scanner.nextLine();
                out.writeUTF(message);
                if (message.equalsIgnoreCase("/exit")) {
                    break;
                }
            }
        }
    }

    public void disconnect() {

        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
