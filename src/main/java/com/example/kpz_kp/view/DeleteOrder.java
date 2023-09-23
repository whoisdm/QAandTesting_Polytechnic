package com.example.kpz_kp.view;

import com.example.kpz_kp.controller.Register;
import com.example.kpz_kp.model.Calculator;
import com.example.kpz_kp.model.DataBase;
import com.example.kpz_kp.model.Organization;
import com.example.kpz_kp.model.Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteOrder implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private Label resultLabel;
    @FXML
    private Button button;
    private Register register;

    @FXML
    void delete_order(ActionEvent event) {
        if (id.getText().matches("\\d+")){
            double compensation = register.cancelOrder(Integer.parseInt(id.getText()));
            if (compensation == -1){
                resultLabel.setText("Даного замовлення не існує, компенсація недоступна!");
            } else {
                resultLabel.setText("Замовлення успішно скасоване, компенсація: " + compensation +" грн.");
            }
            resultLabel.setVisible(true);
            button.setDisable(true);
        } else {
            resultLabel.setText("Помилка, номер замовлення має бути цілим числом!");
            resultLabel.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        register.init_del();
    }
}
