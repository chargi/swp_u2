package classes.decorator;

import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;

/**
 * Created by Chargi on 3.5.2016.
 */
public class PromotionSignature extends TextDecorator {
    public PromotionSignature(ArrayList<Alias> a) {
        super(a);
    }

    public PromotionSignature(TextDecorator decorator) {
        super(decorator);
    }

    public void append() {
        appendSignature("\nVersendet mit fh-notify.");
    }
}
