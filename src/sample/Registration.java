package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class Registration implements Initializable {
    @FXML
    private Button jumpToSignIn;
    private Hyperlink signInhyperlink;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    Button registerId;
    @FXML
    TextField passwordId,usernameId,citynameId;
    int count=0;

    static  HashMap<String, String>hashMap=new HashMap<>();
    static HashMap<String,String>cityMap=new HashMap<>();



    public void SwitchToLogIn(ActionEvent event) throws Exception
    {
        root= FXMLLoader.load(Log_in.class.getResource("Log_In.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setTitle("Log_In Page");
        stage.setScene(scene);
        stage.show();
    }
    public void addValueInMap()
    {
        if(count==0)
        {

            hashMap.put("Rony","123456");
            cityMap.put("Rony","Dublin");
            hashMap.put("Raisul056","123456");
            cityMap.put("Raisul056","Washington");
            count++;
        }
        String str1=usernameId.getText().toString();
        String str2=passwordId.getText().toString();
        String str3=citynameId.getText().toString();
        hashMap.put(str1,str2);
        cityMap.put(str1,str3);
        System.out.println(hashMap);
    }

    public static HashMap<String, String> getHashMap() {
        return hashMap;
    }
    public static HashMap<String,String>getCityMap1()
    {
        return cityMap;
    }
    public String getCityName(String s)
    {
        String city=cityMap.get(s);
        return city;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
