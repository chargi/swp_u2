package classes.decorator;

import interfaces.Formatter;

/**
 * Created by Chargi on 3.5.2016.
 */
@com.github.fhtw.swp.tutorium.decorator.Decorator(value = Formatter.class)
public class ChristmasSignature extends TextFormatter implements Formatter {
    public ChristmasSignature(String a, String b) {
        super(a,b);
        setIdentifier("christmas");
    }
    public ChristmasSignature(TextFormatter decorator) {
        super(decorator);
        setIdentifier("christmas");
    }

    public ChristmasSignature() {
        super();
        setIdentifier("christmas");
    }

    public void decorate() {
        setText(getText()+"\nFrohe Weihnachten wünscht,\ndie FH-Leitung");
    }
}
