package swp.chat.app.receive;

public interface MessageReceiver extends Runnable {

    //sollte können: zugriff auf taskliste - vom serverState - Zugriff notwendig
    //Nachricht entgegennehmen, in msg umwandel, msg speichern, zuhören
    //tranformieren von byte in msg in thread
    //alternativ: byte in buffer speichern - noch schneller

    //eigene Thread: serverSTate, Process, StateSender


}
