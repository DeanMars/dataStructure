package com.dean.tree.bintree.redblacktree;

/**
 * Created by Dean on 2018/5/11.
 */
public class RedBlackTree<T extends Comparable> {

    private RedBlackNode<T> header=null;

    private RedBlackNode<T> nullNode=null;

    private RedBlackNode<T> grand;
    private RedBlackNode<T> parent;
    private RedBlackNode<T> current;
    private RedBlackNode<T> great;


    public RedBlackTree() {
        nullNode=new RedBlackNode<T>(null);
        nullNode.setLeft(nullNode);
        nullNode.setRight(nullNode);
        header=new RedBlackNode<T>(null);
        header.setLeft(nullNode);
        header.setRight(nullNode);
    }

    public void insert(T t){
        grand=parent=current=header;
        nullNode.setElement(t);
        while (compare(t,current)!=0){
            great=grand;
            grand=parent;
            parent=current;
            int compareResult=compare(t,current);
            if(compareResult<0){
                current=current.getLeft();
            }else{
                current=current.getRight();
            }
            if(current.getLeft().isBlack()==false&&current.getRight().isBlack()==false){
                handleReorient(t);
            }
        }
        if(current!=nullNode){
            return;
        }
        current=new RedBlackNode<T>(t,nullNode,nullNode);
        if(compare(t,parent)<0){
            parent.setLeft(current);
        }else{
            parent.setRight(current);
        }
        handleReorient(t);
    }


    public int compare(T t,RedBlackNode node){
        if(node==header){
            return 1;
        }else {
            return t.compareTo(node);
        }
    }




    public void handleReorient(T t){
        current.setBlack(false);
        current.getLeft().setBlack(true);
        current.getRight().setBlack(true);
        if(!parent.isBlack()){
            grand.setBlack(false);
            if(compare(t,grand)<0 !=compare(t,parent)<0){

            }

        }



    }




}
