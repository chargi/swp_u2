package classes.decorator;

import interfaces.Formatter;

/**
 * Created by Chargi on 3.5.2016.
 */
@com.github.fhtw.swp.tutorium.decorator.Decorator(value = Formatter.class)
public class FormalGreeting extends TextFormatter implements Formatter {
    public FormalGreeting(String a, String b) {
        super(a,b);
        setIdentifier("formal-greeting");
    }
    public FormalGreeting(TextFormatter decorator) {
        super(decorator);
        setIdentifier("formal-greeting");
    }

    public FormalGreeting() {
        super();
        setIdentifier("formal-greeting");
    }

    public void decorate() {
        setText("Guten Tag "+getName()+", \n"+getText());
    }
}
