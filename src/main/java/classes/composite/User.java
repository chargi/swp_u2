package classes.composite;

import interfaces.Alias;

/**
 * Created by Chargi on 3.5.2016.
 */
public class User implements Alias {
    private String name;
    private String message;

    public User(String name) {
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
