package creational;

import creational.abstractfactory.Button;
import creational.abstractfactory.Checkbox;
import creational.abstractfactory.GUIFactory;
import creational.abstractfactory.WindowsFactory;
import creational.builder.Computer;
import creational.builder.ComputerBuilder;
import creational.factory.Transport;
import creational.factory.TransportFactory;
import creational.factorymethod.EmailCreator;
import creational.factorymethod.Notification;
import creational.factorymethod.NotificationCreator;
import creational.prototype.GameCharacter;
import creational.singletone.Logger;


public class Main {
    public static void main(String[] args) {

        System.out.println("=== Singleton ===");

        Logger logger = Logger.getInstance();
        logger.Log("Program started");


        System.out.println("\n=== Factory ===");

        TransportFactory factory = new TransportFactory();
        Transport car = factory.createTransport("car");
        car.deliver();


        System.out.println("\n=== Factory Method ===");

        NotificationCreator creator = new EmailCreator();
        Notification notification = creator.createNotification();
        notification.send();


        System.out.println("\n=== Abstract Factory ===");

        GUIFactory guiFactory = new WindowsFactory();

        Button button = guiFactory.createButton();
        button.paint();

        Checkbox checkbox = guiFactory.createCheckbox();
        checkbox.paint();


        System.out.println("\n=== Builder ===");

        Computer pc = new ComputerBuilder()
                .setCpu("Intel i7")
                .setRam(16)
                .setStorage(512)
                .build();

        pc.show();


        System.out.println("\n=== Prototype ===");

        GameCharacter hero = new GameCharacter("Knight",100);
        GameCharacter copy = hero.clone();

        hero.show();
        copy.show();
    }
}
