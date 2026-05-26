package behavioral;

import behavioral.chain.ChainDemo;
import behavioral.command.CommandDemo;
import behavioral.iterator.IteratorDemo;
import behavioral.mediator.MediatorDemo;
import behavioral.memento.MementoDemo;
import behavioral.observer.ObserverDemo;
import behavioral.state.StateDemo;
import behavioral.strategy.StrategyDemo;
import behavioral.template.TemplateDemo;
import behavioral.visitor.VisitorDemo;

public class MainBehavioral {
    public static void main(String[] args) {
        ChainDemo.run();
        CommandDemo.run();
        IteratorDemo.run();
        MediatorDemo.run();
        MementoDemo.run();
        ObserverDemo.run();
        StateDemo.run();
        StrategyDemo.run();
        TemplateDemo.run();
        VisitorDemo.run();
    }
}