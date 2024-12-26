package com.payactive.constants;

import com.payactive.helpers.PropertiesHelpers;

public class ConstantGlobal {
    static {
        PropertiesHelpers.loadAllFiles();
    }

    public final static String BROWSER = PropertiesHelpers.getValue("app.browser");
    public final static String APP_ENV = PropertiesHelpers.getValue("app.env");
    public final static boolean HEADLESS = Boolean.parseBoolean(PropertiesHelpers.getValue("headless"));
    public final static String URL = PropertiesHelpers.getValue("login.url");
    public final static String TEST_DATA = PropertiesHelpers.getValue("data.test");

    public final static long STEP_TIME = Long.parseLong(PropertiesHelpers.getValue("STEP_TIME"));
    public final static long EXPLICIT_TIMEOUT = Long.parseLong(PropertiesHelpers.getValue("EXPLICIT_TIMEOUT"));
    public final static long PAGE_LOAD_TIMEOUT = Long.parseLong(PropertiesHelpers.getValue("PAGE_LOAD_TIMEOUT"));
    public final static String SCREENSHOT_FAIL = PropertiesHelpers.getValue("SCREENSHOT_FAIL");
    public final static String SCREENSHOT_PASS = PropertiesHelpers.getValue("SCREENSHOT_PASS");
    public final static String SCREENSHOT_STEP = PropertiesHelpers.getValue("SCREENSHOT_STEP");
    public final static String RECORD_VIDEO = PropertiesHelpers.getValue("RECORD_VIDEO");
    public final static String RECORD_VIDEO_PATH = PropertiesHelpers.getValue("RECORD_VIDEO_PATH");
    public final static String EXTENT_REPORT_PATH = PropertiesHelpers.getValue("EXTENT_REPORT_PATH");
    public final static String AUTHOR = PropertiesHelpers.getValue("AUTHOR");
    public final static String LOCATE = PropertiesHelpers.getValue("LOCATE");

    public final static String APPLICATION_PROPERTIES = "src/test/resources/application.properties";
    public final static String DEFAULT_ENVIRONMENT_PROPERTIES = "src/test/resources/environment.properties";
    public final static String ENVIRONMENT_CONFIG = "environment.config";



}
