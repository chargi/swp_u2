package classes.decorator;

import com.github.fhtw.swp.tutorium.decorator.Component;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import interfaces.MessageText;

/**
 * Created by chargi on 12.05.2016.
 */
public class TextStorage implements MessageText {
    private String name;
    private String text;

    public TextStorage(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public TextStorage(TextDecorator decorator) {
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
    public void decorate() {

    }
}
