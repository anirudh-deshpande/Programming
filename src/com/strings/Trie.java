package com.strings;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private class TrieNode{
		
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode(){
			children = new HashMap<>();
			endOfWord = false;
		}
		
	}
	
	private final TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	
	public void insert(String word){
		
		TrieNode cur = root;
		for(int i = 0; i < word.length(); i++){
			
			char ch = word.charAt(i);
			TrieNode present = cur.children.get(ch);
			
			if(present == null){
				present = new TrieNode();
				cur.children.put(ch, present);
			}
			cur = present;
		}
		
		cur.endOfWord = true;
	}
	
	public boolean search(String word){
		
		TrieNode cur = root;
		for(int i = 0; i < word.length(); i++){
			
			char ch = word.charAt(i);
			TrieNode present = cur.children.get(ch);
			
			if(present == null){
				return false;
			}
			
			cur = present;
		}
		
		return cur.endOfWord;
		
	}
	
	public boolean delete(String word){
		return this.delete(root, word, 0);
	}
	
	public boolean delete(TrieNode cur, String word, int index){
		
		if(index == word.length()){
			cur.endOfWord = false;
			return cur.children.size() == 0;
		}
		
		char ch = word.charAt(index);
		TrieNode present = cur.children.get(ch);
		
		if(present == null){
			return false;
		}
		
		boolean shouldDeletePresentNode = delete(present, word, index + 1);
		
		if(shouldDeletePresentNode){
			cur.children.remove(ch);
			return cur.children.size() == 0;
		}
		
		return false;
	}
	
	public static void main(String[] args){
		Trie trie = new Trie();
		trie.insert("abacd");
		trie.insert("abace");
		
		System.out.println(trie.search("abacd"));
		System.out.println(trie.delete("abacd"));
		System.out.println(trie.search("abacd"));
	}

}
