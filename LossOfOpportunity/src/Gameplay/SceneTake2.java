package Gameplay;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SceneTake2 extends Application {
    Node node;
    String sceneText = "This is text.";
    Text text;
    int choiceNum;
    Button choice1;
    Button choice2;
    Button choice3;
    javafx.scene.Scene scene;
    HBox holdChoices;
    HBox words;



    public void initializeButtons() {
        //Determine 1st button
        if( node.getChild(0) != null ) {
            choice1 = new Button(node.getChild(0).getButtonText() );
            holdChoices.getChildren().add(choice1);
        } else {
            choice1 = null;
        }
        //Determine 2nd button
        if( node.getChild(1) != null ) {
            choice2 = new Button(node.getChild(1).getButtonText() );
            holdChoices.getChildren().add(choice2);
        } else {
            choice2 = null;
        }
        //Determine 3rd button
        if( node.getChild(2) != null ) {
            choice3 = new Button(node.getChild(2).getButtonText() );
            holdChoices.getChildren().add(choice3);
        } else {
            choice3 = null;
        }
    }

//    public void initializeButtonsBasic() {
//        choice1 =  new Button( "b1" );
//        choice2 =  new Button( "b2" );
//        choice3 =  new Button( "b3" );
//        holdChoices.getChildren().addAll(choice1, choice2, choice3);
//    }

    public void reset( int childIndex ) {
        node = node.getChild( childIndex );
        holdChoices.getChildren().removeAll();
        initializeButtons();

        sceneText = "Scene has been reset, bitches.";
        text.setText(sceneText);
    }

    public void initialize(){

        Group root = new Group();
        Pane pane = new Pane( );
        scene = new javafx.scene.Scene(root, 800, 575);
        scene.setFill(Color.rgb(255, 255, 255));

        //Set up scene text stuff
        text = new Text(sceneText);
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
        holdChoices.setMinWidth( scene.getWidth() );
        holdChoices.setAlignment( Pos.BOTTOM_CENTER );
        holdChoices.setLayoutY( 525.0 );

        initializeButtons();
//        initializeButtonsBasic();

        //Add button HBox to pane
        pane.getChildren().add(holdChoices);

        //Add everything into the pane
        pane.getChildren().add(words);
        root.getChildren().addAll(pane);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        initialize();
        choice1.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            reset(0);
        });
        choice2.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            reset(1);
        });
        choice3.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            reset(2);
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("The Loss of Opportunity");
        primaryStage.show();
    }

}
