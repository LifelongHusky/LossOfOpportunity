package Graphics;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Laura Albrant
 * @author Katie Shmidt
 * @author Meagen Pothoven
 * @author Stephanie BoBo
 */

public class TransmissionIncoming extends Application {  //Scan in a file based on if it is start or end

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Text text = new Text(50, 280, "Transmission Incoming");
        text.setFill(Color.rgb(255, 0, 0));
        text.setFont(new Font(70));

        Button accptT = new Button();
        accptT.setText("Accept Transmission");
        accptT.setTextFill(Color.rgb(0, 0, 0));
        accptT.setLayoutX(320);
        accptT.setLayoutY(270);
        accptT.setVisible(false);
        accptT.setStyle("-fx-background-color: Red"); //Changes background button color


        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.9), e -> text.setVisible(false)),  //This code is being weird - wont let me time it correctly
                new KeyFrame(Duration.seconds(0.45), e -> text.setVisible(true)));
        timeline.setCycleCount(5);
        timeline.setOnFinished(e -> accptT.setVisible(true));
        timeline.play();

        accptT.setOnAction(e -> {
            accptT.setVisible(false);
        });

        root.getChildren().addAll(text, accptT);
        Scene scene = new Scene(root, 800, 600);
        scene.setFill(Color.rgb(0, 0, 0));
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Loss of Opportunity");
        primaryStage.show();
    }
}
