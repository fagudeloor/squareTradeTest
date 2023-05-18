package co.com.challenge;

import lombok.*;

import java.util.List;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Node {

    private String category;

    private Node parentNode;

    private List<String> keyWords;

    private Node leftNode;

    private Node rightNode;

    @Override
    public String toString(){
        return "Category: " + this.category  + ", keyworkds: " +  this.keyWords==null?keyWords.toString():""  + ", Right node: " +  this.rightNode==null?rightNode.category:"" + ", leftNode: " + this.leftNode==null? getLeftNode().category : "";
    }


}
