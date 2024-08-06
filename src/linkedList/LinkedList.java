package linkedList;

public class LinkedList {
	
	private Node initial;
	
	public LinkedList() {
		this.initial = null;
	}
	
	public void insertStartList(Object element) {
		Node newNode = new Node(element, initial);
		newNode.setNext(this.initial);
		this.initial = newNode;
	}
	
	public void insertEndList(Object element) {
		
	}
	
	public Object removeStartList() {
		Node assistent = this.initial;
		this.initial = assistent.getNext();
		return assistent.getElement();
	}
	
	public void printList() {
		Node assistent = this.initial;
		System.out.println("Início da Lista");
		
		while (assistent != null) {
			System.out.println(assistent.getElement());
			assistent = assistent.getNext(); 
		}
	}
	
	public int sizeList() {
		int size = 0;
		Node assistent = this.initial;
		while (assistent != null) {
			assistent = assistent.getNext();
			size += 1;
		}
		return size;
	}
	
}
