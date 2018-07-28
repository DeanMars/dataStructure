package com.dean.tree.bintree.redblacktree;

import lombok.Data;

/**
 * Created by Dean on 2018/5/11.
 */
@Data
public class RedBlackNode<T extends Comparable> {

    private T element;

    private boolean isBlack;

    private RedBlackNode<T> left;

    private RedBlackNode<T> right;

    public RedBlackNode(T element, RedBlackNode<T> left, RedBlackNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public RedBlackNode(T element) {
        this.element = element;
    }
}
