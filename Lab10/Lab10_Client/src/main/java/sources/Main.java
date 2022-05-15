package sources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static Socket socket = null;

    public static void main(String args[]){
        String request = null;
        try {
            socket = new Socket("127.0.0.1", 8100);
            try {
                while (true){
                    //Sending a request
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    Scanner keyboard = new Scanner(System.in);
                    System.out.println("Enter request: ");
                    request = keyboard.nextLine();
                    writer.println(request);

                    //Receiving a response
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream())
                    );
                    String response = reader.readLine();
                    System.out.println("Server response: " + response);
                    if(request.equals("exit") || response.equals("Server stopping ...")){
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Server closed!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
