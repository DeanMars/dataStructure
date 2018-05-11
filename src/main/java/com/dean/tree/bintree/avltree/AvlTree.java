package com.dean.tree.bintree.avltree;

/**
 * Created by Dean on 2018/5/10.
 */
public class AvlTree<T extends Comparable> {

    private AvlNode<T> root;

    public int height(AvlNode node){
        return node==null?-1:node.getHeight();
    }

    public AvlNode<T> findMin(){
        return findMin(root);
    }

    public AvlNode<T> insert(T t){
        return root=insert(t,root);
    }

    public AvlNode<T> remove(T t){
        return remove(t,root);
    }

    public AvlNode<T> remove(T t,AvlNode node){
        if(node==null) return null;
        int result=t.compareTo(node.getElement());
        if(result<0){
            node.setLeft(remove(t,node.getLeft()));
            if(height(node.getLeft())-height(node.getRight())==2){
                if(t.compareTo(node.getLeft().getElement())<0){
                    node=rotateWithLeftChild(node);
                }else{
                    node=doubleWithLeftChild(node);
                }
            }
        }else if(result>0){
            node.setRight(remove(t,node.getRight()));
            if(height(node.getRight())-height(node.getLeft())==2){
                if(t.compareTo(node.getRight().getElement())>0){
                    node=rotateWithRightChild(node);
                }else{
                    node=doubleWithRightChild(node);
                }
            }
        }else{
            if(node.getRight()!=null&&node.getLeft()!=null){
                AvlNode<T> minNode=findMin(node.getRight());
                boolean needRotate=(minNode==node.getRight()&&node.getRight().getRight()==null);
                T min=minNode.getElement();
                node.setElement(min);
                node.setRight(remove(min,node.getRight()));
                if(height(node.getLeft())-height(node.getRight())==2){
                    if(needRotate){
                        rotateWithLeftChild(node);
                    }
                }
            }else{
                //该节点有0个或者1个子节点时
                node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
            }

        }
        if(node!=null) {
            node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        }
        return node;
    }

    public AvlNode<T> insert(T t,AvlNode node){
        if(node==null){
            return new AvlNode<T>(t,null,null);
        }
        int result=t.compareTo(node.getElement());
        if(result<0){
            node.setLeft(insert(t,node.getLeft()));
            if(height(node.getLeft())-height(node.getRight())==2){
                if(t.compareTo(node.getLeft().getElement())<0){
                    node=rotateWithLeftChild(node);
                }else{
                    node=doubleWithLeftChild(node);
                }
            }
        }else if(result>0){
            node.setRight(insert(t,node.getRight()));
            if(height(node.getRight())-height(node.getLeft())==2){
                if(t.compareTo(node.getRight().getElement())>0){
                    node=rotateWithRightChild(node);
                }else{
                    node=doubleWithRightChild(node);
                }
            }
        }
        node.setHeight(Math.max(height(node.getLeft()),height(node.getRight()))+1);
        return node;
    }


    public AvlNode<T> rotateWithLeftChild(AvlNode<T> k2){
        AvlNode k1=k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(height(k2.getLeft()),height(k2.getRight()))+1);
        k1.setHeight(Math.max(height(k1.getLeft()),k2.getHeight())+1);
        return k1;
    }

    public AvlNode<T> rotateWithRightChild(AvlNode<T> k1){
        AvlNode k2=k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setHeight(Math.max(height(k1.getLeft()),height(k1.getRight()))+1);
        k2.setHeight(Math.max(k1.getHeight(),height(k2.getRight()))+1);
        return k2;
    }


    public AvlNode<T> doubleWithLeftChild(AvlNode<T> k3){
        k3.setLeft(rotateWithRightChild(k3.getLeft()));
        return rotateWithLeftChild(k3);
    }


    public AvlNode<T> doubleWithRightChild(AvlNode<T> k1){
        k1.setRight(rotateWithLeftChild(k1.getRight()));
        return rotateWithRightChild(k1);
    }


    public AvlNode<T> findMin(AvlNode node){
        if(node==null) return null;
        if(node.getLeft()!=null) {
            return findMin(node.getLeft());
        }else{
            return node;
        }
    }


    public void print(){
        print(root);
    }

    private void print(AvlNode node){
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




}
