package homework13.calculator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Сервер запущен на порту " + serverSocket.getLocalPort());
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            System.out.println("Добро пожаловать в приложение калькулятор");


            ClientHandler clientHandler = new ClientHandler(clientSocket);
            try {
                clientHandler.handleClient();
            } catch (IOException e) {
                System.err.println("Ошибка обработки клиента" + e.getMessage());
            } finally {
                if (clientSocket != null) {
                    try {
                        clientHandler.close();
                    } catch (IOException e) {
                        System.err.println("Ошибка при закрытии сокета" + e.getMessage());
                    }
                }
            }

        }
    }
}

