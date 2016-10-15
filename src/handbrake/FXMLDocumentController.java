/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handbrake;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author The Game
 * Time to play the game
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    public Label source_name_label;
    public Label source_format_label;
    String filename;
    String filedetails;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void cutButtonAction(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cut.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    @FXML
    private void convertButtonAction(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("convert.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root2));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    @FXML
    private void addPresetButtonAction(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("preset.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root2));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    /*
    *Add a new source to the system
    */
    @FXML
    private void addSourceButtonAction(ActionEvent event) {
        try {
            
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(null);
            
            if (selectedFile != null) {
                filename = selectedFile.getName().toString();
                filedetails = filename.substring(filename.lastIndexOf(".") + 1);
                
                source_name_label.setText(filename.substring(0,filename.lastIndexOf('.')));
                source_format_label.setText(filedetails);
            }
            else {
                source_name_label.setText("File selection cancelled.");
            }
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    private void btnHoverAction(ActionEvent event) {
        try {
            
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
