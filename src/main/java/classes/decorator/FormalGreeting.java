package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;

/**
 * Created by Chargi on 3.5.2016.
 */
public class FormalGreeting extends TextDecorator {
    public FormalGreeting(ArrayList<Alias> a) {
        super(a);
    }

    public FormalGreeting(TextDecorator decorator) {
        super(decorator);
    }

    public void append() {
        appendGreeting("Guten Tag "+placeholder+"\n");
    }
}
