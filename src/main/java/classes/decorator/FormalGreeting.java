package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public class FormalGreeting extends TextDecorator {
    public FormalGreeting(String a, String b) {
        super(a,b);
    }
    public FormalGreeting(TextDecorator decorator) {
        super(decorator);
    }

    public void decorate() {
        setText("Guten Tag "+getName()+", \n"+getText());
    }
}
