package functional;

import functional.strategy.StrategyDemo;
import functional.factory.FactoryDemo;
import functional.decorator.DecoratorDemo;
import functional.executearound.ExecuteAroundDemo;

public class MainFunctional {
    public static void main(String[] args) {
        StrategyDemo.run();
        FactoryDemo.run();
        DecoratorDemo.run();
        ExecuteAroundDemo.run();
    }
}