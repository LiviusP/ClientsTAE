package clients;

import java.util.Map;
import java.util.Set;

/**
 * Created by Livius on 5/27/2017.
 */
public class Utils {

    public static String createJsonString(Map<String, Object> map) {
        String jsonString = "{ ";
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {

            jsonString = jsonString + "\"" + entry.getKey() + "\"";
            jsonString += " : ";
            jsonString = jsonString + getJsonValue(entry.getValue());
            jsonString += ",  ";
        }
        int i = jsonString.lastIndexOf(",");
        jsonString = jsonString.substring(0, i);
        jsonString += " }";
        return jsonString;
    }

    public static String getJsonValue(Object value) {
        if (value == null) {
            return "";
        } else if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        } else {
            return "\"" + value + "\"";
        }
    }
}