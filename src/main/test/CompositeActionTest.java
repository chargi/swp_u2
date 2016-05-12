import classes.composite.AliasFactory;
import classes.composite.User;
import interfaces.Alias;

/**
 * Created by chargi on 12.05.2016.
 */
public class CompositeActionTest {
    @org.junit.Test
    public void testName() throws Exception {
        Alias testFactory = (Alias) new AliasFactory().getInstance();
    }
}
