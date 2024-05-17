package swp.chat.app.client;

public class Client {
    String host;
    int port;
    int receivingPort;

    public Client(String host, int port, int receivingPort) {
        this.host = host;
        this.port = port;
        this.receivingPort = receivingPort;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getReceivingPort() {
        return receivingPort;
    }

    public void setReceivingPort(int receivingPort) {
        this.receivingPort = receivingPort;
    }
}
