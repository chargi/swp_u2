package classes.composite;

import com.github.fhtw.swp.tutorium.Factory;
import interfaces.Alias;

import java.util.ArrayList;

/**
 * Created by Chargi on 11/05/16.
 */
public class AliasFactory implements Factory {
    @Override
    public Object getInstance() {
        final Alias bifgrp1 = new AliasBook("a1", new ArrayList<Alias>()
        {{
            add(new User("if14b011"));
            add(new User("if14b033"));
        }});

        return new AliasBook("bif4", new ArrayList<Alias>()
        {{
            add(new User("if14b003"));
            add(new User("if14b006"));
            add(0,bifgrp1);
        }});
    }
}