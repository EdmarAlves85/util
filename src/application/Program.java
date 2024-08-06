package application;

import binaryTree.BinaryTree;

public class Program {

	public static void main(String[] args) {
		
		
		/*
		 * LinkedList listClient = new LinkedList(); Client c1 = new Client("Edmar",
		 * "efnra85@gmail.com", "819912262482");
		 * 
		 * listClient.insertStartList(c1); listClient.insertStartList(new
		 * Client("Alynne", "alynnesilvana90@hotmail.com", "81973147389"));
		 * listClient.insertStartList(new Client("Marina", "mariana@gmail.com",
		 * "81912121212")); listClient.insertStartList(new Client("Catarina",
		 * "catarina@gmail.com", "81913131313"));
		 * 
		 * listClient.printList(); System.out.println("Total: " +
		 * listClient.sizeList());
		 * 
		 * System.out.println("-----------------------------------------");
		 * 
		 * Client clientRemoved = (Client) listClient.removeStartList();
		 * listClient.printList(); System.out.println(
		 * "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
		 * ); System.out.println("CLIENTE REMOVIDO: " + clientRemoved);
		 * System.out.println(
		 * "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
		 * ); System.out.println("Total Atulizado: " + listClient.sizeList());
		 * 
		 * System.out.println("-----------------------------------------");
		 * 
		 * listClient.insertEndList(new Client("Catarina", "catarina@gmail.com",
		 * "81913131313")); System.out.println("Lista atualizada!");
		 * listClient.printList(); System.out.println("Total Atulizado: " +
		 * listClient.sizeList());
		 */
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insert(555, "A");
		binaryTree.insert(333, "B");
		binaryTree.insert(111, "C");
		binaryTree.insert(444, "D");
		binaryTree.insert(888, "E");
		binaryTree.insert(999, "F");
		//binaryTree.insert(82, "G");
		//binaryTree.insert(86, "H");
		
		//binaryTree.prefixed(binaryTree.getRoot());
		System.out.println("Total de Filhos da esquerda: " + binaryTree.counterLeft(binaryTree.getRoot()));
		System.out.println("Total de Filhos da direita: " + binaryTree.counterRight(binaryTree.getRoot()));
		binaryTree.printTree(binaryTree.getRoot(), 0);
		
		
	
	}

}
