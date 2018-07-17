
package practices.Chapter;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


/*
	给定两个已排序的表L1和L2，只使用基本的表操作编写计算L1∪L2的过程。
*/


public class Chapter_3_5 {
		
	public static void main(String args[]) {
		System.out.println("Chapter_3_5");
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(1);
		list2.add(3);
		list2.add(5);
		list2.add(6);
		
		union(list1, list2, list3);
		ListIterator<Integer> iterL3 = list3.listIterator();
		while(iterL3.hasNext()){
			Integer item = iterL3.next();
			System.out.println(item);
		}
		
		
		
	}
	
	public static <AnyType extends Comparable<? super AnyType>> 
		void union(List<AnyType> L1, List<AnyType> L2, List<AnyType> Result) {
		
		ListIterator<AnyType> iterL1 = L1.listIterator();
		ListIterator<AnyType> iterL2 = L2.listIterator();
		
		AnyType itemL1 = null;
		AnyType itemL2 = null;
		
		if (iterL1.hasNext() && iterL2.hasNext()) {
			itemL1 = iterL1.next();
			itemL2 = iterL2.next();
		}
		
		while (itemL1 != null || itemL2 != null) {
			if (itemL1 == null) {
				Result.add(itemL2);
				itemL2 = iterL2.hasNext() ? iterL2.next() : null;
			}
			else if (itemL2 == null) {
				Result.add(itemL1);
				itemL1 = iterL1.hasNext() ? iterL2.next() : null;
			}
			else {
				int compareResult = itemL1.compareTo(itemL2);
				if (compareResult == 0) {
					Result.add(itemL1);
					itemL1 = iterL1.hasNext() ? iterL1.next() : null;
					itemL2 = iterL2.hasNext() ? iterL2.next() : null;
				}
				else if (compareResult < 0) {
					Result.add(itemL1);
					itemL1 = iterL1.hasNext() ? iterL1.next() : null;
				}
				else {
					Result.add(itemL2);
					itemL2 = iterL2.hasNext() ? iterL2.next() : null;
				}
			}
		}
		
	}
}