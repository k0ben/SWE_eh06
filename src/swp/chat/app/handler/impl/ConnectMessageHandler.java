package swp.chat.app.handler.impl;

import swp.chat.app.SharedServerState;
import swp.chat.app.client.Client;
import swp.chat.app.handler.AbstractMessageHandler;
import swp.chat.app.message.Message;

public class ConnectMessageHandler extends AbstractMessageHandler {
    //behandelt msg mit command c

    private static final char COMMAND = 'c';
    public ConnectMessageHandler(SharedServerState sharedServerState) {
        super(sharedServerState);
    }

    @Override
    public boolean handleMessage(Message message) {
        if (COMMAND == message.getCommand()){
            //schon connected - error
            //okay zurücksenden

            //payload zerteilen - port, gruppe auslesen
            //gruppe - client dann map hinzufügen

            String[] data = message.getPayload().split(" "); //udp protokoll - leerzeichengetrennt
            Client client = new Client(message.getHost(), message.getPort(), Integer.parseInt(data[0]));
            sharedServerState.addClient(client);
            //todo map statt liste

            Message m = new Message(message.getHost(), client.getReceivingPort(), 'o', message.getPort() + "");
            sharedServerState.getSendMessageBuffer().add(m);
            return true;
        }
        return false;
    }
}
