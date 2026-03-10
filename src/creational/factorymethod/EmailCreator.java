package creational.factorymethod;

public class EmailCreator extends NotificationCreator {
    public Notification createNotification() {
        return new EmailNotification();
    }
}
