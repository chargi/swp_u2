package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public class FormalGreeting extends TextDecorator {
    public FormalGreeting(List<Alias> a) {
        super(a);
    }

    public FormalGreeting(TextDecorator decorator) {
        super(decorator);
    }

    public void append() {
        appendGreeting("Guten Tag "+placeholder+"\n");
    }
}
