package com.example.kpz_kp.view;

import com.example.kpz_kp.controller.Register;
import com.example.kpz_kp.model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewOrder implements Initializable {

    @FXML
    private TableColumn<Order, String> clientName;

    @FXML
    private TableColumn<Order, String> date;

    @FXML
    private DatePicker endDate;

    @FXML
    private Label error;

    @FXML
    private TableColumn<Order, Integer> id;

    @FXML
    private TableColumn<Order, String> phone;

    @FXML
    private TableColumn<Order, Double> price;

    @FXML
    private TableColumn<Order, String> service_name;

    @FXML
    private TableColumn<Order, Integer> size;

    @FXML
    private DatePicker startDate;

    @FXML
    private TableColumn<Order, String> status;

    @FXML
    private TableView<Order> table;
    private Register register;

    @FXML
    void view_order(ActionEvent event) {
        if (startDate.getValue() != null && endDate.getValue() != null){
            error.setVisible(false);
            ObservableList<Order> orders = register.getOrders(startDate.getValue().toString() , endDate.getValue().toString());
            table.setItems(orders);
        } else{
            error.setText("Оберіть дати пошуку!");
            error.setVisible(true);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("number"));
        service_name.setCellValueFactory(new PropertyValueFactory<>("service_name"));
        size.setCellValueFactory(new PropertyValueFactory<>("size"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        register.init_view();
    }
}
