package behavioral.iterator;

interface Iterator {
    boolean hasNext();
    Object next();
}

class SystemLogs {
    private String[] logs = {"Log1: Login OK", "Log2: Failed Password", "Log3: Update Done"};

    public Iterator getIterator() { return new LogIterator(); }

    private class LogIterator implements Iterator {
        int index;
        public boolean hasNext() { return index < logs.length; }
        public Object next() { return hasNext() ? logs[index++] : null; }
    }
}

public class IteratorDemo {
    public static void run() {
        System.out.println("\n=== 3. Iterator ===");
        SystemLogs logs = new SystemLogs();
        for (Iterator iter = logs.getIterator(); iter.hasNext();) {
            System.out.println(iter.next());
        }
    }
}