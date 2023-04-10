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

    private void balance(TNode node) {
        if (node == null) {
            return;
        }
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            // left heavy subtree
            if (getBalanceFactor(node.getLeft()) < 0) {
                // left-right case
                node.setLeft(rotateLeft(node.getLeft()));
            }
            // left-left case
            node = rotateRight(node);
        } else if (balanceFactor < -1) {
            // right heavy subtree
            if (getBalanceFactor(node.getRight()) > 0) {
                // right-left case
                node.setRight(rotateRight(node.getRight()));
            }
            // right-right case
            node = rotateLeft(node);
        }
        if (node.getParent() != null) {
            balance(node.getParent());
        } else {
            root = node;
        }
    }

    private int getBalanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }

    private int getHeight(TNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }

    private TNode rotateLeft(TNode node) {
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

    private TNode rotateRight(TNode node) {
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

    private TNode delete(TNode current, int val) {
        if (val < current.getData()) {
            current.setLeft(delete(current.getLeft(), val));
        } else if (val > current.getData()) {
            current.setRight(delete(current.getRight(), val));
        } else if (val == current.getData()){
            if (current.getLeft() == null || current.getRight() == null) {
                TNode temp = null;
                if (temp == current.getLeft()) {
                    temp = current.getRight();
                } else {
                    temp = current.getLeft();
                }

                if (temp == null) {
                    temp = current;
                    current = null;
                } else {
                    current = temp;
                }
            } else {
                TNode temp = minValueNode(current.getRight());
                current.setData(temp.getData());
                current.setRight(delete(current.getRight(), temp.getData()));
            }
        } else {
            System.out.println("Value not found in tree");
            return current;
        }

        if (current == null) {
            System.out.println("Tree is empty");
            return current;
        }

        // Rebalance the tree
        int balanceFactor = getBalanceFactor(current);

        if (balanceFactor > 1 && getBalanceFactor(current.getLeft()) >= 0) {
            return rotateRight(current);
        }

        if (balanceFactor > 1 && getBalanceFactor(current.getLeft()) < 0) {
            current.setLeft(rotateLeft(current.getLeft()));
            return rotateRight(current);
        }

        if (balanceFactor < -1 && getBalanceFactor(current.getRight()) <= 0) {
            return rotateLeft(current);
        }

        if (balanceFactor < -1 && getBalanceFactor(current.getRight()) > 0) {
            current.setRight(rotateRight(current.getRight()));
            return rotateLeft(current);
        }

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
