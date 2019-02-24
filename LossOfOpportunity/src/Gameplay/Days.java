package Gameplay;

import Gameplay.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Days {
    boolean hasGreg = false;
    ArrayList<Node> fullTree = new ArrayList<>();
    ArrayList<Node> currentGame = new ArrayList<>();

    public Days() {
        
    }

    public Node createNodes(String input) {
        //Variables that will be used to instantiate the node
        String sceneText = "";
        //Find the file
        String filename = input;
        File test = new File( filename );
        Node node = new Node();
        Scanner sc;
        try {
            sc = new Scanner( test );
            while( sc.hasNextLine() ) {
                String nextLine = sc.nextLine();
                if( nextLine.equals("DAY") ) {						//Got it!
                    node.setDay( sc.nextInt() );

                } else if( nextLine.equals("CHOICENUMBER") ) {		//Got it!
                    node.setChoice( sc.nextInt() );

                } else if( nextLine.equals("CHOICETEXT") ) {		//Got it!
                    node.setSceneText( sc.nextLine() );

                } else if( nextLine.equals("SCENETEXT") ) {			//Got it!
                    int lines = sc.nextInt();
                    for( int i = 0; i <= lines; i++) {
                        sceneText += sc.nextLine();
                    }
                    node.setButtonText(sceneText);

                }  else if( nextLine.equals("CHILDREN") ) {			//Got it!
                    Node[] childs = new Node[3];
                    int i = 0;
                    while( sc.hasNextLine() ) {
                        childs[i] = createNodes(sc.nextLine());
                        i++;
                    }
                    node.setChildren( childs );
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println( input + " was not found" );
        } catch( NoSuchElementException e) {
            System.out.println( "It's fine" );
        }
        return node;
    }

    public static void main( String[] args ) {
        Node root;
        Days testDay = new Days();
        //Right now it cannot find three files but that is completely intentional
        root = testDay.createNodes( "ExampleInputNode" );
        //Testing, but can be removed whenever
        System.out.println( "Choice: " + root.choice );
        System.out.println( "Text: " + root.buttonText);
        System.out.println( "Consequence: " + root.sceneText );
        System.out.println( "Day: " + root.day );
        System.out.println( "Boolean: " + root.added );
    }
}
