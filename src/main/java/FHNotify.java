import classes.composite.AliasBook;
import classes.decorator.*;
import classes.helper.JSONSubjectParser;
import classes.strategy.Email;
import classes.strategy.Telegram;
import classes.strategy.Whatsapp;
import interfaces.Formatter;
import interfaces.Strategy;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public class FHNotify {
    public static void main(String[] args) throws Exception {
        System.out.println("--Starting FHNotify--\n");

        //Set arguments
        String configPath;
        String messagePath;
        List<String> formatIdentifiers = new ArrayList<>();
        String strategy;

        //Mockup args
        String[] mockArgs = {"--config", "c:\\java\\swp_u2\\config.json", "--message", "c:\\java\\test.txt", "--format", "casual-greeting,formal-greeting,christmas", "--transport", "whatsapp" };

        OptionParser parser = new OptionParser();
        parser.accepts("config", "Declare config file").withOptionalArg().ofType(String.class);
        parser.accepts("message", "Declare message file").withRequiredArg().ofType(String.class);
        parser.accepts("format", "Set text formatters").withOptionalArg();
        parser.accepts("transport", "Declare way of transport").withRequiredArg().ofType(String.class);
        OptionSet options = parser.parse(mockArgs);
        String configJSON = (String) options.valueOf("config");
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


        //TODO: Replace MockCode with JSON Reader
        JSONSubjectParser jsp = new JSONSubjectParser();
        jsp.setFile(configJSON);
        jsp.convert();
        AliasBook root = jsp.getRoot();

        //String[] an Empfängern aus ArgParser
        //for Schleife > an root geben > funktion gibt Liste an echten Subscribern zurück
        //Sollte root Subscriber/Alias nicht kennen, beendet er: THROW HOLLADARO
        //Ergebnis an distribution Liste anhängen

        List<String> distribution = new ArrayList<String>();
        distribution.add("Alexa Hundert");
        distribution.add("Max Test");
        distribution.add("Berni Blume");

        /* Message einlesen
        * Nur Text einlesen
        * arg: --message path
        */

        String message = "";
        File fpMessage = new File(configMessage);
        if (fpMessage.canRead()) {
            FileReader fr = new FileReader(fpMessage);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                message += br.readLine()+System.lineSeparator();
            }
        }
        else {
            throw new Exception("Message File cannot be read/not found");
        }



        //Generate list of strategies and choose according strategy
        Strategy chosenStrategy = null;
        List<Strategy> listOfStrategies = new ArrayList<>();
        listOfStrategies.add(new Email());
        listOfStrategies.add(new Telegram());
        listOfStrategies.add(new Whatsapp());

        for (Strategy s : listOfStrategies) {
            if (s.canHandle(configTransport))
                chosenStrategy = s;
        }
        if (chosenStrategy == null) {
            throw new Exception("No strategy given");
        }


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
        List<Formatter> formatters = new ArrayList<>();
        formatters.add(new CasualGreeting());
        formatters.add(new FormalGreeting());
        formatters.add(new CasualSignature());
        formatters.add(new PromotionSignature());
        formatters.add(new ChristmasSignature());

        //Iterate through the whole process for each user/subject
        for (String name : distribution) {
            Formatter formatter = new TextFormatter(name, message);
            //Decorate message with all given formatters
            for (String identifier : configFormats) {
                //Iterate through available formatters and act if the right one was found
                for (Formatter d : formatters) {
                    if (d.canHandle(identifier)) {
                        Formatter old = formatter;
                        formatter = d;
                        formatter.setBase(old);
                        formatter.decorate();
                        break;
                    }
                }

                //Message is completely decorated

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

                chosenStrategy.setMessage(formatter.getText());
                chosenStrategy.setUser(name);
                chosenStrategy.saveMessage();
            }

        }


        System.out.println(System.getProperty("user.dir"));
    }
}
