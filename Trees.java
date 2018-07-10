public class Trees {
	
	protected class BNode<T extends Comparable<T>> {
		BNode left;
		BNode right;
		T value;
		
		protected BNode() {
			this.left = null;
			this.right = null;
			this.value = null;
		}
		protected BNode(T object) {
			this.left = null;
			this.right = null;
			this.value = object;
		}
	}
	
	protected class ABNode<T extends Comparable<T>> {
		ABNode<T> left;
		ABNode<T> right;
		T value;
		int level;
		
		protected ABNode() {
			this.left = null;
			this.right = null;
			this.value = null;
			this.level = 0;
		}
		protected ABNode(T object) {
			this.left = null;
			this.right = null;
			this.value = object;
			this.level = 0;
		}
	}
	
	public class BinarySearchTree<T extends Comparable<T>>{
		BNode root;
		
		public BinarySearchTree() {
			this.root = null;
		}
		
		public T getMax() {
			return getMax(this.root);
		}
		private T getMax(BNode n) {
			if (n.right == null)
				return n;
			else getMax(n.right);
		}
		
		public T getMin() {
			return getMin(this.root);
		}
		private T getMin(BNode n) {
			if (n.left == null)
				return n.value;
			else getMin(n.left);
		}
		
		public boolean contains(T t) {
			return contains(t, this.root);
		}
		private boolean contains(T t, BNode n) {
			if (n.value.equals(t))
				return true;
			if (n.left == null && n.right == null)
				return false;
			if (n.value.compareTo(t) < 0)
				return contains(t, n.right);
			if (n.value.compareTo(t) > 0)
				return contains(t, n.left);
			return false;
		}
		
		public void add(T t) {
			if (this.root == null)
				this.root = new BNode<T>(t);
			else if (this.root.value.compareTo(t) < 0)
				this.root.right = add(t, this.root);
			else if (this.root.value.compareTo(t) > 0)
				this.root.left = add(t, this.root);
		}
		private BNode add(T t, BNode n) {
			if (n == null) 
				return new BNode<T>(t);
			if (n.value.compareTo(t) < 0)
				return n.right = add(t, n.right);
			if (n.value.compareTo(t) > 0)
				return n.left = add(t, n.left);
			else
				;
			return n;
		}
	}
	
	public class AVLTrees<T extends Comparable<T>> extends BinarySearchTrees {
		private ABNode<T> root;
		private static final int PERMITTED_IMBALANCE = 1;
		
		public AVLTrees() {
			this.root = null;
		}
		
		private int level(ABNode<T> node) {
			if (node != null)
				return node.level;
			else return -1;
		}
		
		private ABNode<T> balance(ABNode<T> tree) {
			if (tree == null)
				return tree;
			if (level(tree.left) - level(tree.right) > PERMITTED_IMBALANCE) {
				if (level(tree.left.left) >= level(tree.left.right))
					tree = rotateLeftChild(tree);
				else
					tree = doubleLeftChild(tree);
			}
			else {
				if (level(tree.right) - level(tree.left) > PERMITTED_IMBALANCE) {
					if (level(t.right.right) >= level(tree.right.left))
						tree = rotateRightChild(tree);
					else
						tree = doubleRightChild(tree);
				}
			}
			
			tree.level = Math.max(level(tree.left), level(tree.right)) + 1;
			return tree;
		}
		
		private ABNode<T> rotateLeftChild(ABNode<T> n2) {
			ABNode<T> n1 = n2.left;
			n2.left = n1.right;
			n1.right = n2;
			n2.level = Math.max(level(n2.left), level(n2.right)) + 1;
			n1.level = Math.max(level(n1.left), n2.level) + 1;
			return n1;
		}
		private ABNode<T> doubleLeftChild(ABNode<T> n3) {
			n3.left = rotateRightChild(n3.left);
			return rotateLeftChild(n3);
		}
		
		//Understand and copy the above
		private ABNode<T> rotateRightChild(ABNode<T> n2) {
			ABNode<T> n1 = n2.right;
			n2.right = n1.left;
			n1.left = n2;
			n2.level = Math.max(level(n2.left), level(n2.right)) + 1;
			n1.level = Math.max(level(n1.left), n2.level) + 1;
			return n1;
		}
		private ABNode<T> doubleRightChild(ABNode<T> n3) {
			n3.left = rotateLeftChild(n3.right);
			return rotateRightChild(n3);
		}
		
		
		// All we need t make for this tree is add() and remove() functions. As well as the self balancing function
		
		public void add(T object) {
			this.root = add(object, this.root);
		}
		private ABNode add(T t, ABNode node) {
			if (node == null)
				return new ABNode(t);
			else {
				if (node.value.compareTo(t) < 0) {	
					return node.right = add(t, node.right);
				}
				if (node.value.compareTo(t) > 0) {
					return node.left = add(t, node.left);
				}
				else
					;
			}
			return balance(node);
		}
		
		
	}
}

/*
	I wanted to 
	add more
	comments 
	so that
	my scroll 
	wheel
	isn't 
	a
	pain



*/