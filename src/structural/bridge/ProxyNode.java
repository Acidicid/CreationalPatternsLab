package structural.bridge;
public class ProxyNode extends Server {
    public ProxyNode(NetworkProtocol p) { super(p); }
    public void sendData() {
        System.out.print("Проксі-вузол відправляє дані ");
        protocol.transmit();
        System.out.println();
    }
}