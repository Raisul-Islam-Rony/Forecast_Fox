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
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.json.JSONArray;
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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.spec.ECField;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Weather implements Initializable {
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    static int cnt = 0;
    String cityName;
    String CountryName;
    String latitude;
    String longtitude;
    @FXML
    Label dateLabel, timeLabel;
    @FXML
    Label current_temp, feels_like_label, max_temp_label, min_temp_label, humidity_label, pressure_label, frontText;
    @FXML
    TextField text_field;
    @FXML
    Label day1, day2, day3, day4, day5;
    @FXML
    Label max1, min1, max2, min2, max3, min3, max4, min4, max5, min5;
    @FXML
    Button notificationButton;
    static int count = 0;
    public static String dp;
    static String noti;
    String country=" ";

    Date date = new Date();
    SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm a");
    String formatingDate = (formatDate.format(date)).toString();


    SimpleDateFormat format2 = new SimpleDateFormat("dd MMMMM yyyy");
    String str2 = format2.format(date).toString().toUpperCase();

    public void setDp(String s) {
        dp = s;
    }
    public String getDp() {
        return dp;
    }




    public void SwitchToLog_In(ActionEvent event) throws Exception {
        Weather.cnt=0;
        root = FXMLLoader.load(Log_in.class.getResource("Log_In.fxml"));
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




    public void switchToDaily(ActionEvent event) throws IOException {

        String API_KEY = "3165f9dcbc1aa615330e95a041e275ec";
        System.out.println(longtitude);
        System.out.println(latitude);

        String urlStr = "https://api.openweathermap.org/data/2.5/onecall?lat="+latitude+"&lon="+longtitude+"&exclude=minutely&appid=3165f9dcbc1aa615330e95a041e275ec&units=imperial";
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
            String dp1[]=sp[2].split(",");
            String dp2[]=sp[3].split(",");
            String dp3[]=sp[4].split(",");
            String dp4[]=sp[5].split(",");
            String dp5[]=sp[6].split(",");
            String dp6[]=sp[7].split(",");



            System.out.println(dp1[1]);
            System.out.println(dp1[2]);
            //System.out.println(dp1[0]);
            System.out.println(dp2[1]);
            System.out.println(dp2[2]);

            System.out.println(dp3[1]);
            System.out.println(dp3[2]);
            // System.out.println(sp[2]);

            System.out.println(dp4[1]);
            System.out.println(dp4[2]);

            Daily_Forecast.max1=dp1[2];
            Daily_Forecast.max2=dp2[2];
            Daily_Forecast.max3=dp3[2];
            Daily_Forecast.max6=dp4[2];
            Daily_Forecast.max12=dp5[2];
            Daily_Forecast.max16=dp6[2];


            Daily_Forecast.min1=dp1[1];
            Daily_Forecast.min2=dp2[1];
            Daily_Forecast.min3=dp3[1];
            Daily_Forecast.min6=dp4[1];
            Daily_Forecast.min12=dp5[1];
            Daily_Forecast.min16=dp5[1];

            System.out.println(str);




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Daily_Forecast.city=cityName;
        Daily_Forecast.Cntry=CountryName;
        Daily_Forecast.lati=latitude;
        Daily_Forecast.lonn=longtitude;


//        double[] aa =ForeCast.Fecth_Daily();
//        String crtn = current_temp.getText();
//        Double value = Double.parseDouble(crtn);
//        Double Maxi,Mini;
//
//        for(int i=0; i<6; i++)
//        {
//            Maxi=value+aa[i];
//            Mini=value-aa[i];
//            if(i==0)
//            {
//                Daily_Forecast.max1=new DecimalFormat("##.##").format(Maxi);
//                Daily_Forecast.min1=new DecimalFormat("##.##").format(Mini);
//            }
//            else if(i==1)
//            {
//                Daily_Forecast.max2=new DecimalFormat("##.##").format(Maxi);
//                Daily_Forecast.min2=new DecimalFormat("##.##").format(Mini);
//            }
//            else if(i==2)
//            {
//                Daily_Forecast.max3=new DecimalFormat("##.##").format(Maxi);
//                Daily_Forecast.min3=new DecimalFormat("##.##").format(Mini);
//
//            }
//            else if(i==3)
//            {
//                Daily_Forecast.max6=new DecimalFormat("##.##").format(Maxi);
//                Daily_Forecast.min6=new DecimalFormat("##.##").format(Mini);
//
//            }
//            else if(i==4)
//            {
//                Daily_Forecast.max12=new DecimalFormat("##.##").format(Maxi);
//                Daily_Forecast.min12=new DecimalFormat("##.##").format(Mini);
//            }
//            else
//            {
//                Daily_Forecast.max16=new DecimalFormat("##.##").format(Maxi);
//                Daily_Forecast.min16=new DecimalFormat("##.##").format(Mini);
//            }
//        }
//

        System.out.println(latitude);
        System.out.println(longtitude);





        root = FXMLLoader.load(Log_in.class.getResource("Daily_Forecast.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Daily-ForeCast_Page");
        stage.setScene(scene);
        stage.show();
    }







    public void FetchingValue() {


        String API_KEY = "3165f9dcbc1aa615330e95a041e275ec";
        String Location = text_field.getText().toString();
        cityName=Location;
        String urlStr = "http://api.openweathermap.org/data/2.5/weather?q=" + Location + "&appid=" + API_KEY + "&units=imperial";
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
            Map<String, Object> mainMap = jsonToMap(readMap.get("main").toString());
            Map<String, Object> cntry = jsonToMap(readMap.get("sys").toString());
            Map<String,Object>crd=jsonToMap(readMap.get("coord").toString());

            latitude=crd.get("lat").toString();
            longtitude=crd.get("lon").toString();



            String crntTemp = mainMap.get("temp").toString();
            String feelsLike = mainMap.get("feels_like").toString();
            String maxTemp = mainMap.get("temp_max").toString();
            String minTemp = mainMap.get("temp_min").toString();
            String humidity = mainMap.get("humidity").toString();
            String pressure = mainMap.get("pressure").toString();
            String country = cntry.get("country").toString();

            CountryName=country;


            current_temp.setText(" " + crntTemp);
            feels_like_label.setText(feelsLike + "° F");
            max_temp_label.setText(maxTemp + "° F");
            min_temp_label.setText(minTemp + "° F");
            humidity_label.setText(humidity + "%");
            pressure_label.setText(pressure + " psi");

            frontText.setText(Location + ", " + country);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void Forecast() throws Exception {

        String API_KEY = "3165f9dcbc1aa615330e95a041e275ec";
        String Location = text_field.getText().toString();
        String urlStr = "http://api.openweathermap.org/data/2.5/forecast?q="+cityName+","+CountryName+"&appid=3165f9dcbc1aa615330e95a041e275ec";

        StringBuilder result = new StringBuilder();
        URL urlll = new URL(urlStr);
        URLConnection conn = urlll.openConnection();
        BufferedReader read = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line, str1, str2;
        Double maxi, mini;

        ForeCast foreCast = new ForeCast();
        int ara[] = foreCast.Fecth_forecast();
        String crtn = current_temp.getText();
        Double value = Double.parseDouble(crtn);
        while ((line = read.readLine()) != null) {
            result.append(line);
        }
        read.close();
        JSONArray jsonArray = new JSONArray();


        Map<String, Object> readMap = jsonToMap(result.toString());
//        Map<String, Object> mainMap = jsonToMap(readMap.get("main").toString());
//        Map<String, Object> cntry = jsonToMap(readMap.get("sys").toString());
//        Map<String, Object> forecast = jsonToMap(readMap.get("wind").toString());

        String str=readMap.toString();
        System.out.println(str);
        for (int i = 0; i < 5; i++) {
            maxi = value + ara[i];
            mini = value - ara[i];
            if (i == 0) {

                max1.setText("Max_Temp :" + new DecimalFormat("##.##").format(maxi) + "° F");
                min1.setText("Min_Temp: " + new DecimalFormat("##.##").format(mini) + "° F");
            } else if (i == 1) {
                str1 = maxi.toString();
                str2 = mini.toString();
                max2.setText("Max_Temp :" + new DecimalFormat("##.##").format(maxi) + "° F");
                min2.setText("Min_Temp: " + new DecimalFormat("##.##").format(mini) + "° F");
            } else if (i == 2) {
                str1 = maxi.toString();
                str2 = mini.toString();
                max3.setText("Max_Temp :" + new DecimalFormat("##.##").format(maxi) + "° F");
                min3.setText("Min_Temp: " + new DecimalFormat("##.##").format(mini) + "° F");
            } else if (i == 3) {
                str1 = maxi.toString();
                str2 = mini.toString();
                max4.setText("Max_Temp :" + new DecimalFormat("##.##").format(maxi) + "° F");
                min4.setText("Min_Temp: " + new DecimalFormat("##.##").format(mini) + "° F");

            } else {
                str1 = maxi.toString();
                str2 = mini.toString();
                max5.setText("Max_Temp: " + str1 + "° F");
                min5.setText("Min_Temp: " + new DecimalFormat("##.##").format(mini) + "° F");
            }
        }
        maxi = value + ara[4];
        mini = value - ara[4];
        str1 = maxi.toString();
        str2 = mini.toString();
        count++;




//        String maxTemp = mainMap.get("temp_max").toString();
//        String minTemp = mainMap.get("temp_min").toString();

        max5.setText("Max_Temp :" + new DecimalFormat("##.##").format(maxi) + "° F");
        min5.setText("Min_Temp: " + new DecimalFormat("##.##").format(mini) + "° F");

    }


    public void changeTempToCelcius() {
        String str = current_temp.getText().toString();
        Double frnht = Double.parseDouble(str);
        Double celc = 5 * ((frnht - 32) / 9);

        current_temp.setText(new DecimalFormat("##.##").format(celc));
    }

    public void changeTempToFarenheit() {
        String str = current_temp.getText().toString();
        Double celc = Double.parseDouble(str);
        Double frnht = ((celc / 5) * 9) + 32;
        current_temp.setText(new DecimalFormat("##.##").format(frnht));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {




        timeLabel.setText(formatingDate);
        dateLabel.setText(str2);
        System.out.println(dp);

        String API_KEY = "3165f9dcbc1aa615330e95a041e275ec";
        String Location = dp;
        cityName=Location;
        if(count==0)
        {
            noti=dp;
            count++;
        }


        String urlStr = "http://api.openweathermap.org/data/2.5/weather?q=" + Location + "&appid=" + API_KEY + "&units=imperial";
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
            Map<String, Object> mainMap = jsonToMap(readMap.get("main").toString());
            Map<String, Object> cntry = jsonToMap(readMap.get("sys").toString());

            Map<String,Object>crd=jsonToMap(readMap.get("coord").toString());
            latitude=crd.get("lat").toString();
            longtitude=crd.get("lon").toString();



            String crntTemp = mainMap.get("temp").toString();
            String feelsLike = mainMap.get("feels_like").toString();
            String maxTemp = mainMap.get("temp_max").toString();
            String minTemp = mainMap.get("temp_min").toString();
            String humidity = mainMap.get("humidity").toString();
            String pressure = mainMap.get("pressure").toString();
            String country = cntry.get("country").toString();

            CountryName=country;


            current_temp.setText(" " + crntTemp);
            feels_like_label.setText(feelsLike + "° F");
            max_temp_label.setText(maxTemp + "° F");
            min_temp_label.setText(minTemp + "° F");
            humidity_label.setText(humidity + "%");
            pressure_label.setText(pressure + " psi");

            frontText.setText(Location + ", " + country);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Date date = new Date();
        String dayWeekText = new SimpleDateFormat("EEEE").format(date);


        String[] str = new String[7];
        str[0] = "Sunday";
        str[1] = "Monday";
        str[2] = "Tuesday";
        str[3] = "Wednesday";
        str[4] = "Thursday";
        str[5] = "Friday";
        str[6] = "Saturday";


        int i = 0;
        String s[] = new String[5];
        int c = -1;
        for (i = 0; i < 7; i++) {
            if (str[i].equals(dayWeekText)) {
                c = i + 1;
                break;
            }
        }

        // System.out.println(c);
        int count = 0;

        for (i = 0; i < 5; i++) {
            if (c >= 7) {
                c = 0;
                s[i] = str[c];
                c++;
            } else {
                s[i] = str[c];
                c++;
            }
        }

        day1.setText(s[0]);
        day2.setText(s[1]);
        day3.setText(s[2]);
        day4.setText(s[3]);
        day5.setText(s[4]);






}

    public void NotiFication() throws IOException {
        String API_KEY = "3165f9dcbc1aa615330e95a041e275ec";
        String Location = dp;
        System.out.println(noti);
        String urlStr = "http://api.openweathermap.org/data/2.5/weather?q=" + Location + "&appid=" + API_KEY + "&units=imperial";

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
        Map<String, Object> mainMap = jsonToMap(readMap.get("main").toString());

        Map<String, Object> cntry = jsonToMap(readMap.get("sys").toString());




        String ara=  (readMap.get("weather")).toString();


        String []dp=ara.split(",");

        String []xx=dp[2].split("=");
        String text=xx[1].toUpperCase();
        System.out.println(text);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Notification Box");
        alert.setHeaderText("Updates in your area");

        alert.setContentText(text+" In Your Place For Today");
        if(alert.showAndWait().get()== ButtonType.OK)
        {
            alert.close();
        }

        notificationButton.setText("Notification-0");


    }
}

