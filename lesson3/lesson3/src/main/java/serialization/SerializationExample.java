package serialization;

import streams.StreamExample;
import xml.ReadXMLFileSax;

import java.io.ObjectStreamClass;

public class SerializationExample {
    public static void run() {
        SerializableObject serializedObject = new SerializableObject("Alexey", 42);
        System.out.println(ObjectStreamClass.lookup(serializedObject.getClass()).getSerialVersionUID());
        StreamExample.write(serializedObject, "./object.sav");
        SerializableObject object = (SerializableObject)StreamExample.read("./object.sav");
        System.out.println(object);

        SerializableObject reflectedObject = (SerializableObject)ReflectionHelper.createInstance("serialization.SerializableObject");
        System.out.println(reflectedObject);

        ReflectionHelper.setFieldValue(reflectedObject, "name", "Alexey");
        ReflectionHelper.setFieldValue(reflectedObject, "age", "42");
        System.out.println(reflectedObject);

        SerializableObject xmlObject = (SerializableObject) ReadXMLFileSax.readXML("./test.xml");
        System.out.println(xmlObject);
    }
}
