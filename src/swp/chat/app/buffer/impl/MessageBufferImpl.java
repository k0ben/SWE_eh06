package swp.chat.app.buffer.impl;

import swp.chat.app.buffer.MessageBuffer;
import swp.chat.app.message.Message;

public class MessageBufferImpl implements MessageBuffer  {
    @Override
    public void add(Message message) {
        //todo: voll? warten, ansonsten füllen
    }

    @Override
    public synchronized Message get() {
        //todo eh nicht leer? warten bis element kommt, wenn element da zurückgeben, Nachricht löschen, Taskliste Platz freigebn
        //quasi tasklist reinkopieren
        //sollte synchronized sein, weil consumer und server (unterschiedliche Threads) auf die Tasklist zu grifen, ansonsten raceConditiones
        return null;
    }

    @Override
    public void delete(Message message) {

    }
}
