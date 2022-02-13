import java.io.Serializable;
import java.net.Socket;

public class SubSockets {   //单态设计
    private static SubSockets instance = new SubSockets();

    public static SubSockets getInstance() {
        return instance;
    }

    private SubSockets(){

    }

    Socket controlReceive = null;   //car 10010
    Socket controlSend = null;      //    10011
    Socket pictureReceive = null;   //    10012
    Socket pictureSend = null;      //car 10013
    Socket messageSend = null;      //car 10014
    Socket messageReceive = null;   //    10015
}

class ControlSignalPackage implements Serializable{
    double x;
    double y;
    double turn;
    public ControlSignalPackage(double xSpeed,double ySpeed,double turnSpeed){
        x = xSpeed;
        y = ySpeed;
        turn = turnSpeed;
    }
}

