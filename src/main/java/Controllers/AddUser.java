package Controllers;


import Models.User;
import Services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddUser {

    @FXML
    private TextField ageTf;

    @FXML
    private TextField firstNameTF;

    @FXML
    private TextField lastNameTf;

    @FXML
    void AjouterUser(ActionEvent event) {
        UserService us = new UserService();
        User u = new User(Integer.valueOf(ageTf.getText()), this.firstNameTF.getText().toString(), this.lastNameTf.getText().toString());
        ageTf.clear();
        firstNameTF.clear();
        lastNameTf.clear();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Ajout un usuario");
        alert.showAndWait();
        try {
            us.insert(u);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    @FXML
    void Afficher(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Afficher.fxml"));
            firstNameTF.getScene().setRoot(root);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
