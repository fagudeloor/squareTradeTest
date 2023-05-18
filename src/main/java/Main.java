import co.com.challenge.Node;
import co.com.challenge.Nodes;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        Node myNode = buildNode();
        System.out.println(myNode.toString());

        //Adding first level of nodes
        Node table = new Node().builder().category("Table").keyWords(Arrays.asList(new String[]{"study", "desktop", "setup"})).build();
        Nodes.addingNodes(myNode, table, 0);
        Node sofa = new Node().builder().category("sofa").keyWords(Arrays.asList(new String[]{"rest", "tv", "bed"})).build();
        Nodes.addingNodes(myNode, sofa, 1);

        //Adding second level
        Node woodTable = new Node().builder().category("wood").keyWords(Arrays.asList(new String[]{})).build();
        Nodes.addingNodes(table, woodTable, 0);
        System.out.println("table, right node: " + table.getRightNode());
        System.out.println("table parent " + table.getParentNode());
        System.out.println(myNode.getRightNode().getRightNode().getCategory());


        //getting level in any node
        Integer levelNode = Nodes.getLevelNode(woodTable);
        System.out.println("The level of woodTable is: " + levelNode);

        //Getting parent categories
        System.out.println("key words in woodTable: " + woodTable.getParentNode().getKeyWords());


//        System.out.println(myNode.getLeftNode().toString());
//        System.out.println(myNode.getRightNode().toString());
//
//        if (myNode.getRightNode().getLeftNode()==null){
//            System.out.println("Last object");
//        }

    }


    public static Node buildNode() {
        Node myNode = new Node()
                .builder()
                .category("Home")
                .keyWords(Arrays.asList(new String[]{"kitchen", "bedRoom", "livingRoom", "backyard"}))
                .build();

        System.out.println(myNode.toString());
//        assertNotNull(myNode);
        return myNode;
    }
}

