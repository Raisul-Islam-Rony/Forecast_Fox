package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Log_In.fxml"));
        primaryStage.setTitle("Log In page");
        primaryStage.setScene(new Scene(root));


        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            logout(primaryStage);
        });


        primaryStage.show();

    }
    public void logout(Stage primaStage)
    {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit From The Window ");
        alert.setHeaderText("You are about to exit !!!");
        alert.setContentText("Are you sure, you want to exit ?");
        if(alert.showAndWait().get()== ButtonType.OK)
        {
            primaStage.close();
        }
    }





    public static void main(String[] args) {
        launch(args);
    }
}
