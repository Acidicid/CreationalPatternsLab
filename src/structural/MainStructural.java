package structural;

import structural.adapter.*;
import structural.bridge.*;
import structural.composite.*;
import structural.decorator.*;
import structural.facade.*;
import structural.flyweight.*;
import structural.proxy.*;

public class MainStructural {
    public static void main(String[] args) {
        System.out.println("=== 1. Adapter ===");
        ModernSecurity security = new CipherAdapter(new LegacyCipher());
        security.encryptData();

        System.out.println("\n=== 2. Bridge ===");
        Server proxy = new ProxyNode(new TCP());
        proxy.sendData();

        System.out.println("\n=== 3. Composite ===");
        Directory root = new Directory("C:/System32");
        root.add(new SystemFile("kernel.dll"));
        root.add(new SystemFile("config.sys"));
        root.scanForViruses();

        System.out.println("\n=== 4. Decorator ===");
        DataSource rawData = new CoreData();
        DataSource secureData = new EncryptionDecorator(rawData);
        System.out.println("Базовий потік: " + rawData.readData());
        System.out.println("Захищений потік: " + secureData.readData());

        System.out.println("\n=== 5. Facade ===");
        SecurityFacade sysFacade = new SecurityFacade();
        sysFacade.lockdown();

        System.out.println("\n=== 6. Flyweight ===");
        ConnectionRule blockHttp = RuleFactory.getRule("BLOCK_HTTP");
        blockHttp.applyRule("192.168.1.10");
        ConnectionRule blockHttp2 = RuleFactory.getRule("BLOCK_HTTP");
        System.out.println("Правила використовують один об'єкт у пам'яті? " + (blockHttp == blockHttp2));

        System.out.println("\n=== 7. Proxy ===");
        Database adminAccess = new SecureProxy(false);
        adminAccess.executeQuery("SELECT * FROM users");
        Database hackerAccess = new SecureProxy(true);
        hackerAccess.executeQuery("DROP TABLE users");
    }
}