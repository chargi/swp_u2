package classes.strategy;

import interfaces.Strategy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Chargi on 3.5.2016.
 */
public abstract class SaveContext implements Strategy {
    private String message;
    private String savePath;
    private String user;
    private String identifier;

    public void setMessage(String arg0) {
        message = arg0;
    }

    public void setUser(String arg0) {
        user = arg0;
    }

    protected void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    protected String getMessage() {
        return message;
    }

    protected String getSavePath() {
        return savePath;
    }

    protected String getUser() {
        return user;
    }

    protected void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    private String getIdentifier() {
        return identifier;
    }

    //Implemented saveMessage in SaveContext, because every strategy uses the same writing mechanism
    public void saveMessage() {
        String wd = System.getProperty("user.dir");
        String dirPath = wd+"\\"+getSavePath();
        String completePath = wd+"\\"+getSavePath()+"\\"+getUser();
        File toDir = new File(dirPath);
        File toSave = new File(completePath);
        if (!toDir.exists()) {
            toDir.mkdir();
        }

        if (!toSave.exists()) {
            try {
                toSave.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (toSave.canWrite()) {
            try {
                FileWriter fw = new FileWriter(toSave);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(getMessage());
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                throw new Exception("Couldn't write message to output directory");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean canHandle(String identifier) {
        if (getIdentifier().equals(identifier))
            return true;
        return false;
    }
}
