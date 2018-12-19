package edu.uniandes.common.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Tries<P extends Comparable<P>> extends BrotherSonTree<P> {
    protected Tries<P> firstChild;
    protected Tries<P> nextSibiling;
    protected char letter;
    protected P elem;

    public Tries() {
        this.letter = '\u0000';
        this.elem = null;
        this.firstChild = null;
        this.nextSibiling = null;
    }

    public boolean insert(String key, P p) {
        if (this.letter == '\u0000') {
            this.letter = key.charAt(0);
        }

        if (this.letter != key.charAt(0)) {
            if (this.nextSibiling == null) {
                this.nextSibiling = new Tries<P>();
            }
            return this.nextSibiling.insert(key, p);

        } else { // this.letter == key.charAt(0)
            if (key.length() == 1) {
                this.elem = p;
                return true;
            }
            if (this.firstChild == null) {
                this.firstChild = new Tries<P>();
            }

            return this.firstChild.insert(key.substring(1, key.length()), p);
        }
    }

    private Tries<P> searchNode(String key) {
        if (this.letter != key.charAt(0)) {
            if (this.nextSibiling != null) {
                return this.nextSibiling.searchNode(key);
            }
        } else {
            if (key.length() == 1) {
                return this;
            } else {
                if (this.firstChild != null) {
                    return this.firstChild.searchNode(key.substring(1, key.length()));
                }
            }
        }
        return null;
    }

    private Tries<P> searchNodeBefore(String key) {
        if (this.letter != key.charAt(0)) {
            if (this.nextSibiling != null) {
                return this.nextSibiling.searchNodeBefore(key);
            }
        } else {
            if (key.length() == 2) {
                Tries<P> targetNode = this.searchNode(key.substring(1, key.length()));
                if (targetNode != null) {
                    return this;
                }
            } else {
                if (this.firstChild != null) {
                    return this.firstChild.searchNodeBefore(key.substring(1, key.length()));
                }
            }
        }
        return null;
    }

    public Iterator<P> searchWord(String key) throws NoSuchElementException {
        List<P> list = new LinkedList<P>();
        Tries<P> node = this.searchNode(key);
        if (node != null) {
            list.add(node.elem);
        } else {
            throw new NoSuchElementException();
        }
        return list.iterator();
    }

    public Iterator<P> searchPrefix(String prefix) {
        List<P> list = new LinkedList<P>();
        this.searchPrefix(list, prefix);
        return list.iterator();
    }

    private void searchPrefix(List<P> list, String key) {
        if (key.length() == 0) {
            if (this.elem != null) {
                list.add(this.elem);
            }
            if (this.firstChild != null) {
                this.firstChild.searchPrefix(list, key);
            }
            if (this.nextSibiling != null) {
                this.nextSibiling.searchPrefix(list, key);
            }
        } else {
            if (this.letter == key.charAt(0)) {
                if (this.elem != null && key.length() <= 1) {
                    list.add(this.elem);
                }
                if (this.firstChild != null) {
                    this.firstChild.searchPrefix(list, key.substring(1, key.length()));
                }
            } else {
                if (this.nextSibiling != null) {
                    this.nextSibiling.searchPrefix(list, key);
                }
            }
        }
    }

    public Iterator<P> searchLongestWord(String word) {
    	 List<P> list = new LinkedList<P>();
         Tries<P> node = this.searchNode(word);
         if (node != null) {
             list.add(node.elem);
         } else {
             throw new NoSuchElementException();
         }
         return list.iterator();
    }

    public void delete(String key) {
        Tries<P> nodeToDelete = searchNode(key);
        Tries<P> nodeToDeleteBefore = searchNodeBefore(key);

        if (nodeToDelete != null) {
            if (nodeToDeleteBefore != null) {
                if (nodeToDeleteBefore.firstChild == nodeToDelete) {
                    nodeToDeleteBefore.firstChild = null;
                } else if (nodeToDeleteBefore.nextSibiling == nodeToDelete) {
                    nodeToDeleteBefore.nextSibiling = null;
                }
            }

            nodeToDeleteBefore.cleanup(key.substring(0, key.length() - 1));
        }
    }

    private void cleanup(String key) {
        Tries<P> nodeToDelete = searchNode(key);
        Tries<P> nodeToDeleteBefore = searchNodeBefore(key);

        if (nodeToDelete != null && nodeToDelete.firstChild == null && nodeToDelete.nextSibiling == null && nodeToDelete.elem == null) {
            if (nodeToDeleteBefore != null) {
                if (nodeToDeleteBefore.firstChild == nodeToDelete) {
                    nodeToDeleteBefore.firstChild = null;
                } else if (nodeToDeleteBefore.nextSibiling == nodeToDelete) {
                    nodeToDeleteBefore.nextSibiling = null;
                }
            }

            nodeToDeleteBefore.cleanup(key.substring(0, key.length() - 1));
        }
    }

}
