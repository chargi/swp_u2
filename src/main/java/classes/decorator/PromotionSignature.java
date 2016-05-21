package classes.decorator;

import interfaces.Formatter;

/**
 * Created by Chargi on 3.5.2016.
 */
@com.github.fhtw.swp.tutorium.decorator.Decorator(value = Formatter.class)
public class PromotionSignature extends TextFormatter implements Formatter {
    public PromotionSignature(String a, String b) {
        super(a,b);
        setIdentifier("promotion");
    }
    public PromotionSignature(TextFormatter decorator) {
        super(decorator);
        setIdentifier("promotion");
    }

    public PromotionSignature() {
        super();
        setIdentifier("promotion");
    }

    public void decorate() {
        setText(getText()+"\nVersendet mit fh-notify.");
    }
}
