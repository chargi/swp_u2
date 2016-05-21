package classes.decorator;

import interfaces.Formatter;

/**
 * Created by chargi on 12.05.2016.
 */
public class TextStorage implements Formatter {
    private String name;
    private String text;

    public TextStorage(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public TextStorage(TextFormatter decorator) {
        setName(decorator.getName());
        setText(decorator.getText());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean canHandle(String identifier) {
        return false;
    }

    @Override
    public void setBase(Formatter base) {

    }

    @Override
    public void decorate() {

    }
}
