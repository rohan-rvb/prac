package org.example.prac.syntax;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StreamChecker {
    private Trie root;
    private String st;
    public StreamChecker(String[] arr) {
        this.root = new Trie();
        st = "";
        int n=arr.length;
        for(int i=0;i < n;i++) {

            insert(arr[i]);
        }
    }

    public boolean query(char letter) {
        st = st.concat(String.valueOf(letter));
        // System.out.println("searcing "+st);
        return search(st);
    }

    public boolean search(String str) {
        int n=str.length();
        Trie curr = this.root;
        for(int i=n-1;i>=0;i--) {
            if(curr.isEnd()) {
                return true;
            }
            int ind = str.charAt(i)-'a';
            if(curr.list.get(ind)!= null) {
                curr = curr.list.get(ind);
            } else {
                return false;
            }
            if(curr.isEnd()) {
                return true;
            }
        }

        return curr.isEnd() == true;
    }

    public void insert(String str) {
        Trie curr = this.root;
        int n=str.length();
        for(int i=n-1;i>=0;i--) {
            int ind = str.charAt(i)-'a';
            if(curr.list.get(ind) != null) {
                curr = curr.list.get(ind);
            } else {
                Trie newNode = new Trie();
                if(i==0) {
                    newNode.end = true;
                }
                curr.list.set(ind, newNode);
                curr = newNode;
            }
        }
        curr.end = true;
    }
}

class Trie {
    List<Trie> list;
    public boolean end;
    public Trie() {
        this.list = new ArrayList<>();
        for(int i=0;i<26;i++) {
            this.list.add(null);
        }
        this.end = false;
    }

    public boolean isEnd() {
        return this.end;
    }
}
