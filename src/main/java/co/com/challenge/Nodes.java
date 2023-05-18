package co.com.challenge;


public class Nodes {


    //This method get a specific node and return the level, it means parents objects
    public static Integer getLevelNode(Node node){
        return computingLevelNode(node, 0);
    }


    //this method compute with recursivity the level node and is used for getLevelNode
    private static Integer computingLevelNode(Node node, Integer level){

        if (null!=node.getParentNode() && !node.getParentNode().equals("")){
            System.out.println(node.getParentNode());
            Node parentNode = node.getParentNode();
            level = computingLevelNode(parentNode, ++level);
        }
        return level;
    }


    public static void addingNodes(Node rootNode, Node newNode, int side) {
        if (side==0){
            newNode.setParentNode(rootNode);
            rootNode.setRightNode(newNode);

        }else if (side==1) {
            newNode.setParentNode(rootNode);
            rootNode.setLeftNode(newNode);
        }else{
            throw new IllegalArgumentException();
        }
    }
}
