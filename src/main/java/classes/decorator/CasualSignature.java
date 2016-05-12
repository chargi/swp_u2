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
public class CasualSignature extends TextDecorator implements MessageText{
    public CasualSignature(String a, String b) {
        super(a,b);
    }
    public CasualSignature(TextDecorator decorator) {
        super(decorator);
    }

    public void decorate() {
        setText(getText()+"\nViele Grüße,\ndie FH-Leitung");
    }
}
