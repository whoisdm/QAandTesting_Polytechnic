module com.example.kpz_kp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires itextpdf;


    opens com.example.kpz_kp to javafx.fxml;
    exports com.example.kpz_kp;
    opens com.example.kpz_kp.view to javafx.fxml;
    exports com.example.kpz_kp.view;
    opens com.example.kpz_kp.model to javafx.fxml;
    exports com.example.kpz_kp.model;
}