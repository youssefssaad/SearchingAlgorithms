package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;

public class AVL extends BST {
    private TNode root;

    /**
     * Default constructor
     */
    public AVL() {
        this.root = null;
    }

    /**
     * Overload constructor
     * @param val
     */
    public AVL(int val) {
        this.root = new TNode(val,0,null,null,null);
    }

    /**
     * Overload constructor
     * @param obj
     */
    public AVL(TNode obj) {
        if (obj == null) {
            this.root = null;
        } else {
            this.root = obj;
            balance(obj);
        }
    }

    /**
     * set the root of the tree
     */
    public void setRoot(TNode root) {
        this.root = root;
        if (root != null) {
            balance(root);
        }
    }

    /**
     * get the root of the tree
     */
    public TNode getRoot() {
        return this.root;
    }

    /**
     * balance the tree
     * @param node
     */
    private void balance(TNode node) {
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

    /**
     * get the balance factor of a node
     * @param node
     * @return the balance factor
     */
    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    /**
     * rotate the tree to the left
     * @param node
     * @return the new root
     */
    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    /**
     * rotate the tree to the right
     * @param node
     * @return the new root
     */
    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }
    
    /**
     * get the height of a node
     * @param node
     * @return the height
     */
    public int getHeight(TNode node) {
        if (node == null) {
            return -1;
        } else {
            return node.getBalance();
        }
    }

    /**
     * update the height of a node
     * @param node
     */
    private void updateHeight(TNode node) {
        if (node != null) {
            node.setBalance(Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1);
        }
    }

    /**
     * insert a node into the tree
     * @param val
     */
    @Override
    public void insert(int val) {
        TNode newNode = new TNode(val);
        super.insert(newNode);
        balance(newNode);
    }

    /**
     * insert a node into the tree
     * @param node
     */
    @Override
    public void insert(TNode node) {
        super.insert(node);
        balance(node);
    }

    /**
     * delete a node from the tree
     * @param val
     */
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
