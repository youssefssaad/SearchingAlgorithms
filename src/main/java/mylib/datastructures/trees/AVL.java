package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;

public class AVL extends BST {
    private TNode root;

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val,0,null,null,null);
    }

    public AVL(TNode obj) {
        if (obj == null) {
            this.root = null;
        } else {
            this.root = obj;
            balance(obj);
        }
    }

    public void setRoot(TNode root) {
        this.root = root;
        if (root != null) {
            balance(root);
        }
    }

    public TNode getRoot() {
        return this.root;
    }

    public void balance(TNode node) {
        if (node == null) {
            return;
        }

        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.getLeft()) >= 0) {
                node = rotateRight(node);
            } else {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            node = rotateLeft(node);
        }

        if (node.getParent() != null) {
            if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(node);
            } else {
                node.getParent().setRight(node);
            }
            balance(node.getParent());
        } else {
            root = node;
        }
    }

    public int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }


    public TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    public TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return -1;
        } else {
            return node.getBalance();
        }
    }

    private void updateHeight(TNode node) {
        if (node != null) {
            node.setBalance(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        }
    }

    public void insert(int val) {
        TNode newNode = new TNode(val);
        super.insert(newNode);
        balance(newNode);
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        balance(node);
    }

    @Override
    public void delete(int val) {
        TNode nodeToDelete = search(val);
        if (nodeToDelete == null) {
            System.out.println("Value " + val + " not found in the tree.");
            return;
        }
        TNode parent = nodeToDelete.getParent();
        super.delete(nodeToDelete.getData());
        balance(parent); // balance the tree after deleting the node
    }
}
