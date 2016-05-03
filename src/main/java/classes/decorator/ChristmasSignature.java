package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;

/**
 * Created by Chargi on 3.5.2016.
 */
public class ChristmasSignature extends TextDecorator {
    public ChristmasSignature(ArrayList<Alias> a) {
        super(a);
    }

    public ChristmasSignature(TextDecorator decorator) {
        super(decorator);
    }

    public void append() {
        appendSignature("\nFrohe Weihnachten wünscht,\ndie FH-Leitung");
    }
}
