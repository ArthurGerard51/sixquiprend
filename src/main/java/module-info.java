module sqp.sixquiprend {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens sqp to javafx.fxml;
    exports sqp;
}