package Gameplay;

public class Node {

    Node[] children;
    Integer choice; //used for save data
    String text; //used when the user is making a choice
    String consequence; //because the choice happens, here's what we do
    Integer day; //Not super important but good data to have anyway
    boolean added = false;

    //Constructor
    public Node(String text, String consequence, Integer day){
        this.text = text;
        this.consequence = consequence;
        this.day = day;
    }

    public void setChildren( Node[] childs ){
        children = new Node[childs.length];
        for( int i = 0; i < childs.length; i++ ){
            children[i] = childs[i];
        }
    }

    //Basic you make the choice thing
    public Integer getChoice(){
        return choice;
    }
    public String getConsequence(){
        return consequence;
    }
    public String getText(){
        return text;
    }

    //Moving on to make another choice
    public Node getChild(int index){
        return children[index];
    }

}