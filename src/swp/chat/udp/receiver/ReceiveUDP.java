package swp.chat.udp.receiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpSocket = null;
        args = new String[]{"9000"}; //todo: if, input validation
        int port = Integer.parseInt(args[0]);

        udpSocket = new DatagramSocket(port);

        byte[] buffer = new byte[2048];
        DatagramPacket pkt = new DatagramPacket(buffer, buffer.length);

        while (true){
            System.out.println("Listening to port ...");
            udpSocket.receive(pkt);
            String msg = new String(buffer, 0, pkt.getLength()); //ganzen Buffer auslesen
            System.out.println(msg + " " + pkt.getAddress().getHostName());
            pkt.setLength(buffer.length);
        }
    }
}

