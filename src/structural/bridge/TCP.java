package structural.bridge;
public class TCP implements NetworkProtocol {
    public void transmit() { System.out.print("через надійний протокол TCP"); }
}