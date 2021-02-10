package Helpers;

import io.restassured.path.json.JsonPath;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Json_Helpers {

    public static JsonArray stringToJSONArray(String inputString) throws IOException {
        JsonReader jsonReader = Json.createReader(new StringReader(inputString));
        JsonArray jsonArray = jsonReader.readArray();
        jsonReader.close();

        return jsonArray;

    }

    public static JsonArray fileToJSONArray(String filePath) throws IOException {
        InputStream fileReader = new FileInputStream(filePath);
        String fileAsString = org.apache.commons.io.IOUtils.toString(fileReader, "UTF8");
        JsonReader jsonReader = Json.createReader(new StringReader(fileAsString));
        JsonArray jsonArray = jsonReader.readArray();
        jsonReader.close();
        return jsonArray;
    }


    public static String ReturnElementValue(String Elt_Id) {
        System.out.println("--------------------------------------");
        JsonPath jsonPath = new JsonPath(Elt_Id);
        System.out.println(jsonPath.getString(Elt_Id));
        System.out.println("--------------------------------------");
        return jsonPath.getString(Elt_Id);
    }

    public static JsonObject inputAsStreamToJSONObject(InputStream inputStream) throws IOException {
        try {
            String fileAsString = org.apache.commons.io.IOUtils.toString(inputStream);
            JsonReader jsonReader = Json.createReader(new StringReader(fileAsString));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();

            return jsonObject;
        } catch (Exception e) {
            return null;
        }
    }

    public static JsonObject stringToJSONObject(String inputString) {
        try {
            JsonReader jsonReader = Json.createReader(new StringReader(inputString));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();

            return jsonObject;
        } catch (Exception e) {
            return null;
        }
    }


    public static JsonObject fileToJSONObject(String filePath) throws IOException {
        InputStream fileReader = new FileInputStream(filePath);
        String fileAsString = org.apache.commons.io.IOUtils.toString(fileReader, "UTF8");
        JsonReader jsonReader = Json.createReader(new StringReader(fileAsString));
        JsonObject jsonObject = jsonReader.readObject();
        jsonReader.close();
        return jsonObject;
    }

    public static List<String> getLogElement_OLD(String logLine, String elementKey) {
        String[] ary = logLine.split(",");
        List<String> content = new ArrayList<String>();
        for (int i = 0; i < ary.length; i++) {
            String element = ary[i];
            //System.out.println("\n" +i+" - "+ary[i].trim());
            if (element.contains(elementKey)) {
                content.add(element);
            }
        }
        return content;
    }

    public static List<String> getLogElement(String logLine, String elementKey) {

        String[] ary = logLine.split(",");
        List<String> content = new ArrayList<String>();
        for (int i = 0; i < ary.length; i++) {
            String element = ary[i];
            //System.out.println("\n" +i+" - "+ary[i].trim());
            if (element.contains(elementKey)) {
                content.add(element);
            }
        }
        return content;
    }

    public static Object extractJSON(String str) {
        System.out.println("\n extractJSON");
        int firstOpen = 0, firstClose = 0;
        String candidate;
        firstOpen = str.indexOf("{", firstOpen + 1);
        do {
            firstClose = str.lastIndexOf("}");
            System.out.println("firstOpen: " + firstOpen + "firstClose: " + firstClose);
            if (firstClose <= firstOpen) {
                return null;
            }
            do {
                candidate = str.substring(firstOpen, firstClose + 1);
                System.out.println("candidate: " + candidate);
                try {
                    //String res = JSON.parse(candidate);
                    JsonReader jsonReader = Json.createReader(new StringReader(candidate));
                    JsonObject jsonObject = jsonReader.readObject();
                    jsonReader.close();
                    System.out.println("\n...found: " + jsonObject.toString());
                    System.out.println("\n...vehicles.1.positionX: " + jsonObject.get("positionX"));
                    return jsonObject;
                } catch (Exception e) {
                    System.out.println("...failed");
                }
                firstClose = str.substring(0, firstClose).lastIndexOf("}");
            } while (firstClose > firstOpen);
            firstOpen = str.indexOf("{", firstOpen + 1);
        } while (firstOpen != -1);
        return candidate;
    }

    public static String getLine(String text, String stringToFind) throws IOException {
        InputStream inputStream = org.apache.commons.io.IOUtils.toInputStream(text, "UTF-8");
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine, getLine = null;
        while ((inputLine = bufferReader.readLine()) != null) {
            if (inputLine.contains(stringToFind)) {
                getLine = inputLine;
                break;
            }
        }
        bufferReader.close();
        inputStream.close();
        return getLine.trim();
    }

    public static String getLogLine(String resp, String logLine) throws IOException {

        InputStream inputStream = org.apache.commons.io.IOUtils.toInputStream(resp, "UTF-8");
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine, getLine = null;

        while ((inputLine = bufferReader.readLine()) != null) {
            //System.out.println("\n" +inputLine);
            if (logLine.toLowerCase().contentEquals("firstego")) {
                if (inputLine.contains("roadUserType") && inputLine.contains("\"id\": 0")) {
                    getLine = inputLine;
                    break;
                }
            } else if (logLine.toLowerCase().contentEquals("firstactor")) {
                if (inputLine.contains("roadUserType") && inputLine.contains("\"id\": 1")) {
                    getLine = inputLine;
                    break;
                }
            } else if (logLine.toLowerCase().contentEquals("last")) {
                if (inputLine.contains("roadUserType") && inputLine.contains("\"id\": 1")) {
                    getLine = inputLine;
                    if (!inputLine.contains("roadUserType") && inputLine.contains("\"id\": 1"))
                        break;
                }
            } else if (logLine.toLowerCase().contentEquals("allego")) {
                if (inputLine.contains("roadUserType") && inputLine.contains("\"id\": 0")) {
                    getLine = inputLine;
                    if (!inputLine.contains("roadUserType") && inputLine.contains("\"id\": 0"))
                        break;
                }
            }
        }
        bufferReader.close();
        inputStream.close();
        return getLine;
    }
}
