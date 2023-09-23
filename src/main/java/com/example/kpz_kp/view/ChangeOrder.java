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

public class ChangeOrder implements Initializable {

    @FXML
    private Button button;

    @FXML
    private TextField id;

    @FXML
    private Label resultLabel;

    private Register register;

    @FXML
    void change_order(ActionEvent event) {
        if (id.getText().matches("\\d+")){
            int change_res = register.changeOrder(Integer.parseInt(id.getText()));
            if (change_res == 1){
                resultLabel.setText("Замовлення позначене виконаним!");
            } else {
                resultLabel.setText("Замовлення не існує!");
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
        register.init_change();
    }
}
