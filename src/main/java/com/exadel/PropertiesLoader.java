package com.exadel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static com.exadel.MainClass.log;

public class PropertiesLoader {

    public Properties loadProperties(String pathToProperties) {
        InputStream fis = null;
        try {
            fis = new FileInputStream(pathToProperties);
        } catch (FileNotFoundException e) {
            log.error("File " + pathToProperties + " not found.");
        }
        Properties properties = new Properties();
        try {
            properties.load(fis);
        } catch (IOException e) {
            log.error("Error when load properties file.");
        }
        if (fis != null){
            try {
                fis.close();
            } catch (IOException e){
                log.error("Error when try close input stream (properties).");
            }
        }
        log.info("Properties received.");
        return properties;
    }
}
