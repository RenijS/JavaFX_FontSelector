package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Question 1");
        build(primaryStage);
        primaryStage.show();
    }

    String fontFamily;
    String fontWeight;
    String fontStyle;
    int fontSize;

    public void build(Stage stage){
        RadioButton sansSerif = new RadioButton("sans-serif");
        RadioButton serif = new RadioButton("serif");
        RadioButton monoSpaced = new RadioButton("monospaced");
        sansSerif.setSelected(true);

        ToggleGroup group = new ToggleGroup();
        sansSerif.setToggleGroup(group);
        serif.setToggleGroup(group);
        monoSpaced.setToggleGroup(group);

        CheckBox boldCB = new CheckBox("Bold");
        CheckBox italicCB = new CheckBox("Italic");

        int choice1 = 20;
        int choice2 = 25;
        int choice3 = 30;
        int choice4 = 35;
        int choice5 = 40;
        int choice6 = 45;
        int choice7 = 50;

        ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll(choice1,choice2,choice3,choice4,choice5,choice6,choice7);
        choiceBox.setValue(choice1);

        Label label = new Label("Welcome to FX");
        label.setStyle("-fx-font-size: 20");

        Button displayBT = new Button("Display");
        displayBT.setOnAction(event -> {

            RadioButton selectedButton = (RadioButton) group.getSelectedToggle();
            fontFamily = selectedButton.getText();

            fontWeight = boldCB.isSelected()? "BOLD" : "Normal";

            fontStyle = italicCB.isSelected()? "ITALIC" : "Normal";

            fontSize = choiceBox.getValue();

            label.setStyle("-fx-font-family: " + fontFamily + ";" +
                    "-fx-font-size: " + fontSize + ";" +
                    "-fx-font-weight: " + fontWeight + ";" +
                    "-fx-font-style: " + fontStyle + ";");
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(sansSerif, serif, monoSpaced);
        hBox.setStyle("-fx-alignment: center; -fx-spacing: 20");

        VBox root = new VBox();
        root.getChildren().addAll(hBox,choiceBox,boldCB, italicCB, displayBT, label);
        root.setStyle("-fx-alignment:center; -fx-spacing: 10");

        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
