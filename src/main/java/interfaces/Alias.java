package interfaces;

import com.github.fhtw.swp.tutorium.composite.ComponentOperation;

import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public interface Alias {
    @ComponentOperation
    List<Alias> getAliasUsers(String filter);
    String getName();
}
