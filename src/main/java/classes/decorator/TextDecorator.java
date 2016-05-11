package classes.decorator;


import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chargi on 3.5.2016.
 */


public abstract class TextDecorator implements MessageText {
    private String name;
    private String text;

    public TextDecorator(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public TextDecorator(TextDecorator decorator) {
        setName(decorator.getName());
        setText(decorator.getText());
    }

    public void decorate() {

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
}

