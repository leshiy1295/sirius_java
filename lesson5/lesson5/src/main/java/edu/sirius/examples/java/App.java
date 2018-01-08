package edu.sirius.examples.java;

import annotations.AnnotationsExample;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        PropertyConfigurator.configure("log4j.properties");
        Logger.getLogger("main").debug("main started");
        AnnotationsExample.run();
    }
}
