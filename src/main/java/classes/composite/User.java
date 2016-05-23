package classes.composite;

import com.github.fhtw.swp.tutorium.composite.ComponentOperation;
import com.github.fhtw.swp.tutorium.composite.Leaf;
import interfaces.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
@Leaf(value = Alias.class)
public class User implements Alias {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public List<Alias> getAliasUsers(String filter) {
        List<Alias> temp = new ArrayList<>();
        if (getName().equals(filter))
            temp.add(this);
        return temp;
    }
}
