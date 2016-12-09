package com.trees;

public class TreesWorkshop {

	public class TreeNode{
		int key;
		TreeNode leftChild;
		TreeNode rightChild;
		
		public TreeNode(int key){
			this.key = key;
		}
	}
	
	TreeNode root;

	public void addNode(int key){		
		TreeNode newNode = new TreeNode(key);
		if(root == null){
			root = newNode;
			return;
		}
		
		TreeNode parent = root;
		
		while(true){
			
			if(newNode.key < parent.key){
				if(parent.leftChild == null){
					parent.leftChild = newNode;
					return;
				}else{
					parent = parent.leftChild;
				}
			}else{
				if(parent.rightChild == null){
					parent.rightChild = newNode;
					return;
				}else{
					parent = parent.rightChild;
				}
			}
		}
	}
	
	public boolean findNode(int key){
		
		if(key == root.key){
			return true;
		}
		TreeNode focusNode = root;
		while(true){
			if(key < focusNode.key){
				if(focusNode.leftChild == null){
					return false;
				}
				focusNode = focusNode.leftChild;
			}else{
				if(focusNode.rightChild == null){
					return false;
				}
				focusNode = focusNode.rightChild;
			}
			
			if(key == focusNode.key){
				return true;
			}
		}
	}
	
	public void inOrder(TreeNode root){
		if(root == null){
			return;
		}
		inOrder(root.leftChild);
		System.out.println(root.key);
		inOrder(root.rightChild);
	}
	
	public void preOrder(TreeNode root){
		if(root == null){
			return;
		}
		System.out.println(root.key);
		preOrder(root.leftChild);
		preOrder(root.rightChild);
	}
	
	public void postOrder(TreeNode root){
		if(root == null){
			return;
		}
		postOrder(root.leftChild);
		postOrder(root.rightChild);
		System.out.println(root.key);
	}
	
	public static void main(String[] args) {
		
		int[] nums = {1, -1, 2, 3, 4, 5, 6};
		
		TreesWorkshop tws =new TreesWorkshop();
		
		for(int i = 0; i < nums.length; i++){
			
			tws.addNode(nums[i]);
			
		}
		
		System.out.println("Tree created");
		
		System.out.println("3 " + tws.findNode(3));
		System.out.println("6 " + tws.findNode(6));
		System.out.println("5 " + tws.findNode(5));
		System.out.println("-2 " + tws.findNode(-2));
		
		System.out.println("\nInorder traversal: ");
		tws.inOrder(tws.root);
		
		System.out.println("\nPreorder traversal: ");
		tws.preOrder(tws.root);
		
		System.out.println("\nPostorder traversal: ");
		tws.postOrder(tws.root);
		
		

	}

}
