package co.com.challenge;

import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Node {

    private String category;

    private Node parentNode;

    private List<String> keyWords;

    private final List<Node> subNodes = new ArrayList();


    @Override
    public String toString(){
        return "Category: " + this.category  + ", keyworkds: " +  this.keyWords==null?keyWords.toString():""  + ", Nodes: " + subNodes.toString() ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Node))
            return false;

        Node other = (Node)o;
        boolean CategoryEquals = (this.category == null && other.category == null)
                || (this.category != null && this.category.equals(other.category));

        return this.parentNode == other.parentNode && CategoryEquals;
    }


}
