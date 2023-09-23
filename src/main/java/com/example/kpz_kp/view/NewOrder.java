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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewOrder implements Initializable {

    @FXML
    private Button calculate;
    @FXML
    private Button enterButton;
    private Register register;
    @FXML
    private TextField name;

    @FXML
    private TextField payment;

    @FXML
    private TextField phone;

    @FXML
    private Label price;

    @FXML
    private Label resultLAbel;

    @FXML
    private ChoiceBox<String> service_choice;

    @FXML
    private TextField size;

    @FXML
    void calculate(ActionEvent event) {
        if (service_choice.getValue() != null && size.getText().matches("\\d+")){
            double price_res = register.getPrice(service_choice.getValue() , Integer.parseInt(size.getText()));
            price.setText("Вартість замовлення: " + price_res + " грн.");
            enterButton.setDisable(false);
            resultLAbel.setVisible(false);
        } else {
            resultLAbel.setText("Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!");
            resultLAbel.setVisible(true);
            enterButton.setDisable(true);
        }
    }

    @FXML
    void new_order(ActionEvent event) {
        if (phone.getText().matches("[0-9]{12}") && payment.getText().matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name.getText() , phone.getText() , Double.parseDouble(payment.getText()));
            if (order_res == -1){
                resultLAbel.setText("Помилка, не вистачає грошей для оплати!");
                resultLAbel.setVisible(true);
            } else {
                resultLAbel.setText("Замовлення успішно зареєстроване, решта: " + order_res + " грн.");
                resultLAbel.setVisible(true);
                enterButton.setDisable(true);
                calculate.setDisable(true);
            }
        } else {
            resultLAbel.setText("Помилка, некоретний номер телефону або сума оплати!");
            resultLAbel.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        ArrayList<String> services = register.init();
        service_choice.getItems().addAll(services);
    }
}
