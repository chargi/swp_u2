package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;

/**
 * Created by Chargi on 3.5.2016.
 */
public class CasualSignature extends TextDecorator {
    public CasualSignature(ArrayList<Alias> a) {
        super(a);
    }

    public CasualSignature(TextDecorator decorator) {
        super(decorator);
    }

    public void append() {
        appendSignature("\nViele Grüße,\ndie FH-Leitung");
    }
}
