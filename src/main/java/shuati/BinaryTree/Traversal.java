package shuati.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Traversal {

    public static void main(String[] args) {
       Traversal traversal = new Traversal();
        BinaryTree b = traversal.addNode().get(0);
        traversal.O(b);
        int[] i = {1,2,3};
        System.out.println(i.length);

    }


    //输入二叉树
    public List<BinaryTree> addNode() {
        List<BinaryTree> list = new ArrayList<>();

        BinaryTree binaryTree = new BinaryTree(1);

        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);

        list.add(binaryTree);

        return list;
    }

    //输出二叉树
    public void O(BinaryTree b) {
        if(b != null){
            System.out.println(b.data);
            this.O(b.left);
            this.O(b.right);
        }

    }
}
