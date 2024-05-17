package swp.chat.app;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatClient {
    private static String chatroom; //beim connect wird group mit angegeben.
    //Todo: client muss erweitert werden, Nachrichten reagieren
    private static String nickname;
    private static int receiverPort;
    private static String serverName;
    private static int serverPort;


    public static void main(String[] args) {
        //todo if args
        args = new String[]{"group1", "ben", "1234", "localhost", "9000"};
        chatroom = args[0];
        nickname = args[1];
        receiverPort = Integer.parseInt(args[2]);
        serverName = args[3];
        serverPort = Integer.parseInt(args[4]);

        Thread thread = new Thread(() -> {
            try{
                DatagramSocket rec = new DatagramSocket(receiverPort);
                while (true){
                    byte[] buffer = new byte[2048];
                    DatagramPacket pkt = new DatagramPacket(buffer, buffer.length);
                    System.out.println("Client waiting for msg");
                    rec.receive(pkt);
                    System.out.println(new String(buffer).trim());
                }
            } catch (SocketException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //Todo in byte umwandeln, socket.send
        //Todo: send
    }
}
