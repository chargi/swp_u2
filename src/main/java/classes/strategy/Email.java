package classes.strategy;

import com.github.fhtw.swp.tutorium.strategy.ConcreteStrategy;
import interfaces.Strategy;

/**
 * Created by Chargi on 3.5.2016.
 */
@ConcreteStrategy(value = Strategy.class)
public class Email extends SaveContext implements Strategy {

    public Email() {
        setSavePath("email");
        setIdentifier("email");
    }
}
