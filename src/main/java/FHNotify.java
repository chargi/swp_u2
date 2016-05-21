import classes.composite.AliasBook;
import classes.composite.User;
import classes.decorator.CasualGreeting;
import classes.decorator.CasualSignature;
import classes.decorator.ChristmasSignature;
import classes.decorator.TextDecorator;
import classes.strategy.Whatsapp;
import interfaces.Alias;
import interfaces.MessageText;
import interfaces.Strategy;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public class FHNotify {
    public static void main(String[] args) {
        System.out.println("--Starting FHNotify--\n");

        //Set arguments
        String configPath;
        String messagePath;
        List<String> formatIdentifiers = new ArrayList<>();
        String strategy;

        //Mockup args
        String[] mockArgs = {"--config", "~/test.json", "--message", "test.txt", "--format", "casual-greeting,formal-greeting,christmas", "--transport", "whatsapp" };

        //TODO: OptionParser
        OptionParser parser = new OptionParser();
        parser.accepts("config", "Declare config file").withOptionalArg().ofType(String.class);
        parser.accepts("message", "Declare message file").withRequiredArg().ofType(String.class);
        parser.accepts("format", "Set text formatters").withOptionalArg();
        parser.accepts("transport", "Declare way of transport").withRequiredArg().ofType(String.class);
        OptionSet options = parser.parse(mockArgs);
        String configOption = (String) options.valueOf("config");
        String configMessage = (String) options.valueOf("message");
        String configFormat = (String) options.valueOf("format");
        String configTransport = (String) options.valueOf("transport");
        String[] configFormats = configFormat.split(",");


        /* COMPOSITION
        * Config File einlesen
        * Gültig: weiter
        * Ungültig: abbrechen
        * arg: [--config path]
        */

        //Insert code here

        //MockCode
        List<String> distribution = new ArrayList<String>();
        distribution.add("Alexa Hundert");
        distribution.add("Max Test");
        distribution.add("Berni Blume");

        /* Message einlesen
        * Nur Text einlesen
        * arg: --message path
        */

        //Insert code here
        String message = "Blabla";
        Strategy chosenStrategy = new Whatsapp();

        //For each subject in distribution, decorate the message and act according to the chosen strategy
        for (String subject : distribution) {

        /* DECORATOR
        * Formattiere die Message
        * arg: --format option1,option2,option3,...,optionN
        * possible formats, comma seperated:
        *    casual-greeting
        *    formal-greeting
        *    casual-signature
        *    promotion
        *    christmas
        */

            for (String name : distribution) {
                TextDecorator first = new CasualGreeting(name, message);
                first.decorate();
                TextDecorator second = new CasualSignature(first);
                second.decorate();
                TextDecorator third = new ChristmasSignature(second);
                third.decorate();
                System.out.println(third.getText());
            }


        /* STRATEGY
        * Definiere Transportweg
        * --transport option
        * options: whatsapp
        *          telegram
        *          email
        */

        /* Save Messages to File
        * recipient1,recipient2,recipient3,...,recipientN
        * check if recipients are validated
        * if not, non-existent users "don't get a message"
        * else save message to
        * path: transportweg\recipient
        *   e.g.: whatsapp\if14b001
        */

            chosenStrategy.setMessage(message);
            chosenStrategy.setUser(subject);
            chosenStrategy.saveMessage();



        }


    }
}
