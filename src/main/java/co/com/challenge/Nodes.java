package co.com.challenge;


import java.util.ArrayList;
import java.util.List;

public class Nodes {

    //returning the keywords for the node and the parents
    public static List getAllKeyWords(Node node){
        List<String> keyWords = new ArrayList();
        List allKeyWords = getAllKeyWords(node, keyWords);
        return allKeyWords;
    }

    private static List getAllKeyWords(Node node, List<String> keyWords) {
        if (null!=node.getParentNode() && !node.getParentNode().equals("")){
            System.out.println("Parent: " + node.getParentNode());
            Node parentNode = node.getParentNode();
            keyWords.addAll(parentNode.getKeyWords());
            getAllKeyWords(parentNode, keyWords);
        }
        return keyWords;
    }

    //this method get the level of a node starting from the root
    public static int getLevelFromRoot(Node parent, Node child) {
        if (null!=parent.getParentNode() && !parent.getParentNode().equals("")) {
            throw new RuntimeException("The node doesn't exist!!!");
        }
        int level = 0;
        for (Node n: parent.getSubNodes()){
            if(n.equals(child))
                return level;
        }
//        boolean b = parent.getSubNodes().stream().anyMatch(s -> s.getSubNodes().contains(child));

        return computingLevelFromRoot(parent.getSubNodes(), child, 0, false);
    }

    //Use recursive to get the level in a node from this parent
    private static int computingLevelFromRoot(List<Node> parent, Node child, int i, boolean b) {
        if (b)
            return i;
        i++;
        for (Node node : parent) {
            System.out.println("i = " + i + ", " + node.equals(child));
            if (node.equals(child)){
                b = true;
                break;
            }
            return computingLevelFromRoot(node.getSubNodes(), child, i, false);
        }
        return i;
    }


    //This method get a specific node and return the level, it means parents objects
    public static int getLevelNode(Node node){
        return computingLevelNode(node, 0);
    }


    //this method compute with recursivity the level node and is used for getLevelNode
    private static Integer computingLevelNode(Node node, Integer level){

        if (null!=node.getParentNode() && !node.getParentNode().equals("")){
            System.out.println("Parent: " + node.getParentNode());
            Node parentNode = node.getParentNode();
            level = computingLevelNode(parentNode, ++level);
        }
        return level;
    }

    public static void addingNodes(Node rootNode, List<Node> newNodes) {
        newNodes.forEach( n -> {
            n.setParentNode(rootNode);
        });
        rootNode.getSubNodes().addAll(newNodes);

    }

    public static void addingNodes(Node rootNode, Node newNode) {
        newNode.setParentNode(rootNode);
        rootNode.getSubNodes().add(newNode);
    }

    public static void getKeys(Node node){
        List<String> keyWords = node.getKeyWords();
        getKeysRecursive(node, keyWords);
    }

    private static void getKeysRecursive(Node node, List<String> keyWords) {
        if (null!=node.getParentNode() && !node.getParentNode().equals("")){
            keyWords.addAll(node.getParentNode().getKeyWords());
        }
    }

}
