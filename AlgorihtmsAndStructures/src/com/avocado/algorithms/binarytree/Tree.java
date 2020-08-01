package com.avocado.algorithms.binarytree;

public class Tree {
    private Node _root;

    public Node GetRoot(){
        return _root;
    }

    public Node Find(int id){
        var currentNode = _root;
        while (currentNode.Id != id){
            if(IsLeftNode(id, currentNode)){
                currentNode = _root.GetLeft();
            }else{
                currentNode = _root.GetRight();
            }

            if(currentNode == null){
                return null;
            }
        }

        return currentNode;
    }

    public void Insert(int id, NodeData data){
        if(_root == null){
            _root = new Node(id, data, null);
        }else{
            var current = _root;
            Node parent = null;
            while (true){
                parent = current;
                var left = IsLeftNode(id, current);
                current = left ? current.GetLeft() : current.GetRight();
                if(current == null){
                    parent.SetChild(new Node(id, data, parent), left);
                    return;
                }
            }
        }
    }

    public void InOrder(Node localRoot){
        if(localRoot == null){
            return;
        }

        System.out.println("Do something in " + localRoot.Id);

        InOrder(localRoot.GetLeft());
        InOrder(localRoot.GetRight());
    }

    public void Delete(int id){
        var node = Find(id);
        if(node.IsLeaf()){
            if(node == _root){
                _root = null;
            }else{
                node.GetParent().RemoveChild(node);
            }
        }else if(node.ChildAmount() == 1){
            var left = node.GetLeft() != null;
            if(node == _root){
                _root = node.GetChild(left);
            }else{
                node.GetParent().SetChild(node.GetChild(left), left);
            }
        }else{
            var successor = GetSuccessor(node);
            var parent = node.GetParent();
            parent.SetChild(successor, node.IsLeft());
            successor.SetLeft(node.GetLeft());
            if(successor != node.GetRight()){
                successor.GetParent().SetLeft(successor.GetRight());
                successor.SetRight(node.GetRight());
            }
        }
    }

    public Node GetMin(Node localRoot){
        return GetLeaf(localRoot, true);
    }

    public Node GetMax(Node localRoot){
        return GetLeaf(localRoot, false);
    }

    private Node GetLeaf(Node localRoot, boolean left){
        var node = left ? localRoot.GetLeft() : localRoot.GetRight();
        if(node == null){
            return localRoot;
        }

        return GetLeaf(node, left);
    }

    private boolean IsLeftNode(int id, Node root){
        return id < root.Id;
    }

    private Node GetSuccessor(Node node){
        var successor = node.GetRight();
        if(successor == null){
            return null;
        }

        var current = successor;
        while (current != null){
            successor = current;
            current = successor.GetLeft();
        }

        return successor;
    }
}
