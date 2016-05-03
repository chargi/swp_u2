package classes.composite;

import interfaces.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public class AliasBook implements Alias {
    private String name;
    private String message;
    private List<Alias> al = new ArrayList<>();

    public AliasBook(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String s) {
        message = s;
    }
}
