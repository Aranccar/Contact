package sample;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    private ObservableList<Contact> contacts = FXCollections.observableArrayList();

    private Contact contactSelected;


    @FXML
    private ListView<Contact> textview;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField age;

    @FXML
    private TextField surname;

    @FXML
    private TextField namefield;

    @FXML
    private TextField surnamefield;

    @FXML
    private TextField agefield;

    @FXML
    private TextField phonefield;

    @FXML
    private TextField phone;

    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private Button update;

    @FXML
    void initialize() {
        contacts.add(new Contact("Name1", "N", "11", "1234"));
        contacts.add(new Contact("Name2", "M", "13", "563456"));
        contacts.add(new Contact("Name3", "K", "32", "265202"));
        contacts.add(new Contact("Name4", "Z", "17", "1170"));
        textview.setItems(contacts);

        textview.getSelectionModel().selectedItemProperty().addListener((arg0, oldValue, newValue) -> {
            contactSelected = newValue;
            namefield.setText(newValue.getFirstName());
            surnamefield.setText(newValue.getLastName());
            agefield.setText(newValue.getAge());
            phonefield.setText(newValue.getPhoneNumber());
        });
    }

    @FXML
    void addContactButtonPressed(ActionEvent event) {
        Contact newContact = new Contact();
        newContact.setFirstName(namefield.getText().trim());
        newContact.setLastName(surnamefield.getText().trim());
        newContact.setAge(agefield.getText().trim());
        newContact.setPhoneNumber(phonefield.getText().trim());
        contacts.add(newContact);
    }

    @FXML
    void deleteContactButtonPressed(ActionEvent event) {
        contacts.remove(contactSelected);
    }

    @FXML
    void updateContactButtonPressed(ActionEvent event) {
        contactSelected.setFirstName(namefield.getText().trim());
        contactSelected.setLastName(surnamefield.getText().trim());
        contactSelected.setAge(agefield.getText().trim());
        contactSelected.setPhoneNumber(phonefield.getText().trim());
    }
}
