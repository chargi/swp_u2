package interfaces;

import com.github.fhtw.swp.tutorium.composite.ComponentOperation;

/**
 * Created by Chargi on 3.5.2016.
 */

public interface Formatter {
    @ComponentOperation
    public void decorate();
    public String getName();
    public void setName(String name);
    public String getText();
    public void setText(String text);
    public boolean canHandle(String identifier);
    public void setBase(Formatter base);
}
