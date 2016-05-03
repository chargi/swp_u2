package classes.strategy;

import com.github.fhtw.swp.tutorium.command.Invoker;
import interfaces.Strategy;

/**
 * Created by Chargi on 3.5.2016.
 */
@Invoker(factory = TelegramFactory.class)
public class Telegram implements Strategy {
}
