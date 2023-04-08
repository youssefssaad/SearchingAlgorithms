package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;
//so TNode has root as parent so we can choose to use root as parent or not    
public class AVL extends BST {

    private mylib.datastructures.nodes.TNode root;     //references the root of the tree

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val);
    }

    private void AVLTree(TNode node) {
        this.root = node;
        if (this.root != null) {
            balance();
        }
    }

    public AVLTree(TNode obj) {
        AVLTree(obj);
    }

    public void setRoot(TNode node) {
        AVLTree(node);
    }

    public TNode getRoot() {
        return this.root;
    }

    private void balance(TNode node) {
        if (node == null) {
            return;
        }
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            // left heavy subtree
            if (getBalanceFactor(node.left) < 0) {
                // left-right case
                node.left = rotateLeft(node.left);
            }
            // left-left case
            node = rotateRight(node);
        } else if (balanceFactor < -1) {
            // right heavy subtree
            if (getBalanceFactor(node.right) > 0) {
                // right-left case
                node.right = rotateRight(node.right);
            }
            // right-right case
            node = rotateLeft(node);
        }
        if (node.parent != null) {
            balance(node.parent);
        } else {
            root = node;
        }
    }

    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.right;
        node.right = newRoot.left;
        if (newRoot.left != null) {
            newRoot.left.parent = node;
        }
        newRoot.parent = node.parent;
        if (node.parent == null) {
            root = newRoot;
        } else if (node == node.parent.left) {
            node.parent.left = newRoot;
        } else {
            node.parent.right = newRoot;
        }
        newRoot.left = node;
        node.parent = newRoot;
        return newRoot;
    }

    private TNode rotateRight(TNode node) {
        TNode newRoot = node.left;
        node.left = newRoot.right;
        if (newRoot.right != null) {
            newRoot.right.parent = node;
        }
        newRoot.parent = node.parent;
        if (node.parent == null) {
            root = newRoot;
        } else if (node == node.parent.right) {
            node.parent.right = newRoot;
        } else {
            node.parent.left = newRoot;
        }
        newRoot.right = node;
        node.parent = newRoot;
        return newRoot;
    }

    @Override
    public void insert(int val) {
        TNode newNode = new TNode(val);
        super.insert(newNode);
        balance();
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        balance();
    }

    private TNode delete(TNode current, int val) {
        if (current == null) {
            System.out.println(val + " is not found in the tree");
            return current;
        }

        if (val < current.data) {
            current.left = delete(current.left, val);
        } else if (val > current.data) {
            current.right = delete(current.right, val);
        } else {
            if (current.left == null || current.right == null) {
                TNode temp = null;
                if (temp == current.left) {
                    temp = current.right;
                } else {
                    temp = current.left;
                }

                if (temp == null) {
                    temp = current;
                    current = null;
                } else {
                    current = temp;
                }
            } else {
                TNode temp = minValueNode(current.right);
                current.data = temp.data;
                current.right = delete(current.right, temp.data);
            }
        }

        if (current == null) {
            return current;
        }

        // Update the height of the current node
        current.height = Math.max(height(current.left), height(current.right)) + 1;

        // Rebalance the tree
        int balanceFactor = getBalanceFactor(current);

        if (balanceFactor > 1 && getBalanceFactor(current.left) >= 0) {
            return rotateRight(current);
        }

        if (balanceFactor > 1 && getBalanceFactor(current.left) < 0) {
            current.left = rotateLeft(current.left);
            return rotateRight(current);
        }

        if (balanceFactor < -1 && getBalanceFactor(current.right) <= 0) {
            return rotateLeft(current);
        }

        if (balanceFactor < -1 && getBalanceFactor(current.right) > 0) {
            current.right = rotateRight(current.right);
            return rotateLeft(current);
        }

        return current;
    }

    private TNode minValueNode(TNode node) {
        TNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void delete(int val) {
        root = delete(root, val);
    }
