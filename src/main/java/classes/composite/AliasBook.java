package classes.composite;

import com.github.fhtw.swp.tutorium.composite.AddComponent;
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

    public boolean isValidAlias(String alias) {
        if (getAliasUsers(alias) != null)
            return true;
        return false;
    }

    @Override
    public List<Alias> getAliasUsers(String filter) {
        List<Alias> recipients = new ArrayList<Alias>();

        for (Alias a : al) {
            if (a.getName().equals(filter))
                recipients.addAll(a.getAliasUsers(filter));
        }

        return recipients;
    }
}
