package creational.factorymethod;

public class SMSNotification implements Notification {
    public void send() {
        System.out.println("Sending SMS notification");
    }
}
