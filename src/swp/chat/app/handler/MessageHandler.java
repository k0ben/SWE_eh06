package swp.chat.app.handler;

import swp.chat.app.message.Message;

public interface MessageHandler {
    boolean handleMessage(Message message); //update
}
