package behavioral.strategy;

interface EncryptionStrategy { void encrypt(String data); }

class AESEncryption implements EncryptionStrategy {
    public void encrypt(String data) { System.out.println("Шифрування AES: " + data); }
}

class RSAEncryption implements EncryptionStrategy {
    public void encrypt(String data) { System.out.println("Шифрування RSA: " + data); }
}

class DataTransmitter {
    private EncryptionStrategy strategy;
    public void setStrategy(EncryptionStrategy strategy) { this.strategy = strategy; }
    public void send(String data) { strategy.encrypt(data); }
}

public class StrategyDemo {
    public static void run() {
        System.out.println("\n=== 8. Strategy ===");
        DataTransmitter transmitter = new DataTransmitter();
        transmitter.setStrategy(new AESEncryption());
        transmitter.send("Секретні Дані");
    }
}