package structural.bridge;
public abstract class Server {
    protected NetworkProtocol protocol;
    public Server(NetworkProtocol p) { this.protocol = p; }
    public abstract void sendData();
}