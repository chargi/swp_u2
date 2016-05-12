package classes.decorator;

import com.github.fhtw.swp.tutorium.decorator.Decorator;
import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
@Decorator(value = MessageText.class)
public class CasualGreeting extends TextDecorator implements MessageText {
    public CasualGreeting(String a, String b) {
        super(a,b);
    }
    public CasualGreeting(TextDecorator decorator) {
        super(decorator);
    }

    public void decorate() {
        setText("Hallo "+getName()+", \n"+getText());
    }
}
