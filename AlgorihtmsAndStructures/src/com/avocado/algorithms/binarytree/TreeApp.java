package com.avocado.algorithms.binarytree;

public class TreeApp {
    private Tree _tree;

    public void Run(){
        _tree = new Tree();
        _tree.Insert(50, new NodeData());
        _tree.Insert(75, new NodeData());
        _tree.Insert(10, new NodeData());
        _tree.Insert(125, new NodeData());
        _tree.Insert(15, new NodeData());
        _tree.Insert(5, new NodeData());

        var min = _tree.GetMin(_tree.GetRoot());
        var max = _tree.GetMax(_tree.GetRoot());
        System.out.println(min.Id + "; " + max.Id);
    }
}
