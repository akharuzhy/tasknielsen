package com.exadel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static com.exadel.MainClass.log;

public class PropertiesLoader {

    public Properties loadProperties(String pathToProperties) {
        InputStream fis = PropertiesLoader.class.getClassLoader().getResourceAsStream(pathToProperties);
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
