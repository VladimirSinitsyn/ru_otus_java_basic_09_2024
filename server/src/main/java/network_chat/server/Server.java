package network_chat.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private final int port;
    private final List<ClientHandler> clients;

    public int getPort() {
        return port;
    }

    public Server(int port) {
        this.port = port;
        this.clients = new CopyOnWriteArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(getPort())) {
            System.out.println("Сервер запустился на порту 8888");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                subscribe(new ClientHandler(clientSocket, this));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unSubscribe(ClientHandler clientHandler) {
        broadcast(clientHandler.getUserName() + " вышел из чата");
        clients.remove(clientHandler);
    }

    public void broadcast(String message) {
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message);
        }
    }

    public ClientHandler searchUserByName(String userName) {
        for (ClientHandler client : clients) {
            if (client.getUserName().equalsIgnoreCase(userName)) {
                return client;
            }
        }
        return null;
    }
}

