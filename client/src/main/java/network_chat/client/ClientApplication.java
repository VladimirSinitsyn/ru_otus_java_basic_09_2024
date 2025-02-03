package network_chat.client;

import java.io.IOException;


public class ClientApplication {
    public static void main() {
        try {
            new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
