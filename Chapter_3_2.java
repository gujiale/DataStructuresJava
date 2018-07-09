
package practices.Chapter;


/*
	练习3.2 通过只调整链(而不是数据)来交换两个相邻的元素，使用：
	a.单链表
	b.双链表
*/

//单项链表
class SinglyLinkedNode<AnyType> {
	public SinglyLinkedNode(AnyType d, SinglyLinkedNode<AnyType> n) {
		data = d; 
		next = n;
	}
	public AnyType data;
	public SinglyLinkedNode<AnyType> next;
}

//双向链表
class DoublyLinkedNode<AnyType> {
	public DoublyLinkedNode(AnyType d, DoublyLinkedNode<AnyType> p, DoublyLinkedNode<AnyType> n) {
		data = d; 
		prev = p;
		next = n;
	}
	public AnyType data;
	public DoublyLinkedNode<AnyType> prev;
	public DoublyLinkedNode<AnyType> next;
}

public class Chapter_3_2 {
		
	public static void main(String args[]) {
		System.out.println("Chapter_3_2");
		
		//a.单链表
		SinglyLinkedNode<String> n1 = new SinglyLinkedNode<String>("aaa", null);
		SinglyLinkedNode<String> n2 = new SinglyLinkedNode<String>("bbb", null);
		SinglyLinkedNode<String> n3 = new SinglyLinkedNode<String>("ccc", null);
		n1.next = n2;
		n2.next = n3;
		swapWithNext(n1);
		SinglyLinkedNode<String> p = n1;
		System.out.println("a.单链表");
		while(p != null) {
			System.out.println(p.data);
			p = p.next;
		}
		
		//b.双向链表
		DoublyLinkedNode<String> dn1 = new DoublyLinkedNode<String>("aa", null, null);
		DoublyLinkedNode<String> dn2 = new DoublyLinkedNode<String>("bb", null, null);
		DoublyLinkedNode<String> dn3 = new DoublyLinkedNode<String>("cc", null, null);
		DoublyLinkedNode<String> dn4 = new DoublyLinkedNode<String>("dd", null, null);
		dn1.next = dn2;
		dn2.prev = dn1;
		dn2.next = dn3;
		dn3.prev = dn2;
		dn4.prev = dn3;
		dn3.next = dn4;
		
		swapWithNext(dn3);
		DoublyLinkedNode<String> dp = dn1;
		System.out.println("b.双向链表");
		while(dp != null) {
			System.out.println(dp.data);
			dp = dp.next;
		}
	}
	
	
	//单向链表,交换相邻元素
	public static void swapWithNext(SinglyLinkedNode beforep) {
		SinglyLinkedNode p, afterp;
		
		p = beforep.next;
		afterp = p.next;
		beforep.next = p.next;
		p.next = afterp.next;
		afterp.next = p;
	}
	
	//双向链表,交换相邻元素
	public static void swapWithNext(DoublyLinkedNode p) {
		DoublyLinkedNode beforep, afterp;
		beforep = p.prev;
		afterp = p.next;
		beforep.next = afterp;
		afterp.prev = beforep;
		p.prev = afterp;
		p.next = afterp.next;
		afterp.next = p;
		
	}
	
}