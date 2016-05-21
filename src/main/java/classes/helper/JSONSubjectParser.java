package classes.helper;

import classes.composite.AliasBook;
import classes.composite.User;
import interfaces.Alias;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Created by Chargi on 21.5.2016.
 */
public class JSONSubjectParser {
    JSONParser parser = new JSONParser();
    List<String> allowedSubscriber = new ArrayList<>();
    AliasBook root = new AliasBook("root");
    String file = "";
    Boolean validConfig = true;

    public void convert() throws Exception {
        try {

            Object obj = parser.parse(new FileReader(file));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray subscribers = (JSONArray) jsonObject.get("subscribers");
            System.out.println(subscribers);

            JSONArray aliases = (JSONArray) jsonObject.get("alias");
            System.out.println(aliases);

            //add subscribers to subjects
            for (Object s : subscribers) {
                root.addAlias(new User((String)s));
                allowedSubscriber.add((String)s);
            }

            for (Object a : aliases) {
                JSONObject allowedAliasObject = (JSONObject)a;
                String allowedAliasName = (String) jsonObject.get("name");
                AliasBook ab = new AliasBook(allowedAliasName);
                allowedSubscriber.add(allowedAliasName);

                JSONArray aliasNames = (JSONArray) jsonObject.get("for");
                for (Object n : aliasNames) {
                    JSONObject aliasNameObject = (JSONObject)n;
                    String aliasName = (String)aliasNameObject.toString();

                    if (!allowedSubscriber.contains(aliasName)) {
                        validConfig = false;
                        throw new Exception("JSON File contains invalid aliases");
                    }

                    ab.addAlias(new User(aliasName));

                }
                root.addAlias(ab);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public AliasBook getRoot() {
        return root;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
