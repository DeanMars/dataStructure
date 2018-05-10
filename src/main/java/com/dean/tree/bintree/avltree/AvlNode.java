package com.dean.tree.bintree.avltree;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Dean on 2018/5/10.
 */
@Data
@AllArgsConstructor
public class AvlNode<T extends Comparable> {

    private T element;

    private AvlNode<T> left;

    private AvlNode<T> right;

    private int height;

    public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
