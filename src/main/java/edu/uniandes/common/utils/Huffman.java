package edu.uniandes.common.utils;

import java.util.Iterator;

public class Huffman {

	private List<String> compressed;
	private HuffmanTree tree;
	private Map<Character, String> alphabet;

	// --------------------------
	// construct
	// --------------------------

	public Huffman(String text) {
		alphabet = buildAlphabet(calculateFrequencies(text));
		compressed = buildCode(text);
	}

	public String getCompressed() {
		StringBuilder sb = new StringBuilder();
		for (String s : compressed) {
			sb.append(s);
		}		
		return sb.toString();
	}
	// --------------------------
	// Methods
	// --------------------------

	public List<String> buildCode(String text) {
		compressed = new LinkedList<String>();
		char[] chars = text.toCharArray();
		for (char letter : chars) {			
			String code = this.alphabet.get(letter);
			compressed.add(code);
		}
		return compressed;
	}

	public List<HuffmanTree> calculateFrequencies(String palabra) {
		char[] chars = palabra.toCharArray();

		Map<Character, Integer> frequencyPerLetter = new HashTable<Character, Integer>();
		for (char letter : chars) {
			Integer frecuencia = frequencyPerLetter.get(letter);
			if (frecuencia == null) {
				frecuencia = 0;
			}
			frequencyPerLetter.put(letter, frecuencia + 1);
		}

		SortedList<HuffmanTree> sortedFrequencies = new SortedList<HuffmanTree>();

		for (char letter : frequencyPerLetter.keys()) {
			HuffmanTree newTree = new HuffmanTree();
			newTree.insert(new HuffmanData(letter, frequencyPerLetter.get(letter)));
			sortedFrequencies.add(newTree);
		}
		return sortedFrequencies;
	}

	private Map<Character, String> buildAlphabet(List<HuffmanTree> lista) {
		tree = new HuffmanTree();
		while (lista.size() > 1) {

			Iterator<HuffmanTree> iter = lista.iterator();

			HuffmanTree t1 = iter.next();
			HuffmanTree t2 = iter.next();

			lista.remove(t1);
			lista.remove(t2);

			HuffmanTree newTree = new HuffmanTree(t1, t2);

			lista.add(newTree);
		}
		tree = lista.iterator().next();
		
		alphabet = new HashTable<Character, String>();
		buildMap(alphabet, "0", tree.root.left);
		buildMap(alphabet, "1", tree.root.right);
		
		return alphabet;
	}


	private void buildMap(Map<Character, String> codePerCharMap, String code, LinkedTree<HuffmanData>.TreeNode<HuffmanData> node) {
		
		if (node.isLeaf()) {
			codePerCharMap.put(node.elem.character, code);
		} else {
			buildMap(codePerCharMap, code + "0", node.left);
			buildMap(codePerCharMap, code + "1", node.right);
		}
		
	}

	public String descomprimir(LinkedList<String> comprimido, HuffmanTree arbol) {
		String palabra = "";
		LinkedTree<HuffmanData>.TreeNode<HuffmanData> current = arbol.root;
		for (String letraBinario : comprimido) {
			char[] binario = letraBinario.toCharArray();
			LinkedTree<HuffmanData>.TreeNode<HuffmanData> temp = current;
			for (int j = 0; j < binario.length; j++) {
				char posicion = binario[j];
				if (posicion == 0) {
					temp = temp.left;
				}
				temp = temp.right;
			}
			char letra = temp.elem.character;
			palabra = palabra + Character.toString(letra);
		}
		return palabra;
	}

	protected class HuffmanTree extends LinkedTree<HuffmanData> implements
			Comparable<HuffmanTree> {

		public HuffmanTree() {

		}

		public HuffmanTree(HuffmanTree left, HuffmanTree right) {
			
			char character = (char)((left.root.elem.character + right.root.elem.character)/2);
			this.insert(new HuffmanData(character,
					left.root.elem.frecuencia + right.root.elem.frecuencia));
			this.root.setLeft(left.root);
			this.root.setRight(right.root);
		}

		//@Override
		public int compareTo(HuffmanTree o) {
			return this.root.elem.frecuencia - o.root.elem.frecuencia;
		}
	}

	protected class HuffmanData implements Comparable<HuffmanData> {
		protected char character;
		protected int frecuencia;

		public HuffmanData(char o, int frec) {
			this.character = o;
			this.frecuencia = frec;
		}

		public char getCharacter() {
			return character;
		}

		public void setCharacter(char character) {
			this.character = character;
		}

		public int getFrecuencia() {
			return frecuencia;
		}

		public void setFrecuencia(int frecuencia) {
			this.frecuencia = frecuencia;
		}

		//@Override
		public int compareTo(HuffmanData o) {
			return this.getFrecuencia() - o.getFrecuencia();
		}
	}
}
