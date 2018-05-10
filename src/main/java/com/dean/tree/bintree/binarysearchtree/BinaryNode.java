package com.dean.tree.bintree.binarysearchtree;

import lombok.*;

/**
 * Created by Dean on 2018/5/10.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BinaryNode<T> {

    private T element;

    private BinaryNode<T> left;

    private BinaryNode<T> right;


}
