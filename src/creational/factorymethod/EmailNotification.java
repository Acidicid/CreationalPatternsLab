package creational.factorymethod;

public class EmailNotification implements Notification {
    public void send() {
        System.out.println("Sending email notification");
    }
}
