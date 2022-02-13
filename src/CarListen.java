import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CarListen extends Thread{
    private ServerSocket serverSocket = null;
    private Socket mainCarSocket;

    public void run() {
        System.out.println("car thread listening");
        try {
            serverSocket = new ServerSocket(10001);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //while(true){
            try{
                System.out.println("Listening!");
                mainCarSocket = serverSocket.accept();
                System.out.println("IP address:" + mainCarSocket.getInetAddress());
                IPAddress.setCarIpAddress(String.valueOf(mainCarSocket.getInetAddress()));
                IPAddress.setCarMainSocket(mainCarSocket);
            } catch (IOException e){
                e.printStackTrace();
            }

        //}
    }

}