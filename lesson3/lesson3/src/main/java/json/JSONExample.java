package json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import serialization.SerializableObject;

public class JSONExample {
    private static final String jsonString = "{\"name\":\"Alexey\",\"age\":42}";

    public static void run() {
        Gson g = new Gson();

        SerializableObject gsonObject = g.fromJson(jsonString, SerializableObject.class);
        System.out.println(gsonObject);

        System.out.println(g.toJson(gsonObject));

        JsonObject jsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
        System.out.println(jsonObject.get("name").getAsString());
    }
}
