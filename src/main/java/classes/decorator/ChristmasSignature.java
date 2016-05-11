package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public class ChristmasSignature extends TextDecorator {
    public ChristmasSignature(String a, String b) {
        super(a,b);
    }
    public ChristmasSignature(TextDecorator decorator) {
        super(decorator);
    }

    public void decorate() {
        setText(getText()+"\nFrohe Weihnachten wünscht,\ndie FH-Leitung");
    }
}
