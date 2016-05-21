package classes.strategy;

import com.github.fhtw.swp.tutorium.strategy.ConcreteStrategy;
import interfaces.Strategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Chargi on 3.5.2016.
 */
@ConcreteStrategy(value = Strategy.class)
public class Whatsapp extends SaveContext implements Strategy {

    public Whatsapp() {
        setSavePath("whatsapp");
        setIdentifier("whatsapp");
    }
}
