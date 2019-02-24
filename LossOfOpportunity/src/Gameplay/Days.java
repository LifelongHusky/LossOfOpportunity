package Gameplay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Days {
    boolean hasGreg = false;
    ArrayList<Node> fullTree = new ArrayList<>();

    public Days() {
        
    }

    public Node createNodes(File input) {
        Node node = new Node();
        Scanner sc;
        try {
            sc = new Scanner( input );
            while( sc.hasNextLine() ) {
                String nextLine = sc.nextLine();
                if( nextLine.equals("DAY") ) {						//Got it!
                    node.setDay( sc.nextInt() );

                } else if( nextLine.equals("HASGREG") ) {			//Got it!
                    hasGreg = sc.nextBoolean();

                } else if( nextLine.equals("CHOICENUMBER") ) {		//Got it!
                    node.setChoice( sc.nextInt() );

                } else if( nextLine.equals("CHOICETEXT") ) {		//Got it!
                    node.setSceneText( sc.nextLine() );

                } else if( nextLine.equals("SCENETEXT") ) {			//Got it!
                    int lines = sc.nextInt();
                    String s = "";
                    for( int i = 0; i <= lines; i++) {
                        s += sc.nextLine();
                    }
                    node.setButtonText(s);

                }  else if( nextLine.equals("CHILDREN") ) {			//Got it!
                    String[] childs = new String[3];
                    int i = 0;
                    while( sc.hasNextLine() ) {
                        childs[i] = sc.nextLine();
                        i++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch( NoSuchElementException e) {

        }
        return new Node();
    }

    public static void main( String[] args ) {
        Days testDay = new Days();
        File test = new File( "C:\\Users\\ealbr\\IdeaProjects\\LossOfOpportunity1\\LossOfOpportunity\\src\\ExampleInputNode" );
        testDay.createNodes( test );
    }

}
