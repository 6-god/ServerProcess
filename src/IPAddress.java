import java.io.*;
import java.net.Socket;

public class IPAddress {
    public static IPAddress instance = new IPAddress();
    private BufferedReader mainPhoneReader = null;
    private BufferedWriter mainPhoneWriter = null;
    private BufferedReader mainCarReader = null;
    private BufferedWriter mainCarWriter = null;

    private IPAddress() {

    }

    public static IPAddress getInstance() {
        return instance;
    }

    private static String phoneIpAddress = null;
    private static String carIpAddress = null;
    private static Socket carMainSocket = null;
    private static Socket phoneMainSocket = null;
    //TODO:add two sockets and get / set method

    public void buildCarMainReaderWriter() {
        try {
            mainCarReader = new BufferedReader(new InputStreamReader(carMainSocket.getInputStream()));
            mainCarWriter = new BufferedWriter(new OutputStreamWriter(carMainSocket.getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buildPhoneMainReaderWriter() {
        try {
            mainPhoneReader = new BufferedReader(new InputStreamReader(phoneMainSocket.getInputStream()));
            mainPhoneWriter = new BufferedWriter(new OutputStreamWriter(phoneMainSocket.getOutputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendToPhone(String messages) {
        try {
            messages = messages + "\n";
            mainPhoneWriter.write(messages);
            mainPhoneWriter.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendToCar(String messages) {
        try {
            messages = messages + "\n";
            mainCarWriter.write(messages);
            mainCarWriter.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String receiveFromPhone() {
        try{
            return mainPhoneReader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return "receive failed";
    }

    public String receiveFromCar() {
        try{
            return mainCarReader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        return "receive failed";
    }


    public static String getCarIpAddress() {
        return carIpAddress;
    }

    public static String getPhoneIpAddress() {
        return phoneIpAddress;
    }

    public static void setCarIpAddress(String carIpAddress) {
        IPAddress.carIpAddress = carIpAddress;
    }

    public static void setPhoneIpAddress(String phoneIpAddress) {
        IPAddress.phoneIpAddress = phoneIpAddress;
    }

    public static Socket getCarMainSocket() {
        return carMainSocket;
    }

    public static Socket getPhoneMainSocket() {
        return phoneMainSocket;
    }

    public static void setCarMainSocket(Socket carMainSocket) {
        IPAddress.carMainSocket = carMainSocket;
    }

    public static void setPhoneMainSocket(Socket phoneMainSocket) {
        IPAddress.phoneMainSocket = phoneMainSocket;
    }
}