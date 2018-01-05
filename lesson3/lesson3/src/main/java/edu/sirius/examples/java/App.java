package edu.sirius.examples.java;

import codegen.CodeGenerationExample;
import exceptions.ExceptionExample;
import json.JSONExample;
import serialization.SerializationExample;
import streams.StreamExample;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ExceptionExample.run();
        StreamExample.run();
        SerializationExample.run();
        CodeGenerationExample.run();
        JSONExample.run();
    }
}
