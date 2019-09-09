package com.exadel;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static com.exadel.MainClass.log;

public class JsonWriter {

    public void writeListToJson(List list, String pathJson) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        File file = new File(pathJson);
        if (file.exists())
            file.delete();
        try {
            file.createNewFile();
        } catch (IOException e) {
            log.error("Error when try to create new file.");
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            log.error("File " + pathJson + " not found.");
        }
        try {
            fos.write(json.getBytes());
        } catch (IOException e) {
            log.error("Error when write to '" + pathJson + "' file.");
        }

        if (fos != null){
            try {
                fos.close();
            } catch (IOException e) {
                log.error("Error when close output stream.");
            }
        }
        log.info("JSON " + pathJson + " recorded.");
    }

}
