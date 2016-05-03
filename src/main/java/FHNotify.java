import classes.composite.AliasBook;
import classes.composite.User;
import classes.decorator.CasualGreeting;
import classes.decorator.CasualSignature;
import classes.decorator.ChristmasSignature;
import classes.decorator.TextDecorator;
import interfaces.Alias;
import interfaces.MessageText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chargi on 3.5.2016.
 */
public class FHNotify {
    public static void main(String[] args) {
        System.out.println("Hello the World!");

        /* COMPOSITION
        * Config File einlesen
        * Gültig: weiter
        * Ungültig: abbrechen
        * arg: [--config path]
        */

        //Insert code here

        //MockCode
        AliasBook bif14 = new AliasBook("BIF14");
        bif14.addAlias(new User("Alexa Hundertwasser"));

        List<Alias> mockAlias = new ArrayList<Alias>(
                Arrays.asList(
                        new User("Max Test"),
                        bif14
                )
            );

        /* Message einlesen
        * Nur Text einlesen
        * arg: --message path
        */

        //Insert code here

        //MockCode
        String message = "Ich bin eine Mockup-Message";

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

        TextDecorator first = new CasualGreeting(mockAlias);
        TextDecorator second = new CasualSignature(first);
        TextDecorator third = new ChristmasSignature(second);

        for (Alias a : third.getAliasesWithText()) {
            //System.out.println(a.getMessage());
            System.out.println(a.getName());
        }


        /* STRATEGY
        * Definiere Transportweg
        * --transport option
        * options: whatsapp
        *          telegram
        *          email
        */

        //Insert code here

        /* Save Messages to File
        * recipient1,recipient2,recipient3,...,recipientN
        * check if recipients are validated
        * if not, non-existent users "don't get a message"
        * else save message to
        * path: transportweg\recipient
        *   e.g.: whatsapp\if14b001
        */


    }
}
