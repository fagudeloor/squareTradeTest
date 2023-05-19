package co.com.challenge;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class NodesTest extends TestCase {


    @Test
    public void testGetLevelFromRoot(){
        Node mainNode = FabricStructureNodes.getStructure();
        Node nodeTest = mainNode.getSubNodes().get(0).getSubNodes().get(0);
        System.out.println(nodeTest.equals(nodeTest));
        Integer levelNode = Nodes.getLevelFromRoot(mainNode, nodeTest);
        assertEquals(2, levelNode!=null?levelNode:0);
    }

    @Test
    public void testGetAllKeyWords() {
        Node mainNode = FabricStructureNodes.getStructure();
        Node nodeTest = mainNode.getSubNodes().get(0).getSubNodes().get(0);
        List allKeyWords = Nodes.getAllKeyWords(nodeTest);
        allKeyWords.forEach(e -> {
            System.out.print(e + ", ");
        });

        assertEquals(7, allKeyWords.size());
    }

    @Test
    public void testAddLevel(){
        Node mainNode = FabricStructureNodes.getMainNode();
        FabricStructureNodes.addNodesFirstLevel(mainNode);
        assertNotNull(mainNode.getSubNodes().get(0));

    }
    //getting level in any node
    @Test
    public void testGetLevelNode() {
        Node mainNode = FabricStructureNodes.getStructure();
        Node nodeTest = mainNode.getSubNodes().get(0).getSubNodes().get(0);
        Integer levelNode = Nodes.getLevelNode(nodeTest);
        assertEquals(2, levelNode!=null?levelNode:0);
    }

    /**
     * This inner class is developed with porpoueses of build the whole structure of nodes to make tests
     */
    public static class FabricStructureNodes {


        public static Node getStructure(){
            Node mainNode = getMainNode();
            addNodesFirstLevel(mainNode);
            if(mainNode.getSubNodes()!=null && mainNode.getSubNodes().get(0) !=null && !mainNode.getSubNodes().isEmpty())
                addNodesSecondLevel(mainNode.getSubNodes().get(0));
            return mainNode;
        }


        //Building main node
        public static Node getMainNode(){
            Node myNode = new Node()
                    .builder()
                    .category("Home")
                    .keyWords(Arrays.asList(new String[]{"kitchen", "bedRoom", "livingRoom", "backyard"}))
                    .build();
            System.out.println(myNode.getCategory());
            return myNode;
        }

        //Adding first level of nodes
        public static void addNodesFirstLevel(Node myNode){
            Node table = new Node().builder().category("Table").keyWords(Arrays.asList(new String[]{"study", "desktop", "setup"})).build();
            Nodes.addingNodes(myNode, table);
            Node sofa = new Node().builder().category("sofa").keyWords(Arrays.asList(new String[]{"rest", "tv", "bed"})).build();
            Nodes.addingNodes(myNode, sofa);
        }

        //Adding second level
        public static void addNodesSecondLevel(Node table){
            Node woodTable = new Node().builder().category("wood").keyWords(Arrays.asList(new String[]{})).build();
            Nodes.addingNodes(table, woodTable);
//            table.getSubNodes().forEach( l -> {
//                System.out.println("table, right node: " + l.getCategory());
//            });
//            System.out.println("table parent " + table.getParentNode());
//        System.out.println(myNode.getRightNode().getRightNode().getCategory());
        }

    }



}