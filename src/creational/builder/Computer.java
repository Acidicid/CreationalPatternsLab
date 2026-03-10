package creational.builder;

public class Computer {
    private String cpu;
    private int ram;
    private int storage;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }
    public void setStorage(int storage) {
        this.storage = storage;
    }
    public void show(){
        System.out.println(cpu+" RAM:"+ram+" GB Storage:"+storage+"GB");
    }
}
