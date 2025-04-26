package com.simran.dsa.Trie;

public class DesignAddAndSearchWordDictionary {
    public static class Node {
        Node[] children;
        boolean eow;

        public Node(){
            this.children = new Node[26];
            for(int i = 0 ; i < 26 ; i++) {
                children[i] = null;
            }
        }
    }
    static Node root;
    public static void main(String[] args) {
        root = new Node();
        addWord("day");
        addWord("bay");
        addWord("may");
        addWord("word");
        System.out.println(search("say"));
        System.out.println(search("day"));
        System.out.println(search(".ay"));
        System.out.println(search("b.."));

    }

    public static void addWord(String word) {
        Node curr = root;
        for(int i = 0 ; i < word.length() ; i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word) {
        return searchInNode(word , 0 , root);
    }

    public static boolean searchInNode(String word , int index , Node curr) {
        if(index == word.length()) {
            return curr.eow;
        }

        char c = word.charAt(index);
        if(c == '.') {
            for(Node child: curr.children) {
                if(child != null && searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return true;
        } else {
            int idx = c - 'a';
            Node child = curr.children[idx];
            if(child == null) return false;
            return searchInNode(word, index + 1, child);
        }
    }
}
