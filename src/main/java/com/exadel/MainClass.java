package com.exadel;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

public class MainClass {

    public static final Logger log = Logger.getLogger(MainClass.class);
    public static String pathToProperties = "./configuration.properties";

    public static void main(String[] args) throws Exception {
        Properties properties = new PropertiesLoader().loadProperties(pathToProperties);

        ExcelReader reader = new ExcelReader();
        List<CustomObject> list = reader.readSheetToList("autotest", properties.getProperty("pathToExcel"));

        JsonWriter writer = new JsonWriter();
        writer.writeListToJson(list, properties.getProperty("pathToResults"));
    }

}