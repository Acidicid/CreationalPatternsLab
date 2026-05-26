package structural.composite;
public class SystemFile implements FileSystemNode {
    private String name;
    public SystemFile(String name) { this.name = name; }
    public void scanForViruses() { System.out.println(" - Перевірка файлу: " + name); }
}