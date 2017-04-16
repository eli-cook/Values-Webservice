package values;
/**
 * Created by Eli on 4/13/2017.
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

public class Values {

    private ArrayList<Integer> values;

    Values() {
        values = new ArrayList<>();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            System.err.println("Hit shutdown hook, saving json file");
            JSONObject obj = new JSONObject();
            JSONArray array = new JSONArray();

            array.addAll(values);

            obj.put("values", array);

            try {
                FileWriter file = new FileWriter("values.json");
                file.write(obj.toJSONString());
                file.close();
            } catch (IOException e) {
                System.err.println("Failed to write values.json");
            }


        }));

        JSONParser parser = new JSONParser();
        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader("values.json"));
            JSONArray array = (JSONArray) obj.get("values");

            for(int i = 0; i < array.size(); i++) {
                values.add((int)(long) array.get(i));
            }
        } catch (FileNotFoundException e) {
            System.err.println("No previous values to read from values.json");
        } catch (IOException e) {
            System.err.println("Failed to read values.json");
        } catch (ParseException e) {
            System.err.println("Failed to parse values.json");
        }
    }

    public String addVal(Integer value) {
        values.add(value);
        if (!values.isEmpty()) {
            if(value == values.get(values.size()-1)){
                return "ok";
            }
        }
        return "value was not added successfully";
    }

    public String delVal() {
        values.clear();
        if(values.size() == 0) {
            return "ok";
        }
        return "DELETE failed";
    }

    public Integer sum() {
        Integer sum = 0;
        for(int i : values) {
            sum += i;
        }
        return sum;
    }
}
