package structural.flyweight;
import java.util.HashMap;
import java.util.Map;

public class RuleFactory {
    private static Map<String, ConnectionRule> rules = new HashMap<>();

    public static ConnectionRule getRule(String type) {
        if (!rules.containsKey(type)) { rules.put(type, new ConnectionRule(type)); }
        return rules.get(type);
    }
}