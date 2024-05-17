package swp.chat.app.buffer;

import swp.chat.app.message.Message;

public interface MessageBuffer {

    void add(Message message);

    Message get();

    void delete(Message message);
}
