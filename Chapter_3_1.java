
package practices.Chapter;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

/*
	给定一个表L和另一个表P，它们包含以升序排列的整数。操作品ringLots(L,P)将打印L中那些由P所指定的位置上的元素。例如，如果P=1,3,4,6，那么，L中第1、第3、第4和第6个位置上的
	元素被打印出来。写出过程printLots(L, P)。只可使用public型的Collection API容器操作。该过程的运行时间是多少？
*/
public class Chapter_3_1 {
		
	public static void main(String args[]) {
		System.out.println("Chapter_3_1");
		List<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		list1.add("E");
		list1.add("F");
		list1.add("G");
		list1.add("H");
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(3);
		list2.add(7);
		list2.add(8);
		list2.add(9);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(df.format(new Date()));// 打印当前时间
		printLots(list1, list2);
        System.out.println(df.format(new Date()));
	}
	
	public static <AnyType> void printLots(List<AnyType> L, List<Integer> P) {
		Iterator<AnyType> iterL = L.iterator();
		Iterator<Integer> iterP = P.iterator();
		
		AnyType itemL = null;
		Integer itemP = 0;
		int start = 0;
		
		while (iterP.hasNext() ) {
			
			itemP = iterP.next();
			System.out.println("Looking for position " + itemP);
			
			while (start < itemP && iterL.hasNext()) {
				start ++;
				itemL = iterL.next();
			}
			if (start == itemP) {
				System.out.println(itemL);
			}
			else {
				System.out.println("position " + itemP + " excess length!");
			}
			
		}
	
	}
}