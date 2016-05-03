package classes.strategy;

import com.github.fhtw.swp.tutorium.Factory;

/**
 * Created by chargi on 03.05.2016.
 */
public class TelegramFactory implements Factory {
    @Override
    public Object getInstance() {
        return new Telegram();
    }
}
