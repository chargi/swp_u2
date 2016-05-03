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
    protected List<Alias> aliasesWithText = new ArrayList<Alias>();
    protected final String placeholder = "###XYNAME###";


    public TextDecorator(ArrayList<Alias> a) {
        aliasesWithText = a;
    }

    public TextDecorator(TextDecorator decorator) {
        aliasesWithText = decorator.getAliasesWithText();
    }

    public void append() {

    }

    public void appendGreeting(String appendText) {
        for (Alias a : aliasesWithText) {
            String mt = a.getMessage();
            String name = a.getName();
            String at = appendText;

            at.replace(placeholder,name);
            a.setMessage(at+mt);
        }
    }

    public void appendSignature(String appendText) {
        for (Alias a : aliasesWithText) {
            String mt = a.getMessage();
            String at = appendText;

            a.setMessage(mt+at);
        }
    }

    public List<Alias> getAliasesWithText() {
        return aliasesWithText;
    }

    public void setAliasesWithText(List<Alias> aliasesWithText) {
        this.aliasesWithText = aliasesWithText;
    }
}
