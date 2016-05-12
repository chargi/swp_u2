package interfaces;

import classes.composite.SetMessageArgumentsProvider;
import classes.decorator.CasualGreeting;
import com.github.fhtw.swp.tutorium.command.Invoker;
import com.github.fhtw.swp.tutorium.composite.ComponentOperation;
import com.github.fhtw.swp.tutorium.decorator.Component;
import com.github.fhtw.swp.tutorium.decorator.Decorator;

/**
 * Created by Chargi on 3.5.2016.
 */

public interface MessageText {
    @ComponentOperation
    public void decorate();
    public String getName();
    public void setName(String name);
    public String getText();
    public void setText(String text);
}
