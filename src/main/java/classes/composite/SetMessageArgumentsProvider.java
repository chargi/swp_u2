package classes.composite;

import com.github.fhtw.swp.tutorium.ArgumentsProvider;

/**
 * Created by chargi on 03.05.2016.
 */
public class SetMessageArgumentsProvider implements ArgumentsProvider {
    @Override
    public Object[] getArguments() {
        return new Object[] { "Hello" };
    }
}
