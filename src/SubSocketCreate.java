import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SubSocketCreate {
    SubSockets subSockets = SubSockets.getInstance();

    public void createSubSocketForCar(){
        String ip = String.valueOf(IPAddress.getCarIpAddress());
        try{
            ServerSocket controlReceiveServer = new ServerSocket(10010);
            ServerSocket pictureSendServer = new ServerSocket(10013);
            ServerSocket messageSendServer = new ServerSocket(10014);
            subSockets.controlReceive = controlReceiveServer.accept();
            subSockets.pictureSend = pictureSendServer.accept();
            subSockets.messageSend = messageSendServer.accept();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createSubSocketForPhone(){
        String ip = String.valueOf(IPAddress.getPhoneIpAddress());
        try{
            ServerSocket controlSendServer = new ServerSocket(10011);
            ServerSocket pictureReceiveServer = new ServerSocket(10012);
            ServerSocket messageReceiveServer = new ServerSocket(10015);
            subSockets.controlSend = controlSendServer.accept();
            subSockets.pictureReceive = pictureReceiveServer.accept();
            subSockets.messageReceive = messageReceiveServer.accept();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}