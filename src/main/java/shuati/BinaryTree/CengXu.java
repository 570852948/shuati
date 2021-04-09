package shuati.BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class CengXu {
    static class Tree{
        int data;
        Tree left;
        Tree right;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.data = 0;
        tree.left = new Tree();
        tree.left.data = 1;
        tree.right = new Tree();
        tree.right.data = 2;
        bianLi(tree);
    }


    public static void bianLi(Tree tree) {
        LinkedList<Tree> queue = new LinkedList<>();
        Tree everyLastFlag;
        Tree currentTree;
        queue.add(tree);
        while (!queue.isEmpty()) {
            everyLastFlag = queue.getLast();
//            while(true){
                //如果队列中最后一个树节点左子树不为空则插入队列
                if (queue.getFirst().left != null)
                    queue.add(queue.getFirst().left);
                //如果队列中最后一个树节点右子树不为空则插入队列
                if (queue.getFirst().right != null)
                    queue.add(queue.getFirst().right);
                //currentTree = queue.pollFirst();
                //取出队列中最后一个也就是最先进去的
                System.out.println(queue.pollFirst().data);
                //如果到达每层的最后一个节点跳出内循环
//                if (currentTree == everyLastFlag) {
//                    break;
//                }
//            }

        }
    }
}
