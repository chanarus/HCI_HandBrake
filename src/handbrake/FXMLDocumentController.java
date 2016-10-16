/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *This project has been done by a undergraduat student group of curtin univercity
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
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author The Game Time to play the game
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    public Label source_name_label;
    public Label source_format_label;
    public TextField destination_txt;

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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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

                source_name_label.setText(filename.substring(0, filename.lastIndexOf('.')));
                source_format_label.setText(filedetails);

            } else {
                source_name_label.setText("File selection cancelled.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void browseOutputButtonAction(ActionEvent event) {
        try {
            DirectoryChooser chooser = new DirectoryChooser();
            chooser.setTitle("JavaFX Projects");
            File defaultDirectory = new File("C:\\test");
            chooser.setInitialDirectory(defaultDirectory);
            File selectedDirectory = chooser.showDialog(null);

            if (selectedDirectory != null) {
                destination_txt.setText(selectedDirectory.getAbsolutePath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openOutputButtonAction(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();

            String userDirectoryString = destination_txt.getText();
            File userDirectory = new File(userDirectoryString);
            fileChooser.setInitialDirectory(userDirectory);
            File selectedFile = fileChooser.showOpenDialog(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
