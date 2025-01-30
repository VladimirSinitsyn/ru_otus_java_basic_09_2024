package homework13.calculator;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("127.0.0.1", 1234)) {
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Соединение с сервером по адресу " + socket.getRemoteSocketAddress() + " установлено");
            String operations = bufferedReader.readLine();
            System.out.println(operations);

            while (true) {
                String response = bufferedReader.readLine();

                if (response.equals("exit")) break;
                System.out.println(response);
                if (response.startsWith("Введите")) {
                    String input = scanner.nextLine();
                    byte[] inputBytes = (input + "\n").getBytes();
                    outputStream.write(inputBytes);
                    outputStream.flush();
                }
            }
            System.out.println("Ошибка в приложении");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");;
        }
    }
}
