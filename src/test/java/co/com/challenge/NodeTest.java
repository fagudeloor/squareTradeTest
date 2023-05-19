package co.com.challenge;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class NodeTest extends TestCase {


    @Test
    public void test1(){
        Node myNode = new Node()
            .builder()
            .category("Home")
            .keyWords(Arrays.asList(new String[]{"kitchen", "bedRoom", "livingRoom", "backyard"}))
            .build();

        System.out.println(myNode.toString());
        assertNotNull(myNode);
    }





}