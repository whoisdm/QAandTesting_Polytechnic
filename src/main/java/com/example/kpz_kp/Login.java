package com.example.kpz_kp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private Label error_field;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField pass_field;

    @FXML
    void login(ActionEvent event) {
        int res = LoginController.loginCheck(login_field.getText() , pass_field.getText());
        if (res == -1){
            error_field.setVisible(true);
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("menu.fxml"));
                Scene main_scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setScene(main_scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
