package de.tse.remotedebuggingexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private TextArea textArea;

    public void start(Stage primaryStage) throws Exception {

        final BorderPane pane = new BorderPane();

        final Button button = new Button("Go!");
        button.setOnAction(new EventHandler<ActionEvent>() {

            private int clickCount = 0;

            public void handle(final ActionEvent event) {
                clickCount++;
                go(clickCount);
            }
        });

        textArea = new TextArea();

        pane.setTop(button);
        pane.setCenter(textArea);

        primaryStage.setTitle("Remote Debugging Example");
        primaryStage.setScene(new Scene(pane, 700, 500));

        primaryStage.show();
    }

    private void go(final int clickCount) {
        newLine("Number of Clicks: " + clickCount);

        final StringBuilder sb = new StringBuilder("  [");
        for (int i = 0; i < clickCount; i++) {
            sb.append("o");
        }
        sb.append("]");
        newLine(sb.toString());
    }

    private void newLine(final String line) {
        final boolean isFirstLine = "".equals(textArea.getText());
        textArea.setText(textArea.getText() + (isFirstLine ? "" : "\n") + line);
    }
}
