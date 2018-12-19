package edu.uniandes.common.utils;

import java.util.Iterator;

public class BrotherSonTree<P extends Comparable<P>> implements
		Comparable<BrotherSonTree<P>>, Tree<P> {
	protected BrotherSonTree<P> firstChild;
	protected BrotherSonTree<P> nextSibiling;
	protected P elem;

	public BrotherSonTree() {
		this.elem = null;
		this.firstChild = null;
		this.nextSibiling = null;
	}

	private BrotherSonTree(P o) {
		this.elem = o;
		this.firstChild = null;
		this.nextSibiling = null;
	}

	public boolean insert(P child) {

		BrotherSonTree<P> childNode = new BrotherSonTree<P>(child);
		if (this.firstChild == null) {
			this.firstChild = childNode;
			return true;
		} else {
			BrotherSonTree<P> iterNode = this.firstChild;
			BrotherSonTree<P> youngerNode = null;
			while (iterNode != null && iterNode.compareTo(childNode) < 0) {
				youngerNode = iterNode;
				iterNode = iterNode.nextSibiling;
			}

			if (iterNode == null || iterNode.compareTo(childNode) != 0) {
				if (youngerNode != null) {
					youngerNode.nextSibiling = childNode;
				} else {
					this.firstChild = childNode;
				}
				childNode.nextSibiling = iterNode;
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean insert(P parent, P newChild) {
		if (parent == null) {
			return this.insert(newChild);
		}

		BrotherSonTree<P> parentNode = this.searchNode(parent);
		if (parentNode != null) {
			return parentNode.insert(newChild);
		} else {
			return false;
		}
	}

	public P delete(P object) {
		BrotherSonTree<P> foundNode = this.searchNode(object);
		BrotherSonTree<P> foundNodeBefore = this.searchNodeBefore(object);
		// encontre el nodo
		if (foundNode != null) {
			if (foundNodeBefore == null) {
				throw new IllegalStateException(
						"Invalid node found. The before-node cannot be null");
			}

			if (foundNode.firstChild != null) {
				return null;
			} else {
				if (foundNodeBefore.nextSibiling == foundNode) {
					foundNodeBefore.nextSibiling = foundNode.nextSibiling;
				} else if (foundNodeBefore.firstChild == foundNode) {
					foundNodeBefore.firstChild = foundNode.nextSibiling;
				} else {
					throw new IllegalStateException(
							"Invalid node found. The previous node must be either sibiling or parent of the node to delete");
				}
			}
		}
		return null;

	}
	private BrotherSonTree<P> searchNodeBefore(P object) {
		if (this.firstChild != null && this.firstChild.elem != null && this.firstChild.elem.compareTo(object) == 0) {
			return this;
		}
		
		if (this.nextSibiling != null && this.nextSibiling.elem != null && this.nextSibiling.elem.compareTo(object) == 0) {
			return this;
		}
	
		if (this.firstChild != null) {
			BrotherSonTree<P> foundChild = this.firstChild.searchNodeBefore(object);
			if (foundChild != null) {
				return foundChild;
			}
		}

		if (this.nextSibiling != null) {
			BrotherSonTree<P> foundSibling = this.nextSibiling.searchNodeBefore(object);
			if (foundSibling != null) {
				return foundSibling;
			}
		}

		return null;
	}

	private BrotherSonTree<P> searchNode(P object) {
		if (this.elem != null && this.elem.compareTo(object) == 0) {
			return this;
		}

		if (this.firstChild != null) {
			BrotherSonTree<P> foundChild = this.firstChild.searchNode(object);
			if (foundChild != null) {
				return foundChild;
			}
		}

		if (this.nextSibiling != null) {
			BrotherSonTree<P> foundSibling = this.nextSibiling
					.searchNode(object);
			if (foundSibling != null) {
				return foundSibling;
			}
		}

		return null;
	}

	public P search(P objeto) {
		BrotherSonTree<P> node = this.searchNode(objeto);
		if (node != null) {
			return node.elem;
		}
		return null;
	}

	public Iterator<P> preOrder() {
		List<P> lista = new LinkedList<P>();
		this.preOrder(lista);
		return lista.iterator();
	}

	public int size() {
		int size = 0;
		if (this.firstChild != null) {
			size += firstChild.size() + 1;
		}

		if (this.nextSibiling != null) {
			size += nextSibiling.size() + 1;
		}

		return size;
	}

	private void preOrder(List<P> lista) {
		if (this.elem != null) {
			lista.add(this.elem);
		}
		if (firstChild != null) {
			firstChild.preOrder(lista);
		}
		if (nextSibiling != null) {
			nextSibiling.preOrder(lista);
		}

	}

	public Iterator<P> postOrder() {
		List<P> lista = new LinkedList<P>();
		this.postOrder(lista);
		return lista.iterator();
	}

	private void postOrder(List<P> lista) {
		if (firstChild != null) {
			firstChild.postOrder(lista);
		}
		if (this.elem != null) {
			lista.add(this.elem);
		}
		if (nextSibiling != null) {
			nextSibiling.postOrder(lista);
		}
	}

	public Iterator<P> getLevel(int level) {
		List<P> list = new LinkedList<P>();
		this.searchLevels(list, level + 1);
		return list.iterator();
	}

	private void searchLevels(List<P> list, int level) {
		int value = 0;
		if (value == level) {
			list.add(this.elem);
		} else {
			BrotherSonTree<P> child = this.firstChild;
			while (child != null) {
				child.searchLevels(list, level - 1);
				child = child.nextSibiling;
			}
		}
	}

	public Iterator<P> getAllLevels() {
		List<P> lista = new LinkedList<P>();

		for (int h = 0; h < this.getHeight(); h++) {
			Iterator<P> nodeIter = this.getLevel(h);
			while (nodeIter.hasNext()) {
				lista.add(nodeIter.next());
			}
		}
		return lista.iterator();
	}

	public P getMin() {
		if (this.firstChild == null) {
			return null;
		} else {
			return getMin(this.firstChild.elem);
		}
	}

	private P getMin(P min) {
		if (this.elem != null) {
			if (min.compareTo(this.elem) > 0) {
				min = this.elem;
			}
		}
		if (firstChild != null) {
			P minChild = firstChild.getMin(min);
			if (min.compareTo(minChild) > 0) {
				min = minChild;
			}
		}
		if (nextSibiling != null) {
			P minSibiling = nextSibiling.getMin(min);
			if (min.compareTo(minSibiling) > 0) {
				min = minSibiling;
			}
		}
		return min;
	}

	public int getHeight() {
		int childrenHeight = 0;
		int sibilingsHeight = 0;

		if (this.firstChild != null) {
			childrenHeight += this.firstChild.getHeight() + 1;
		}

		if (this.nextSibiling != null) {
			sibilingsHeight += this.nextSibiling.getHeight();
		}

		return (childrenHeight > sibilingsHeight) ? childrenHeight
				: sibilingsHeight;
	}

//	@Override
	public int compareTo(BrotherSonTree<P> o) {
		return this.elem.compareTo(o.elem);
	}
}
// }
