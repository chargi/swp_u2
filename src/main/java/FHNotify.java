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

        /* Message einlesen
        * Nur Text einlesen
        * arg: --message path
        */

        //Insert code here

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

        //Insert code here


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
