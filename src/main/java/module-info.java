module com.example.turnundead {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.turnundead to javafx.fxml;
    exports com.example.turnundead;
}