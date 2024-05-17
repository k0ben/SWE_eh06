package swp.chat.app.message;

public class Message {

    String host;
    int port;
    char command; //Todo enum
    String payload;


    public Message(String host, int port, char command, String payload) {
        this.host = host;
        this.port = port;
        this.command = command;
        this.payload = payload;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public char getCommand() {
        return command;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", command=" + command +
                ", payload='" + payload + '\'' +
                '}';
    }
}
