package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Daily_Forecast implements Initializable {


    private Stage stage;
    private Parent root;
    private Scene scene;

    static String city;
    static String Cntry;
    static String lati;
    static String lonn;
    static String api="";
    static String max1=" ",max2=" ",max3=" ",max6=" ",max12=" ",max16=" ";
    static String min1=" ",min2=" ",min3=" ",min6=" ",min12=" ",min16=" ";


    @FXML
    Label headingText;
    @FXML
    Label dailyMax1, dailyMax2, dailyMax3, dailyMax6, dailyMax12, dailyMax16, dailyMin1, dailyMin2, dailyMin3, dailyMin6, dailyMin12, dailyMin16;


    public void backInWeather(ActionEvent event) throws IOException {
        Weather.dp = city;
        root = FXMLLoader.load(Log_in.class.getResource("Weather.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Log_In Page");
        stage.setScene(scene);
        stage.show();
    }

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        headingText.setText("Hourly  Forecast in " + city + "," + Cntry);
        System.out.println(lati);
        System.out.println(lonn);

//        System.out.println(max1+" "+max2+" "+max3+" "+max6+" "+max12+" "+max16);
//        System.out.println(min1+" "+min2+" "+min3+" "+min6+" "+min12+" "+min16);
        //°


        dailyMax1.setText(max1+" °F");
        dailyMax2.setText(max3+" °F");
        dailyMax3.setText(max2+" °F");
        dailyMax6.setText(max12+" °F");
        dailyMax12.setText(max16+" °F");
        dailyMax16.setText(max6+" °F");



        dailyMin1.setText(min1+" °F");
        dailyMin2.setText(min6+" °F");
        dailyMin3.setText(min12+" °F");
        dailyMin6.setText(min2+" °F");
        dailyMin12.setText(min16+" °F");
        dailyMin16.setText(min3+" °F");






    }
}
