package classes.decorator;

import interfaces.Formatter;

/**
 * Created by Chargi on 3.5.2016.
 */
@com.github.fhtw.swp.tutorium.decorator.Decorator(value = Formatter.class)
public class CasualSignature extends TextFormatter implements Formatter {
    public CasualSignature(String a, String b) {
        super(a,b);
        setIdentifier("casual-signature");
    }
    public CasualSignature(TextFormatter decorator) {
        super(decorator);
        setIdentifier("casual-signature");
    }

    public CasualSignature() {
        super();
        setIdentifier("casual-signature");
    }

    public void decorate() {
        setText(getText()+"\nViele Grüße,\ndie FH-Leitung");
    }
}
