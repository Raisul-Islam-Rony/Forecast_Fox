package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Fecthing_Value {


    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
    }


    public static void SwitchOver(String latitude,String longtitude)
    {
        String API_KEY = "3165f9dcbc1aa615330e95a041e275ec";
        System.out.println(latitude);
        System.out.println(longtitude);


        String urlStr = "https://api.openweathermap.org/data/2.5/onecall?lat="+latitude+"&"+longtitude+"=exclude=minutely&appid=3165f9dcbc1aa615330e95a041e275ec&units=imperial";
        try {
            StringBuilder result = new StringBuilder();
            URL urlll = new URL(urlStr);
            URLConnection conn = urlll.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();


            Map<String, Object> readMap = jsonToMap(result.toString());
            String str=readMap.toString();
            String sp[]=str.split("temp");
            System.out.println(sp[2]);

            //System.out.println(str);



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
