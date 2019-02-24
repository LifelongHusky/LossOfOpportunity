package Graphics;

import Gameplay.Node;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Scene extends Application {

    Node node;
    String sceneText;
    int choiceNum;
    Button choice1 = new Button("choice 1");
    Button choice2 = new Button("choice 2");
    Button choice3 = new Button("choice 3");

    public Scene(Node node) {
        this.node = node;
        sceneText = node.getSceneText();
        choiceNum = node.getChoice();
        setUpChoiceButtons();
    }

    public Scene() {
        sceneText = "This is text for a scene.";
        choiceNum = 0;
//        setUpChoiceButtons();
    }


    public void setUpChoiceButtons(){
        if( node.getChild(0) != null ) {
            choice1 = new Button(node.getChild(0).getButtonText() );
        } else {
            choice1 = null;
        }
        if( node.getChild(1) != null ) {
            choice2 = new Button(node.getChild(1).getButtonText() );
        } else {
            choice2 = null;
        }
        if( node.getChild(2) != null ) {
            choice3 = new Button(node.getChild(2).getButtonText() );
        } else {
            choice3 = null;
        }
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Pane pane = new Pane();
        javafx.scene.Scene scene = new javafx.scene.Scene(root, 800, 600);
        scene.setFill(Color.rgb(255, 255, 255));
        Text text = new Text(sceneText);
        text.setWrappingWidth( scene.getWidth() - 300 );
        HBox words = new HBox(20, text);
        words.setMinWidth( scene.getWidth() );
        words.setAlignment(Pos.TOP_CENTER);

        HBox holdChoices = new HBox(20);
        if( choice1 != null )
            holdChoices.getChildren().add(choice1);
        if( choice2 != null )
            holdChoices.getChildren().add(choice2);
        if( choice3 != null )
            holdChoices.getChildren().add(choice3);
        holdChoices.setMinWidth( scene.getWidth() );
        holdChoices.setAlignment( Pos.BOTTOM_CENTER );

        //Add everything into the border pane

        holdChoices.setLayoutY( 525.0 );
        pane.getChildren().add(holdChoices);
        words.setLayoutY(0.0);
        pane.getChildren().add(words);

        root.getChildren().addAll(pane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("The Loss of Opportunity");
        primaryStage.show();
    }

    public static void main(String[] args) { launch();}
}
