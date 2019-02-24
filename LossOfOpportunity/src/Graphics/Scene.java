package Graphics;

import Gameplay.Days;
import Gameplay.Node;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Scene extends Application {

    Node node;
    String sceneText;
    int choiceNum;
    Button choice1;
    Button choice2;
    Button choice3;
    javafx.scene.Scene scene;
    HBox holdChoices;
    HBox words;
    Days days = new Days();

    public Scene(Node node) {
        this.node = node;
        sceneText = node.getSceneText();
        choiceNum = node.getChoice();
        setUpChoiceButtons();
    }


    public void setUpChoiceButtons(){
        if( node.getChild(0) != null ) {
            choice1 = new Button(node.getChild(0).getButtonText() );
            choice1.setOnAction(event -> {
                node = node.getChild(0);
                setUpChoiceButtons();
                resetScene();
            });
        } else {
            choice1 = null;
        }
        if( node.getChild(1) != null ) {
            choice2 = new Button(node.getChild(1).getButtonText() );
            choice2.setOnAction(event -> {
                node = node.getChild(1);
                setUpChoiceButtons();
                resetScene();
            });
        } else {
            choice2 = null;
        }
        if( node.getChild(2) != null ) {
            choice3 = new Button(node.getChild(2).getButtonText() );
            choice3.setOnAction(event -> {
                node = node.getChild(2);
                setUpChoiceButtons();
                resetScene();
            });
        } else {
            choice3 = null;
        }
    }

    public void resetScene(){
        //remove all the buttons
        holdChoices.getChildren().removeAll();
        //re-add them if necessary
        if( choice1 != null ) {
            holdChoices.getChildren().add(choice1);
        }
        if( choice2 != null ) {
            holdChoices.getChildren().add(choice2);
        }
        if( choice3 != null ) {
            holdChoices.getChildren().add(choice3);
        }

        //reset text
        Text newText = new Text(node.getSceneText());
        words.getChildren().removeAll();
        words.getChildren().add( newText );
    }

    public void initialize(){
        node = days.fullTree.get(0);

        Group root = new Group();
        Pane pane = new Pane( );
        scene = new javafx.scene.Scene(root, 800, 575);
        scene.setFill(Color.rgb(255, 255, 255));

        //Set up scene text stuff
        Text text = new Text(sceneText);
        text.setWrappingWidth( scene.getWidth() - 300 );
        words = new HBox(20, text);
        words.setMinWidth( scene.getWidth() );
        words.setAlignment(Pos.TOP_LEFT);
        words.setPadding(new Insets(10));

        //Adjust the scroll pane so it actually does the thing
        ScrollPane scrollPane = new ScrollPane(words);
        scrollPane.setLayoutX(25.0);
        scrollPane.setLayoutY(25.0);
        scrollPane.setPrefSize(750.0, 475.0);
        scrollPane.setHbarPolicy( ScrollPane.ScrollBarPolicy.NEVER );
        scrollPane.setVbarPolicy( ScrollPane.ScrollBarPolicy.AS_NEEDED );

        //Add scrollpane to pane
        pane.getChildren().add(scrollPane);

        //Set up buttons
        holdChoices = new HBox(20);
        setUpChoiceButtons();
        resetScene();
        holdChoices.setMinWidth( scene.getWidth() );
        holdChoices.setAlignment( Pos.BOTTOM_CENTER );
        holdChoices.setLayoutY( 525.0 );

        //Add button HBox to pane
        pane.getChildren().add(holdChoices);

        //Add everything into the pane
        pane.getChildren().add(words);
        root.getChildren().addAll(pane);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        initialize();

        primaryStage.setScene(scene);
        primaryStage.setTitle("The Loss of Opportunity");
        primaryStage.show();
    }

    public static void main(String[] args) { launch();}
}
