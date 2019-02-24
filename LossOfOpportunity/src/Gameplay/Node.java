package Gameplay;

public class Node {

    Node[] children;
    Integer choice;     //used for save data
    String buttonText;        //used when the user is making a choice
    String sceneText; //because the choice happens, here's what we do
    Integer day;        //Not super important but good data to have anyway
    boolean added = false;

    //Constructor
    public Node(String text, String consequence, Integer day){
        this.buttonText = text;
        this.sceneText = consequence;
        this.day = day;
    }

    public Node() {
    }

    public void setChoice( int n ) {
        this.choice = n;
    }

    public void setButtonText(String t) {
        this.buttonText = t;
    }

    public void setSceneText(String c ) {
        this.sceneText = c;
    }
    public void setDay(Integer day) {
        this.day = day;
    }

    public void setChildren(Node[] childs ){
        children = new Node[childs.length];
        for( int i = 0; i < childs.length; i++ ){
            children[i] = childs[i];
        }
    }

    //Basic you make the choice thing
    public Integer getChoice(){
        return choice;
    }
    public String getSceneText(){
        return sceneText;
    }
    public String getButtonText(){
        return buttonText;
    }

    //Moving on to make another choice
    public Node getChild(int index){
        return children[index];
    }




}
