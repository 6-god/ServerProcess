import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PhoneListen extends Thread {
    private ServerSocket serverSocket = null;
    private Socket mainPhoneSocket;

    public void run() {

        System.out.println("phone thread listening");
        try {
            serverSocket = new ServerSocket(10001);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //while(true){
        try{
            System.out.println("Listening!");
            mainPhoneSocket = serverSocket.accept();
            System.out.println("IP address:" + mainPhoneSocket.getInetAddress());
            IPAddress.setPhoneIpAddress(String.valueOf(mainPhoneSocket.getInetAddress()));
            IPAddress.setPhoneMainSocket(mainPhoneSocket);
        } catch (IOException e){
            e.printStackTrace();
        }

        //}
    }

}