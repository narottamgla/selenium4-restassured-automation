package com.ui.executiondata;

public class ExecutionConf {

    public static String EXECUTION_MODE= System.getProperty("executionMode", "local");
    public static String BROWSER= System.getProperty("browser", "firefox");

}
