package swp.chat.app.process;

import swp.chat.app.handler.MessageHandler;

public interface MessageProcessor extends Runnable{
    void addHandler(MessageHandler messageHandler);
}
