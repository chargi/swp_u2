package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public class CasualSignature extends TextDecorator {
    public CasualSignature(String a, String b) {
        super(a,b);
    }
    public CasualSignature(TextDecorator decorator) {
        super(decorator);
    }

    public void decorate() {
        setText("\nViele Grüße,\ndie FH-Leitung");
    }
}
