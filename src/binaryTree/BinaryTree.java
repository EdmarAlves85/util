package binaryTree;

public class BinaryTree {

	private Node root;

	public BinaryTree() {
		this.root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void insert(long id, Object element) {
		Node newNode = new Node(id, element, null, null);

		if (root == null) {
			root = newNode;
		} else {
			Node parentNode, currentNode = root;

			while (true) {
				parentNode = currentNode;
				if (id < currentNode.getId()) {
					currentNode = currentNode.getLeft();
					if (currentNode == null) {
						parentNode.setLeft(newNode);
						return;
					}
				} else {
					currentNode = currentNode.getRight();
					if (currentNode == null) {
						parentNode.setRight(newNode);
						return;
					}
				}
			}
		}
	}

	// CAMINHAMENTO PRE-FIXADO
	public void prefixed(Node currentNode) {
		if (currentNode != null) {
			System.out.println("Id: " + currentNode.getId() + " Element: " + currentNode.getElement());

			prefixed(currentNode.getLeft());

			prefixed(currentNode.getRight());
		}

	}

	// CAMINHAMENTO POS-FIXADO
	public void postfixed(Node currentNode) {

		if (currentNode != null) {
			postfixed(currentNode.getLeft());
			postfixed(currentNode.getRight());
			System.out.println("Id: " + currentNode.getId() + " Element: " + currentNode.getElement());
		}

	}

	// CAMINHAMENTO SIMETRICO
	public void symmetricFixed(Node currentNode) {

		if (currentNode != null) {
			symmetricFixed(currentNode.getLeft());
			System.out.println("Id: " + currentNode.getId() + " Element: " + currentNode.getElement());
			symmetricFixed(currentNode.getRight());
		}
	}

	public void printTree(Node currentNode, int level) {
		
		for(int i = 0; i < level; i++) {
			System.out.print("\t");
		}
		
		if (currentNode == null) {
			System.out.println("-");
			return;
		} else {
			System.out.println(currentNode.getId());
		}
		
		printTree(currentNode.getLeft(), level + 1);
	    printTree(currentNode.getRight(), level + 1);
		
	}	
	
	// CONTADOR DE FILHOS DA ESQUERDA
	public int counterLeft(Node currentNode) {
		if (currentNode == null) {
			return 0;
		}

		int counter = 0;
		if (currentNode.getLeft() != null) {
			counter++;
		}

		counter += counterLeft(currentNode.getLeft());
		counter += counterLeft(currentNode.getRight());

		return counter;
	}

	// CONTADOR DE FILHOS DA DIREITA
	public int counterRight(Node currentNode) {
		if (currentNode == null) {
			return 0;
		}

		int counter = 0;
		if (currentNode.getRight() != null) {
			counter++;
		}

		counter += counterRight(currentNode.getRight());
		counter += counterRight(currentNode.getLeft());

		return counter;
	}

	public Node searchNode(long id) {
		return search(root, id);
	}

	private Node search(Node currentNode, long id) {
		if (currentNode == null) {
			return null;
		} else {
			if (id == currentNode.getId()) {
				return currentNode;
			} else {
				if (id < currentNode.getId()) {
					return search(currentNode.getLeft(), id);
				} else {
					return search(currentNode.getRight(), id);
				}
			}
		}
	}

	public boolean removeNode(long id) {
		Node currentNode = root;
		Node parentNode = root;
		boolean left = true;

		while (currentNode.getId() != id) {
			parentNode = currentNode;

			if (id < currentNode.getId()) {
				left = true;
				currentNode = currentNode.getLeft();
			} else {
				left = false;
				currentNode = currentNode.getRight();
			}

			if (currentNode == null) {
				return false;
			}

		}
		// CASO 1: ELEMENTO NAO POSSUI FILHOS
		if (currentNode.getLeft() == null && currentNode.getRight() == null) {
			if (currentNode == root) {
				root = null;
			} else {
				if (left) {
					parentNode.setLeft(null);
				} else {
					parentNode.setRight(null);
				}
			}
		} else {
			// CASO 2: COM APENAS O FILHO ESQUERDO
			if (currentNode.getRight() == null) {
				if (currentNode == root) {
					root = currentNode.getLeft();
				} else {
					parentNode.setRight(currentNode.getLeft());
				}
			} else {
				// CASO 2: COM APENAS O FILHO DIREITO
				if (currentNode.getLeft() == null) {
					if (currentNode == root) {
						root = currentNode.getRight();
					} else {
						if (left) {
							parentNode.setLeft(currentNode.getRight());
						} else {
							parentNode.setRight(currentNode.getRight());
						}
					}
					// CASO 3: ELEMENTO POSSUI OS DOIS FILHOS
				} else {
					Node successor = getSuccessorNode(currentNode);
					if (currentNode == root) {
						root = successor;
					} else {
						if (left) {
							parentNode.setLeft(successor);
						} else {
							parentNode.setRight(successor);
						}
					}
					successor.setLeft(currentNode.getLeft());
				}
			}

		}
		return true;
	}

	private Node getSuccessorNode(Node deleted) {
		Node successorParentNode = deleted;
		Node successorNode = deleted;
		Node currentNode = deleted.getRight();

		while (currentNode != null) {
			successorParentNode = successorNode;
			successorNode = currentNode;
			currentNode = currentNode.getLeft();
		}

		if (successorNode != deleted.getRight()) {
			successorNode.setRight(deleted.getRight());
		}
		return successorNode;
	}
}