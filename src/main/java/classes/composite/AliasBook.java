package classes.composite;

import com.github.fhtw.swp.tutorium.composite.AddComponent;
import com.github.fhtw.swp.tutorium.composite.ComponentOperation;
import com.github.fhtw.swp.tutorium.composite.Composite;
import interfaces.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
@Composite(value = Alias.class, factory = AliasFactory.class)
public class AliasBook implements Alias {
    private String name;
    private List<Alias> al;

    public AliasBook(String name) {
        al = new ArrayList<>();
        this.name = name;
    }

    public AliasBook(String name, List<Alias> aliases) {
        this.al = aliases;
        this.name = name;
    }

    @AddComponent
    public void addAlias(Alias a) {
        al.add(a);
    }

    public String getName() {
        return name;
    }

    @Override
    public List<Alias> convertToList() {
        List<Alias> allRecipients = new ArrayList<Alias>();

        for (Alias a : al) {
            allRecipients.addAll(a.convertToList());
        }

        return allRecipients;
    }
}
