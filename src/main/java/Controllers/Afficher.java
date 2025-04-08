package Controllers;

import Models.User;
import Services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;


public class Afficher {

    @FXML
    private TableColumn<User, Integer> ageCol;

    @FXML
    private TableColumn<User, String> firstNameCol;

    @FXML
    private TableColumn<User, String> lastNameCol;

    @FXML
    private TableView<User> userTv;

    @FXML
    void initialize() {
        UserService us = new UserService();
        try {
            ObservableList<User> ol = FXCollections.observableArrayList(us.findAll());
            userTv.setItems(ol);
            ageCol.setCellValueFactory(new PropertyValueFactory<>("Age"));
            firstNameCol.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
            lastNameCol.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
