package List;

public class MyLinkedList {
	

	private int size;
	static private Node head;
   
    static class Node{
    Object value;
    Node next;

    Node(Object value){
    this.value=value;
    }
    
    public void setvalue(Object value){
    this.value=value;
    }
    
    public Object getvalue(){
    return value;
    }
    
    public void setnext(Node next){
    this.next=next;
    }
    
    public Node getnext(){
    return next;
    }
    
}

      
    public void add(Object t) {
        if (head == null) {
            this.head = new Node(t);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.setnext(new Node(t));
        }
        size++;
    }
    
    public String toString() {
        String result = " ";
        if (head == null) {
            System.out.println("null");
        } else {
            Node temp = head;
            while (temp != null) {
            	result += temp.getvalue() + " ";
                temp = temp.next;
            }
        }
        return result;
    }
    
    public void remove(int a) {
        if (a == 0) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        for (int i = 0; i < a - 1; i++) {
            temp = temp.next;
        }
        temp.setnext(temp.getnext().getnext());
        size--;
    }
    
    public void set(int a, Object o) {
        if (a == 0) {
            head.setvalue(o);
            return;
        }
        Node temp = head;
        for (int i = 0; i < a; i++) {
            temp = temp.next;
        }
        temp.setvalue(o);
    }
    
    public Object get(int a) {
    	if (a == 0) {
            return head.getvalue();
        }
        Node temp = head;
        for (int i = 0; i < a; i++) {
            temp = temp.next;
        }
    	return temp.getvalue();
    }
    
    public int size() {
    	return size;
    }
    
    public void clear() {
    	head=null;
    	size=0;
    }
    
    public static MyLinkedList reverse(MyLinkedList llist) {
    	for (int i = 0; i < llist.size() / 2; i++) { 
            Object temp = llist.get(i); 
            llist.set(i, llist.get(llist.size() - i - 1)); 
            llist.set(llist.size() - i - 1, temp); 
        } 
  
        // Return the reversed arraylist 
        return llist; 
    }

}
