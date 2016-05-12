package classes.decorator;


import com.github.fhtw.swp.tutorium.decorator.Component;
import com.github.fhtw.swp.tutorium.decorator.Decorator;
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
    @Component
    private MessageText baseText;

    public TextDecorator(String name, String text) {
        baseText = new TextStorage(name, text);
    }

    public TextDecorator(TextDecorator decorator) {
        baseText = new TextStorage(decorator);
    }

    public void decorate() {

    }

    public String getName() {
        return baseText.getName();
    }

    public void setName(String name) {
        baseText.setName(name);
    }

    public String getText() {
        return baseText.getText();
    }

    public void setText(String text) {
        baseText.setText(text);
    }
}

