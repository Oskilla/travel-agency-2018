package fr.unantes.software.construction.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application  {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();

        // name box
        TextField field1 = new TextField();
        Label lbl1 = new Label("Name:");
        lbl1.setLabelFor(field1);
        Button loginButton = new Button();

        // password box
        TextField field2 = new TextField();
        Label lbl2 = new Label("Password:");
        lbl1.setLabelFor(field2);


        loginButton.setText("Login");
        loginButton.setOnAction(event -> {
            System.out.println("login with name=" + field1.getText() + " and password=" + field2.getText());
        });

        root.add(lbl1, 0, 0);
        root.add(field1, 2, 0);
        root.add(lbl2, 0, 1);
        root.add(field2, 2, 1);
        root.add(loginButton, 0, 3);

        Scene scene = new Scene(root, 280, 200);
        stage.setScene(scene);
        stage.show();
    }
}
