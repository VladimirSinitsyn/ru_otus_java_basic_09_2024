package network_chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final Socket clientSocket;
    private final Server server;
    private final DataInputStream in;
    private final DataOutputStream out;
    private final String userName;
    private static int userCount = 0;


    public ClientHandler(Socket clientSocket, Server server) throws IOException {
        this.clientSocket = clientSocket;
        this.server = server;
        this.in = new DataInputStream(clientSocket.getInputStream());
        this.out = new DataOutputStream(clientSocket.getOutputStream());
        userCount++;
        userName = "User" + userCount;

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился " + clientSocket.getRemoteSocketAddress());

                while (true) {
                    String message = in.readUTF();
                    String[] strings = message.split(" ", 3);

                    if (message.startsWith("/")) {
                        if (message.equalsIgnoreCase("/exit")) {
                            sendMessage("/exitOK");
                            break;
                        } else if (strings[0].equalsIgnoreCase("/w")) {
                            if (strings.length < 3) {
                                sendMessage("Ошибка: Неверный формат команды. Используйте /w <ник> <сообщение>");
                                continue;
                            }
                        }
                        String recipientName = strings[1];
                        String privateMessage = strings[2];
                        ClientHandler recipient = server.searchUserByName(recipientName);
                        if (recipient != null) {
                            recipient.sendMessage("Личное сообщение от " + userName + ": " + privateMessage);
                            sendMessage("Вы отправили " + recipientName + ": " + privateMessage);

                        } else {
                            sendMessage("Пользователь " + recipientName + " не найден.");

                        }
                    } else {
                        server.broadcast(userName + " : " + message);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        server.unSubscribe(this);
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

    public String getUserName() {
        return userName;
    }
}
