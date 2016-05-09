package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public class PromotionSignature extends TextDecorator {
    public PromotionSignature(String a, String b) {
        super(a,b);
    }
    public PromotionSignature(TextDecorator decorator) {
        super(decorator);
    }

    public void decorate() {
        setText("\nVersendet mit fh-notify.");
    }
}
