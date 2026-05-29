module com.mycompany.projeto_stock {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    
    opens com.mycompany.projeto_stock to javafx.fxml;
    exports com.mycompany.projeto_stock;
    
    // para PropertyValueFactory funcionar é necessário usar a cláusula a seguir:
    opens model.classes;
}
