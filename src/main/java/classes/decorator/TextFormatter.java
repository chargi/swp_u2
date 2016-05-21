package classes.decorator;


import com.github.fhtw.swp.tutorium.decorator.Component;
import interfaces.Formatter;

/**
 * Created by Chargi on 3.5.2016.
 */
public class TextFormatter implements Formatter {
    private String identifier = "";

    @Component
    private Formatter base;

    public TextFormatter(String name, String text) {
        base = new TextStorage(name, text);
    }

    public TextFormatter(TextFormatter decorator) {
        base = new TextStorage(decorator);
    }

    public TextFormatter() {

    }

    public void decorate() {

    }

    public String getName() {
        return base.getName();
    }

    public void setName(String name) {
        base.setName(name);
    }

    public String getText() {
        return base.getText();
    }

    public void setText(String text) {
        base.setText(text);
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean canHandle(String identifier) {
        if (identifier.equals(this.identifier))
            return true;
        return false;
    }

    public void setBase(Formatter base) {
        this.base = base;
    }
}

