package com.main.codelab6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the login form
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add title
        Label title = new Label("Halaman Login");
        title.setFont(Font.font("Times new roman", FontWeight.BOLD, 24));
        grid.add(title, 0, 0, 2, 1);

        // Add username label and field
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);
        TextField userField = new TextField();
            grid.add(userField, 1, 1);

            // Add password label and field
            Label pw = new Label("Password:");
            grid.add(pw, 0, 2);
            PasswordField pwField = new PasswordField();
            grid.add(pwField, 1, 2);

            // Add login button
            Button btn = new Button("Sign in");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn.getChildren().add(btn);
            grid.add(hbBtn, 1, 4);

            // Add error message
            Label errorLabel = new Label("");
            errorLabel.setTextFill(Color.RED);
            grid.add(errorLabel, 1, 3);

            // Handle login button click
            btn.setOnAction(event -> {
                String username = userField.getText();
            String password = pwField.getText();

            // Check if username and password are correct
            if (username.equals("fanden") && password.equals("377")) {
                // Create the success scene
                GridPane successGrid = new GridPane();
                successGrid.setAlignment(Pos.CENTER);
                successGrid.setHgap(10);
                successGrid.setVgap(10);
                successGrid.setPadding(new Insets(25, 25, 25, 25));

                Label welcomeLabel = new Label("Halo FanDen");
                successGrid.add(welcomeLabel, 0, 0);
                Button okButton = new Button("OK");
                HBox hbOk = new HBox(10);
                hbOk.setAlignment(Pos.BOTTOM_RIGHT);
                hbOk.getChildren().add(okButton);
                successGrid.add(hbOk, 0,1 );

                okButton.setOnAction(e -> primaryStage.close());
                Scene successScene = new Scene(successGrid, 300, 200);
                primaryStage.setScene(successScene);
                primaryStage.show();
            } else {
                // Show error message
                errorLabel.setText("Password Atau Username Salah");
            }
        });

        // Create the login scene
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setTitle("Form Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}