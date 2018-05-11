package test;

import com.dean.tree.bintree.avltree.AvlTree;
import org.junit.Test;

/**
 * Created by Dean on 2018/5/10.
 */
public class AvlTreeTest {


    @Test
    public void rotateLeftLeft(){
        AvlTree tree=new AvlTree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);
        tree.insert(3);

        tree.print();
        System.out.println("--------------------------------------");

        tree.insert(6);
        tree.print();
    }

    @Test
    public void rotateRightRight(){
        AvlTree tree=new AvlTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);

        tree.print();
        System.out.println("--------------------------------------");

        tree.insert(7);
        tree.print();
    }


    @Test
    public void rotateLeftRight(){
        AvlTree tree=new AvlTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(15);
        tree.insert(7);
        tree.insert(16);
        tree.print();
        System.out.println("--------------------------------------");

        tree.insert(14);
        tree.print();
    }

    @Test
    public void rotateRightLeft(){
        AvlTree tree=new AvlTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(7);
        tree.insert(16);
        tree.print();
        System.out.println("--------------------------------------");

        tree.insert(15);
        tree.print();
    }

    @Test
    public void remove(){
        AvlTree tree=new AvlTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(9);
        tree.insert(7);
        tree.insert(8);
        tree.print();
        System.out.println("--------------------------------------");

        tree.remove(6);
        tree.print();
    }




}
