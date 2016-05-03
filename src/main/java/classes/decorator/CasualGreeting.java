package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;

/**
 * Created by Chargi on 3.5.2016.
 */
public class CasualGreeting extends TextDecorator {
    public CasualGreeting(ArrayList<Alias> a) {
        super(a);
    }

    public CasualGreeting(TextDecorator decorator) {
        super(decorator);
    }

    public void append() {
        appendGreeting("Casual Greeting Hallo XY");
    }
}
