package edu.uniandes.common.utils;

import java.util.Iterator;

public class TrinaryTree<T extends Comparable<T>>  {

	/**
	 * Is the root of the linkedTree
	 */
	protected TreeNode<T> root;
	/**
	 * The size of the linkedTree
	 */
	private int size;
	
	/**
	 * Constructor of the class
	 */
	public TrinaryTree() {
		root = null;
		size = 0;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.BinaryTree#insert(java.lang.Object)
	 */
	public boolean insert(T object) {
		if (root == null) {
			TreeNode<T> newNode = newNode(object);
			root = newNode;
			size++;
			return true;
		} else {
			if (root.insert(object)) {
				size++;
				return true;
			}
			return false;
		}
	}

	protected TreeNode<T> newNode(T object) {
		return new TreeNode<T>(object);
	}

	/*
	 * (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.BinaryTree#delete(java.lang.Object)
	 */
	public T delete(T object){
		T elementTodelet = (root == null)? null: root.search(object);
		if (elementTodelet != null) {
			root = root.delete(object);
			size--;
		}
		return elementTodelet;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.BinaryTree#search(java.lang.Object)
	 */
	public T search(T object) {
		if (root == null) {
			return null;
		}
		return root.search(object);
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.BinaryTree#preOrder()
	 */
	public Iterator<T> preOrder() {
		List<T> list = new LinkedList<T>();
		if (root == null) {
			return list.iterator();
		} 
		root.preOrder(list);
		return list.iterator();		
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.BinaryTree#postOrder()
	 */
	public Iterator<T> postOrder() {
		List<T> list = new LinkedList<T>();
		if (root == null) {
			return list.iterator();
		} 
		root.posOrder(list);
		return list.iterator();		
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.BinaryTree#inOrder()
	 */
	public Iterator<T> inOrder() {
		List<T> list = new LinkedList<T>();
		if (root == null) {
			return list.iterator();
		} 
		root.inOrder(list);
		return list.iterator();		
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.BinaryTree#getLevel(int)
	 */
	public Iterator<T> searchLevels(int level) {
		List<T> list = new LinkedList<T>();
		if (root == null) {
			return list.iterator();
		}
		root.searchLevels(list, level);
		return list.iterator();
	}

	/**
	 * @author diegor
	 *
	 * @param <P>
	 */
	protected class TreeNode<P extends Comparable<P>> {
		/**
		 * The right node of this
		 */
		protected TreeNode<P> right;
		/**
		 * The left node of this
		 */
		protected TreeNode<P> left;
		/**
		 * The middle node of this
		 */
		protected TreeNode<P> middle;
		/**
		 * the element of the node
		 */
		protected P elem;
		

		/**
		 * The constructor of the class
		 * @param o
		 */
		public TreeNode(P o) {
			right = null;
			left = null;
			middle = null;
			this.elem = o;

		}
		public int getHeight(){			
			if (left == null && right == null && middle == null) {
				return 1;
			} else {
				int leftHeight = left != null ? left.getHeight() : 0;
				int rightHeight = right != null ?  right.getHeight() : 0;
				int middleHeight = middle != null ?  middle.getHeight() : 0;
				
				int highest = leftHeight > rightHeight? leftHeight: rightHeight;
				return (middleHeight > highest) ? middleHeight + 1 : highest + 1;
			}
		}
		
		/**
		 * Method that returns the value of the node.
		 * @return
		 */
		public P getValue() {
			return elem;
		}

		/**
		 * Method that assigns a value to the element
		 * @param value
		 */
		public void setValue(P value) {
			this.elem = value;
		}

		/**
		 * Method that returns the right node
		 * @return
		 */
		public TreeNode<P> getRight() {
			return right;
		}

		/**
		 * Method that assigns the right node 
		 * @param right
		 */
		public void setRight(TreeNode<P> right) {
			this.right = right;
		}

		/**
		 * Method that returns the left node
		 * @return
		 */
		public TreeNode<P> getLeft() {
			return left;
		}

		/**
		 * Method that assigns the left node 
		 * @param left
		 */
		public void setLeft(TreeNode<P> left) {
			this.left = left;
		}
		
		public TreeNode<P> getMiddle() {
			return middle;
		}
		public void setMiddle(TreeNode<P> middle) {
			this.middle = middle;
		}
		/**
		 * Method that proves if the node is a leaf
		 * @return true if is a leaf or false if it is not
		 */
		public boolean isLeaf(){
			TreeNode<P> current = this;
			if (current.getLeft() == null && current.getRight() == null && current.getMiddle() == null) {
				return true;
			}
			return false;
		}

		/**
		 * Method that inserts a node into the table 
		 * @param object
		 * @return true if it inserts the new node or false if it doesn't
		 */
		public boolean insert(P object) {
			//TODO
			TreeNode<P> current = this;
			TreeNode<P> node = newNode(object);

			int comparison = current.getValue().compareTo(object);
			if (comparison == 0) {
				return false;
			}
			else if (comparison < 0) {
				if (this.getRight() == null) {
					this.setRight(node);		
					return true;
				} else {
					return this.getRight().insert(object);
				}
			} else {
				if (this.getLeft() == null) {
					this.setLeft(node);			
					return true;
				} else {
					return this.getLeft().insert(object);
				}
			}
		}

		protected TreeNode<P> newNode(P object) {
			return new TreeNode<P>(object);
		}

		/**
		 * 
		 * @param object
		 * @return
		 */
		public TreeNode<P> delete(P object){
			//TODO
			TreeNode<P> current = this;
			int comparasion = current.getValue().compareTo(object);
			if (comparasion == 0) {
				if (right == null && left == null) {
					return null;
				}
				else if (left == null && right != null) {
					return right;
				}
				else if (right == null && left != null) {
					return left;
				}
				else {
					TreeNode<P> replace = right.getMin();
					right = right.delete(replace.getValue());
					replace.left = left;
					replace.right = right;
					return replace;
				}
			}
			else if (comparasion > 0) {
				left = left.delete(object);
				return this;
			}else {
				right = right.delete(object);
				return this;
			}
		}
		/**
		 * 
		 * @return TreeNode<P>
		 */
		private TreeNode<P> getMin() {
			if (this.left != null) {
				return this.left.getMin();
			} else if (this.left == null && this.middle != null) {
				return this.middle.getMin();
			}else {
				return this;
			}
		}



		/**
		 * Method that searches a node in the tree
		 * @param object
		 * @return P the node when it findes it
		 */
		public P search(P object) {
			TreeNode<P> current = this;
			int comparison = current.getValue().compareTo(object);
			if (comparison == 0) {
				return current.getValue();
			} else if (comparison < 0) {
				if (current.getRight() != null) {
					return current.getRight().search(object);
				}
				return null;
			} else {
				if (current.getLeft() != null) {
					return current.getLeft().search(object);
				}
				return null;
			}
		}

		/**
		 * Gives the nodes of the tree in a list in preOrden
		 * @param list
		 */
		public void preOrder(List<P> list) {
			list.add(this.getValue());
			if (left != null) {
				left.preOrder(list);
			}
			if (middle != null) {
				middle.preOrder(list);
			}
			if (right != null) {
				right.preOrder(list);
			}
		}

		/**
		 * Gives the nodes of the tree in a list in posOrden
		 * @param list
		 */
		public void posOrder(List<P> list) {
			if (left != null) {
				left.posOrder(list);
			}
			if (middle != null) {
				middle.preOrder(list);
			}
			if (right != null) {
				right.posOrder(list);
			}
			list.add(this.getValue());
		}

		/**
		 * Gives the nodes of the tree in a list in inOrden
		 * @param list
		 */
		public void inOrder(List<P> list) {
			if (left != null) {
				left.inOrder(list);
			}
			list.add(this.getValue());
			if (middle != null) {
				middle.preOrder(list);
			}
			if (right != null) {
				right.inOrder(list);
			}
			
		}

		/**
		 * Method that searces nodes by level in the tree
		 * @param list
		 * @param level
		 */
		public void searchLevels(List<P> list, int level) {
			int value = 0;
			if (value == level) {
				list.add(this.getValue());
			}else {
				if (left != null) {
					left.searchLevels(list, level - 1);
				}
				if (middle != null) {
					middle.searchLevels(list, level - 1);
				}
				if (right != null) {
					right.searchLevels(list, level - 1);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.BinaryTree#size()
	 */
	public int size() {
		return size;
	}
}
