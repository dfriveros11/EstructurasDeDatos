package edu.uniandes.common.utils;

public class AvlLinkedTree<T extends Comparable<T>> extends LinkedTree<T> {

	public int getHeight(){
		if (root != null) {
			return root.getHeight();
		}
		return 0;
	}
	
	public void balance() {
		if (root != null) {
			root = ((AvlNode<T>)root).balance();			
		}
	}
	
	@Override
	protected TreeNode<T> newNode(T t) {
		return new AvlNode<T>(t);
	}

	protected class AvlNode<P extends Comparable<P>> extends TreeNode<P> {
		
		public AvlNode(P o) {
			super(o);
		}

		public TreeNode<P> balance() {
			if (left != null) { // garantizar condición AVL en el sub-árbol izquierdo
				left = ((AvlNode<P>) left).balance();
			}
			if (right != null){ // garantizar condición AVL en el sub-árbol derecho			
				right = ((AvlNode<P>) right).balance();
			}
			int balanceIndex = this.getBalanceIndex();
			if (-1 <= balanceIndex && balanceIndex <= 1){ // Ok. El nodo cumple la condición de balanceo por altura			
				return this;
			} else if (balanceIndex == 2){ // caso desbalanceo por hijo izquierdo
			
				if (((AvlNode<P>) left).getBalanceIndex() == 1) { // desbalance por sub-árbol externo (caso 1.1)
					return this.rotarDerecha();
				} else if (((AvlNode<P>) left).getBalanceIndex() == -1){ // desbalance por sub-árbol interno (caso 2.1)
					return this.rotarIzquierdaDerecha();
				} else { // caso izquierdo.indBalanceo == 0. Este caso se puede dar en caso de eliminación de elementos del árbol AVL.				
					return this.rotarDerecha(); // (rotación simple - ver caso especial al final)
				}
			} else if (balanceIndex == -2) { // caso desbalanceo por hijo derecho (caso simétrico)
				
				if (((AvlNode<P>) right).getBalanceIndex() == -1) { // desbalance por sub-árbol externo (caso 1.1)
					return this.rotarIzquierda();
				} else if (((AvlNode<P>) right).getBalanceIndex() == 1){ // desbalance por sub-árbol interno (caso 2.1)
					return this.rotarDerechaIzquierda();
				} else { // caso izquierdo.indBalanceo == 0. Este caso se puede dar en caso de eliminación de elementos del árbol AVL.				
					return this.rotarIzquierda(); // (rotación simple - ver caso especial al final)
				}
				// casos simétricos
			}
			return this;
		}

		private int getBalanceIndex() {
			int leftHeight = left != null? left.getHeight() : 0;
			int rightHeight = right != null? right.getHeight() : 0;;
			
			return  leftHeight - rightHeight;
		}

		public TreeNode<P> rotarDerecha() {
			TreeNode<P> nodeLeft = left;
			left = nodeLeft.getRight();
			nodeLeft.setRight(this);
			return nodeLeft;
		}

		public TreeNode<P> rotarIzquierda() {
			TreeNode<P> nodeRight = right;
			right = nodeRight.getLeft();
			nodeRight.setLeft(this);
			return nodeRight;
		}

		public TreeNode<P> rotarIzquierdaDerecha() {
			AvlNode<P> nodeLeft = (AvlNode<P>) left;
			left = nodeLeft.rotarIzquierda();
			return rotarDerecha();
		}

		public TreeNode<P> rotarDerechaIzquierda() {
			AvlNode<P> nodeRight = (AvlNode<P>) right;
			right = nodeRight.rotarDerecha();
			return rotarIzquierda();
		}
		
		@Override
		protected LinkedTree<T>.TreeNode<P> newNode(P p) {
			return new AvlNode<P>(p);
		}
	}
}
