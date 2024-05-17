package swp.chat.app.handler;

import swp.chat.app.SharedServerState;

public abstract class AbstractMessageHandler implements MessageHandler{

    protected SharedServerState sharedServerState;

    public AbstractMessageHandler(SharedServerState sharedServerState) {
        this.sharedServerState = sharedServerState;
    }
}
