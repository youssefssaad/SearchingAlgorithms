package mylib.datastructures.trees;

public class AVL extends BST {

    public AVL() {
        this.root = null;
    }

    public AVL(int val) {
        this.root = new TNode(val);
    }

    public AVL(TNode obj) {
        this.root = obj;
        if (this.root != null) {
            balance();
        }
    }

    private AVL(){}

    public void setRoot(TNode node) {
        this.root = node;
        if (this.root != null) {
            balance();
        }
    }

    public TNode getRoot() {
        return this.root;
    }

    private void balance(){}



    @Override
    public void insert(int val) {
        super.insert(val);
        balance();
    }

    @Override
    public void insert(TNode node) {
        super.insert(node);
        balance();
    }

    public void delete(int val) {
        this.root = delete(this.root, val);
        balance();
    }

    public TNode Search(int val){}

    public String printInOrder(){}

    public String printBF(){}
