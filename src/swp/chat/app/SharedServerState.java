package swp.chat.app;

import swp.chat.app.buffer.MessageBuffer;
import swp.chat.app.client.Client;

import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SharedServerState {
    //speichern: datagrams socket, taskliste
    //zugriff auf clients, ...
    //synchronizedarray, synchronizedlits

    //TODO: gruppenzugehörigkeit, map mit key (bestimmte gruppe) und value mit Liste von Clients
    List<Client> clients = Collections.synchronizedList(new ArrayList<>());

    static DatagramSocket socket;

    MessageBuffer receiveMessageBuffer;

    MessageBuffer sendMessageBuffer;

    //TODO: Singleton preffered
    //wie Parameter übergeben? Setter

    public SharedServerState(DatagramSocket socket, MessageBuffer receiveMessageBuffer, MessageBuffer sendMessageBuffer) {
        this.socket = socket;
        this.receiveMessageBuffer = receiveMessageBuffer;
        this.sendMessageBuffer = sendMessageBuffer;
    }

    public static DatagramSocket getSocket() {
        return socket; //sender/receiver
    }

    public MessageBuffer getReceiveMessageBuffer() {
        return receiveMessageBuffer; //receiver / (Process)
    }

    public MessageBuffer getSendMessageBuffer() {
        return sendMessageBuffer; //sender / (Process)
    }

    public void addClient(Client client) { //wird von command Handlern aufgerufen
        this.clients.add(client);
    }
}
