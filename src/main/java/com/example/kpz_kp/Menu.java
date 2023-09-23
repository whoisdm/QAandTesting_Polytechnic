package com.example.kpz_kp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button newButton;

    @FXML
    private Button viewButton;

    @FXML
    void cancel_order(ActionEvent event) throws IOException {
        Menu.newScene("delete_order.fxml","Скасування замовлення", mainPane);
    }

    @FXML
    void change_order(ActionEvent event) throws IOException {
        Menu.newScene("change_order.fxml","Позначення замовлення виконаним", mainPane);
    }

    @FXML
    void new_order(ActionEvent event) throws IOException {
        Menu.newScene("new_order.fxml","Реєстрація замовлення", mainPane);
    }

    @FXML
    void view_order(ActionEvent event) throws IOException {
        Menu.newScene("view_order.fxml","Перегляд замовлень", mainPane);
    }

    public static void newScene(String file , String title, AnchorPane pane) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource(file));
        Scene new_scene = new Scene(fxmlLoader.load());
        Stage new_stage = new Stage();
        new_stage.setTitle(title);
        new_stage.setScene(new_scene);
        new_stage.setResizable(false);
        new_stage.initModality(Modality.WINDOW_MODAL);
        new_stage.initOwner(pane.getScene().getWindow());
        new_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Objects.equals(LoginController.getUserRole(), "касир")){
            changeButton.setDisable(true);
        } else if (Objects.equals(LoginController.getUserRole(), "оператор БФП")) {
            newButton.setDisable(true);
            deleteButton.setDisable(true);
        }
    }
}
