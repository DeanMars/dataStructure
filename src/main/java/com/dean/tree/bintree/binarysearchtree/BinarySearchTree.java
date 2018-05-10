package com.dean.tree.bintree.binarysearchtree;

/**
 * Created by Dean on 2018/5/10.
 */
public class BinarySearchTree<T extends Comparable> {

    private BinaryNode<T> root;


    public boolean contains(T t){
        return contains(t,root);
    }

    public T findMin(){
        return findMin(root)==null?null:findMin(root).getElement();
    }

    public T findMax(){
        return findMax(root)==null?null:findMax(root).getElement();
    }

    public  BinaryNode<T> insert(T t){
        return root=insert(t,root);
    }


    public  BinaryNode<T> remove(T t){
        return root=remove(t,root);
    }

    public  BinaryNode<T> remove(T t,BinaryNode<T> node){
        if(node==null) return null;
        int result=t.compareTo(node.getElement());
        if(result<0){
            node.setLeft(remove(t,node.getLeft()));
        }else if(result>0){
            node.setRight(remove(t,node.getRight()));
        }else{
            //找到需要删除的节点
            //该节点有两个子节点，用右子树的最小左节点的值替换该节点，再删除右子树的最小左节点的值。
            if(node.getLeft()!=null&&node.getRight()!=null){
                T min=findMin(node.getRight()).getElement();
                node.setElement(min);
                node.setRight(remove(min,node.getRight()));
            }else {
                //该节点有0个活1个子节点时
                node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
            }
        }
        return node;
    }

    public  BinaryNode<T> insert(T t,BinaryNode<T> node){
        if(node==null){
            node= new BinaryNode(t,null,null);
        }
        int result=t.compareTo(node.getElement());
        if(result<0){
            node.setLeft(insert(t,node.getLeft()));
        }else if(result>0){
            node.setRight(insert(t,node.getRight()));
        }
        return node;
    }



    private boolean contains(T t,BinaryNode<T> node){
        if(node==null) return false;
        int result=t.compareTo(node.getElement());
        if(result==0){
            return true;
        }else if(result<0){
            return contains(t,node.getLeft());
        }else if(result>0){
            return contains(t,node.getRight());
        }
        return false;
    }

    private BinaryNode<T> findMin(BinaryNode<T> node){
        if(node==null){
            return null;
        }
        if(node.getLeft()==null){
            return node;
        }else {
            return findMin(node.getLeft());
        }
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if(node==null){
            return null;
        }
        if(node.getRight()==null){
            return node;
        }else {
            return findMax(node.getRight());
        }
    }

    public void print(){
        print(root);
    }

    private void print(BinaryNode node){
        System.out.println(node==null?null:node.getElement());
        if(node!=null) {
            if(node.getLeft()!=null||node.getRight()!=null) {
                System.out.print(node.getLeft()==null?null:node.getLeft().getElement());
                System.out.print("-");
                System.out.println(node.getRight()==null?null:node.getRight().getElement());
            }
            if(node.getLeft()!=null) {
                print(node.getLeft());
            }
            if(node.getRight()!=null) {
                print(node.getRight());
            }
        }
    }


   public static void main(String []args){
       BinarySearchTree<Integer> tree=new BinarySearchTree();
       tree.insert(6);
       tree.insert(2);
       tree.insert(8);
       tree.insert(1);
       tree.insert(5);
       tree.insert(3);
       tree.insert(4);


       tree.print();
/*
       System.out.println("---------------------");
       System.out.println("-findMin----"+tree.findMin());
       System.out.println("-findMax----"+tree.findMax());
       System.out.println("---------------------");

       System.out.println("-findMin--3-"+tree.contains(3));
       System.out.println("-findMin--11-"+tree.contains(11));
*/

       System.out.println("---------------------");

       //一个子节点删除
       //tree.remove(3);
       tree.remove(2);
       tree.print();




   }


}
