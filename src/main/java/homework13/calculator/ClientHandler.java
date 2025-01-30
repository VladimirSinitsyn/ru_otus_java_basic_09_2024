package homework13.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class ClientHandler {
    private Socket clientSocket;
    private BufferedReader bufferedReader;
    private OutputStream outputStream;


    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.outputStream = clientSocket.getOutputStream();
    }

    public void close() throws IOException {
        bufferedReader.close();
        outputStream.close();
        clientSocket.close();
    }

    public void sendMessage(String message) throws IOException {
        byte[] messageBytes = (message + "\n").getBytes();
        outputStream.write(messageBytes);
        outputStream.flush();
    }

    public void handleClient() throws IOException {
        sendMessage("Доступные операции: +, -, *, /");

        while (true) {

            sendMessage("Введите первое число:");
            String number1 = bufferedReader.readLine();
            if (number1 == null || number1.length() == 0) {
                break;
            }
            sendMessage("Введите второе число:");
            String number2 = bufferedReader.readLine();
            if (number2 == null || number2.length() == 0) break;
            sendMessage("Введите нужную операцию: (+, -, *, /)");
            String operation = bufferedReader.readLine();
            if (operation == null || operation.length() == 0) break;


            try {
                double num1 = Double.parseDouble(number1);
                double num2 = Double.parseDouble(number2);
                double result;

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            System.out.println("Нельзя делить на ноль");
                            continue;
                        }
                        result = num1 / num2;
                        break;

                    default:
                        sendMessage("Некорректный оператор. Доступные операторы: (+, -, *, /)");
                        continue;
                }
                sendMessage("Результат" + result);
            } catch (NumberFormatException e) {
                sendMessage("Некорректный ввод данных");
            } catch (IOException e) {
                System.out.println("Произошла ошибка. Клиент отключился " + clientSocket.getInetAddress());
            }
        }

    }

}



