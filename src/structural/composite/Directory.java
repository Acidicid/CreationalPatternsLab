package structural.composite;
import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemNode {
    private String name;
    private List<FileSystemNode> nodes = new ArrayList<>();

    public Directory(String name) { this.name = name; }
    public void add(FileSystemNode node) { nodes.add(node); }

    public void scanForViruses() {
        System.out.println("Сканування директорії [" + name + "]:");
        for (FileSystemNode n : nodes) { n.scanForViruses(); }
    }
}