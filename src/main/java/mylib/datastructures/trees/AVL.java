package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;

public class AVL extends BST {

    private TNode root;

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val);
    }

    public AVL(TNode obj) {
        this.root = obj;
        if (this.root != null) {
            balance(obj);
        }
    }

    public void setRoot(TNode node) {
        this.root = node;
        if (this.root != null) {
            balance(node);
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
            if (getBalanceFactor(node.getRight()) <= 0) {
                node = rotateLeft(node);
            } else {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }

        if (node.getParent() != null) {
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

    public int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    public TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        if (newRoot.getLeft() != null) {
            newRoot.getLeft().setParent(node);
        }
        newRoot.setParent(node.getParent());
        if (node.getParent() == null) {
            root = newRoot;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(newRoot);
        } else {
            node.getParent().setRight(newRoot);
        }
        newRoot.setLeft(node);
        node.setParent(newRoot);
        return newRoot;
    }

    public TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        if (newRoot.getRight() != null) {
            newRoot.getRight().setParent(node);
        }
        newRoot.setParent(node.getParent());
        if (node.getParent() == null) {
            root = newRoot;
        } else if (node == node.getParent().getRight()) {
            node.getParent().setRight(newRoot);
        } else {
            node.getParent().setLeft(newRoot);
        }
        newRoot.setRight(node);
        node.setParent(newRoot);
        return newRoot;
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        balance(node);
    }

    public void insert(int val) {
        TNode newNode = new TNode(val);
        super.insert(newNode);
        balance(newNode);
    }

    public TNode delete(TNode current, int val) {
        if (current == null) {
            System.out.println("Value not found in tree");
            return current;
        }
        if (val < current.getData()) {
            current.setLeft(delete(current.getLeft(), val));
        } else if (val > current.getData()) {
            current.setRight(delete(current.getRight(), val));
        } else {
            // current node is the one to be deleted
            if (current.getLeft() == null && current.getRight() == null) {
                // Case 1: Node has no children
                current = null;
            } else if (current.getLeft() == null || current.getRight() == null) {
                // Case 2: Node has one child
                if (current.getLeft() == null) {
                    current = current.getRight();
                } else {
                    current = current.getLeft();
                }
            } else {
                // Case 3: Node has two children
                TNode temp = minValueNode(current.getRight());
                current.setData(temp.getData());
                current.setRight(delete(current.getRight(), temp.getData()));
            }
        }
    
        if (current == null) {
            return current;
        }
    
        // Rebalance the tree
        balance(current);
    
        return current;
    }

    private TNode minValueNode(TNode node) {
        TNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void delete(int val) {
        root = delete(root, val);
    }
}

