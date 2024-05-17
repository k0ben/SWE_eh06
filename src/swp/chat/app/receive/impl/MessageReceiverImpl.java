package swp.chat.app.receive.impl;

import swp.chat.app.SharedServerState;
import swp.chat.app.message.Message;
import swp.chat.app.receive.MessageReceiver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MessageReceiverImpl implements MessageReceiver {
    SharedServerState sharedServerState;
    public MessageReceiverImpl(SharedServerState sharedServerState) {
        this.sharedServerState = sharedServerState;
    }

    @Override
    public void run() {
        byte[] buffer = new byte[2024];
        DatagramPacket pkt = new DatagramPacket(buffer, buffer.length);

        while (true) {

            try {
                SharedServerState.getSocket().receive(pkt);

                String m = new String(buffer, 0, pkt.getLength());
                if (!m.isEmpty()) {
                    char command = m.charAt(0);
                    if (m.length() > 2) {
                        Message message = new Message(pkt.getAddress().getHostName(), pkt.getPort(), command, m.substring(2));
                        sharedServerState.getReceiveMessageBuffer().add(message);
                    }
                    pkt.setLength(buffer.length);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
