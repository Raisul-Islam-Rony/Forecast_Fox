package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.HashMap;

public class Log_in {
   @FXML
    private Button signInButton,jumpToregister;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField loginUsername,loginPassword;





    public String  getUsername()
    {
        return this.loginUsername.getText().toString();
    }

    public void SwitchToWeather(ActionEvent event) throws Exception {
       // Registration rr = new Registration();


//        hash_map =Registration.getHashMap();
//        cityMap2=Registration.getCityMap1();
        HashMap<String, String> hash_map=Registration.getHashMap();
        HashMap<String,String>cityMap2=Registration.getCityMap1();
        String str1 = loginUsername.getText().toString();
        String check=hash_map.get(str1);
        String str2 = loginPassword.getText().toString();








    if(check.equals(str2)) {

        String ss=loginUsername.getText().toString();
        String pp=cityMap2.get(ss);
        Weather.dp=pp;

        FXMLLoader loader=new FXMLLoader(Log_in.class.getResource("Weather.fxml"));


        root = loader.load();


        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Weather_Page");
        stage.setScene(scene);




        stage.show();
    }
    else
    {
        System.out.println("Invalid PassCode");
    }



    }

        public void SwitchToRegister (ActionEvent event) throws Exception
        {
            root = FXMLLoader.load(Log_in.class.getResource("Registration.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Registration_Page");
            stage.setScene(scene);


        }

    }

