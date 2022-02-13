/**
 * listehThread 用于建立两个主ServerSocket.建立完成后无用。
 * 传输数据的socket在开始传输时通过主socket沟通建立
 */

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/*
class ListenThread extends Thread {
    //    IPAddress ipAddress = IPAddress.getInstance();
    ServerSocket serverSocketPhone = null;

    ServerSocket serverSocketCar = null;

    Socket mainSocketPhone = null;
    Socket mainSocketCar = null;


    public void startListen() {

        try {
            serverSocketPhone = new ServerSocket(10001);
            serverSocketCar = new ServerSocket(10002);

        } catch (IOException e) {
            e.printStackTrace();
        }
        int i = 0;

        try {
            System.out.println("Listening!");
            mainSocketCar = serverSocketCar.accept();
            System.out.println("IP address:" + mainSocketCar.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
        i++;
    }
}
*/
class ListenThread extends Thread{
    @Override
    public void run() {
        if(IPAddress.getCarMainSocket() == null){
            new CarListen().run();
        }
        if(IPAddress.getPhoneIpAddress() == null){
            new PhoneListen().run();
        }

    }
}