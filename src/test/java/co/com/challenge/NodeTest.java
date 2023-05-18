package co.com.challenge;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

//@RunWith(JUnitPlatform.class)
public class NodeTest extends TestCase {


    @Test
    public void buildNode() {
        Node myNode = new Node()
                .builder()
                .category("Home")
                .keyWords(Arrays.asList(new String[]{"kitchen", "bedRoom", "livingRoom", "backyard"}))
                .build();

        System.out.println(myNode.toString());
        assertNotNull(myNode);
    }


}