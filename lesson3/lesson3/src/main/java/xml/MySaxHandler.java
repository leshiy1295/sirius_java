package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import serialization.ReflectionHelper;

public class MySaxHandler extends DefaultHandler {
    private static final String CLASSNAME = "class";

    private String element = null;
    private Object object = null;

    public void startDocument() {
        System.out.println("startDocument");
    }

    public void endDocument() {
        System.out.println("endDocument");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println("startElement " + qName);
        if (!qName.equals(CLASSNAME)) {
            element = qName;
        } else {
            String className = attributes.getValue(0);
            System.out.println("Class name " + className);
            object = ReflectionHelper.createInstance(className);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element " + qName);
        element = null;
    }

    public void characters(char ch[], int start, int length) throws SAXException {
        if (element != null) {
            String value = new String(ch, start, length);
            System.out.println(element + " = " + value);
            ReflectionHelper.setFieldValue(object, element, value);
        }
    }

    public Object getObject() {
        return object;
    }
}
