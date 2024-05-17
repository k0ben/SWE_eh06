package swp.chat.udp.sender;

import java.io.IOException;
import java.net.*;

public class SendUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket udpSocket = new DatagramSocket();
        args = new String[]{"localhost", "9000", "its raining a lot of Kurztestpunkte"};

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        byte[] msg = args[2].getBytes();

        InetAddress adr = InetAddress.getByName(host); //Hostname auflösen
        DatagramPacket pkt = new DatagramPacket(msg, msg.length, adr, port);

        udpSocket.send(pkt);
        udpSocket.close();
    }
}
