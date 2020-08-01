package com.avocado.algorithms.binarytree;

public class Node {
    public int Id;
    private NodeData _data;
    private Node _parent;
    private Node _left;
    private Node _right;

    public Node(int id, Node parent){
        Id = id;
        _data = new NodeData();
        _parent = parent;
    }

    public Node(int id, NodeData data, Node parent){
        Id = id;
        _data = data;
        _parent = parent;
    }

    public Node GetParent(){
        return _parent;
    }

    public void SetParent(Node parent){
        _parent = parent;
    }

    public Node GetLeft(){
        return _left;
    }

    public Node GetRight(){
        return _right;
    }

    public void SetLeft(Node node){
        _left = node;
        _left.SetParent(this);
    }

    public void SetRight(Node node){
        _right = node;
        _right.SetParent(this);
    }

    public void SetChild(Node child, boolean left){
        if(left){
            SetLeft(child);
        }else{
            SetRight(child);
        }
    }

    public Node GetChild(boolean left){
        if(left){
            return GetLeft();
        }else{
            return GetRight();
        }
    }

    public void RemoveChild(Node node){
        if(node == _left){
            _left = null;
        }else if(node == _right){
            _right = null;
        }
    }

    public boolean IsLeaf(){
        return _left == null && _right == null;
    }

    public boolean IsLeft(){
        return _parent.GetLeft() == this;
    }

    public int ChildAmount(){
        var amount = 0;
        if(_left != null){
            amount++;
        }
        if(_right != null){
            amount++;
        }

        return amount;
    }

    public void DisplayNode(){

    }

    public NodeData GetData(){
        return _data;
    }
}
