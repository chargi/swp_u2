package classes.helper;

import classes.composite.AliasBook;
import classes.composite.User;
import interfaces.Alias;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
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
    List<String> allowedAlias = new ArrayList<>();
    AliasBook root = new AliasBook("root");
    String file = HomeDirTranslator.replaceTilde("~/.fh-notify/config.json");
    Boolean validConfig = true;

    public void convert() throws Exception {
        if (!isFileEmpty())
            try {

                Object obj = parser.parse(new FileReader(file));

                JSONObject jsonObject = (JSONObject) obj;

                JSONArray subscribers = (JSONArray) jsonObject.get("subscribers");

                JSONArray aliases = (JSONArray) jsonObject.get("alias");

                //add subscribers to subjects
                for (Object s : subscribers) {
                    root.addAlias(new User((String)s));
                    allowedSubscriber.add((String)s);
                }

                for (Object a : aliases) {
                    JSONObject allowedAliasObject = (JSONObject)a;
                    String allowedAliasName = (String) allowedAliasObject.get("name");
                    AliasBook ab = new AliasBook(allowedAliasName);
                    allowedAlias.add(allowedAliasName);

                    JSONArray aliasNames = (JSONArray) allowedAliasObject.get("for");
                    for (Object n : aliasNames) {
                        //JSONObject aliasNameObject = (JSONObject)n;
                        String aliasName = (String)n;

                        if (!(allowedSubscriber.contains(aliasName) || allowedAlias.contains(aliasName))) {
                            validConfig = false;
                            throw new Exception("JSON File contains invalid aliases");
                        }

                        if (allowedSubscriber.contains(aliasName))
                            ab.addAlias(new User(aliasName));

                        if (allowedAlias.contains(aliasName))
                            ab.addAlias(root.getAlias(aliasName));
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

    private boolean isFileEmpty() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        if (br.readLine() == null)
            return true;
        return false;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
