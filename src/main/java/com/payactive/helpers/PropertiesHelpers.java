package com.payactive.helpers;

import com.payactive.constants.ConstantGlobal;
import com.payactive.utils.LogUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

import static com.payactive.constants.ConstantGlobal.APP_ENV;
import static com.payactive.constants.ConstantGlobal.ENVIRONMENT_CONFIG;

public class PropertiesHelpers {

    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;
    private static FileOutputStream out;
    private static final String relPropertiesFilePathDefault = ConstantGlobal.APPLICATION_PROPERTIES;

    public static Properties loadAllFiles() {
        String environmentConfig = System.getProperty(ENVIRONMENT_CONFIG, ConstantGlobal.DEFAULT_ENVIRONMENT_PROPERTIES);

        LinkedList<String> files = new LinkedList<>();
        String applicationProperties = ConstantGlobal.APPLICATION_PROPERTIES;

        // Add all file properties to load
        files.add(applicationProperties);
        files.add(environmentConfig);

        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = SystemsHelpers.getCurrentDir() + f;
                file = new FileInputStream(linkFile);
                tempProp.load(file);
                properties.putAll(tempProp);
            }
            LogUtils.debug("Load all file properties successfully.");
            return properties;
        } catch (IOException ioe) {
            LogUtils.error("Cannot load file properties.");
            return new Properties();
        }
    }

    public static void setFile(String relPropertiesFilePath) {
        properties = new Properties();
        try {
            linkFile = SystemsHelpers.getCurrentDir() + relPropertiesFilePath;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDefaultFile() {
        properties = new Properties();
        try {
            linkFile = SystemsHelpers.getCurrentDir() + relPropertiesFilePathDefault;

            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String value = null;
        try {
            if (file == null) {
                properties = new Properties();
                linkFile = SystemsHelpers.getCurrentDir() + relPropertiesFilePathDefault;
                file = new FileInputStream(linkFile);
                properties.load(file);
                file.close();
            }
            // Get value from properties file
            value = properties.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return value;
    }

    public static void setValue(String key, String value) {
        try {
            if (file == null) {
                properties = new Properties();
                file = new FileInputStream(SystemsHelpers.getCurrentDir() + relPropertiesFilePathDefault);
                properties.load(file);
                file.close();
                out = new FileOutputStream(SystemsHelpers.getCurrentDir() + relPropertiesFilePathDefault);
            }
            // Set value to properties file
            out = new FileOutputStream(linkFile);
            System.out.println(linkFile);
            properties.setProperty(key, value);
            properties.store(out, null);
            out.close();
            System.out.println("Set " + key + " = " + value + " to properties file successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
