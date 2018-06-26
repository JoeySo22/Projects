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