package xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ReadXMLFileSax {
    public static Object readXML(String xmlFile) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            MySaxHandler handler = new MySaxHandler();

            saxParser.parse(xmlFile, handler);

            return handler.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
