package swp.chat.app.process.impl;

import swp.chat.app.buffer.MessageBuffer;
import swp.chat.app.handler.MessageHandler;
import swp.chat.app.message.Message;
import swp.chat.app.process.MessageProcessor;

import java.util.ArrayList;
import java.util.List;

public class MessageProcessorImpl implements MessageProcessor {

    List<MessageHandler> handlerList = new ArrayList<>();

    MessageBuffer buffer;
    @Override
    public void addHandler(MessageHandler handler) {
        handlerList.add(handler);
    }

    @Override
    public void run() {
        Message message;
        if((message = buffer.get()) != null){
            buffer.delete(message);
            System.out.println("processor received" + message);
            for (MessageHandler handler : handlerList){
                if(handler.handleMessage(message));{
                    System.out.println("handeled" + message);
                }
            }

            try {
                Thread.sleep(2100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
