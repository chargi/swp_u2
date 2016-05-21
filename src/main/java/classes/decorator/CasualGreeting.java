package classes.decorator;

import interfaces.Formatter;

/**
 * Created by Chargi on 3.5.2016.
 */
@com.github.fhtw.swp.tutorium.decorator.Decorator(value = Formatter.class)
public class CasualGreeting extends TextFormatter implements Formatter {
    public CasualGreeting(String a, String b) {
        super(a,b);
        setIdentifier("casual-greeting");
    }
    public CasualGreeting(TextFormatter decorator) {
        super(decorator);
        setIdentifier("casual-greeting");
    }

    public CasualGreeting() {
        super();
        setIdentifier("casual-greeting");
    }

    public void decorate() {
        setText("Hallo "+getName()+", \n"+getText());
    }
}
