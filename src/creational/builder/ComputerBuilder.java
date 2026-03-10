package creational.builder;

public class ComputerBuilder {
    private Computer computer = new Computer();
    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }
    public ComputerBuilder setRam(int ram) {
        computer.setRam(ram);
        return this;
    }
    public ComputerBuilder setStorage(int storage) {
        computer.setStorage(storage);
        return this;
    }
public  Computer build() {
        return computer;
    }
}
