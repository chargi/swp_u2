package classes.strategy;

import com.github.fhtw.swp.tutorium.command.Invoker;
import com.github.fhtw.swp.tutorium.strategy.ConcreteStrategy;
import interfaces.Strategy;

/**
 * Created by Chargi on 3.5.2016.
 */
@ConcreteStrategy(value = Strategy.class)
public class Telegram extends SaveContext implements Strategy {

    public Telegram() {
        setSavePath("telegram");
        setIdentifier("telegram");
    }
}
