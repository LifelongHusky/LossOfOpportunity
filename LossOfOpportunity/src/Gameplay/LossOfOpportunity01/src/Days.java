import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Winter Wonderhack
 * February 22-24, 2019
 *
 * @author Laura Albrant
 * @author Katie Schmidt
 * @author Meagan Pothoven
 * @author Stephanie BoBo
 */

public class Days {
    boolean hasGreg = false;
    ArrayList<Node> fullTree = new ArrayList<>();
    ArrayList<Node> currentGame = new ArrayList<>();


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
                    node.setButtonText( sc.nextLine() );

                } else if( nextLine.equals("SCENETEXT") ) {			//Got it!
                    int lines = sc.nextInt();
                    for( int i = 0; i <= lines; i++) {
                        sceneText += sc.nextLine();
                        sceneText += "\n";
                    }
                    node.setSceneText(sceneText);

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
        fullTree.add( 0, node );
        return node;
    }

    //Main method is no longer needed simply because that was testing and it works now!
}
