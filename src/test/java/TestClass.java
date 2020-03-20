import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import List.MyLinkedList;

public class TestClass {
	
	private MyLinkedList list;
	
		@Before
		public void init() {
			list = new MyLinkedList();
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			list.add(5);
		}
		
		@After
		public void finalize() {
			list.clear();
		}
	
		@Test
		public void sizeTest() {
			assertEquals(5,list.size());
		}
		
		
		@Test
		public void getTest() {
			assertEquals(4,list.get(3));
		}
		
		@Test
		public void removeTest1() {
			list.remove(2);
			assertEquals(5,list.get(3));
		}
		
		@Test
		public void removeTest2() {
			list.remove(2);
			assertEquals(4,list.size());
		}
		
		@Test
		public void clearTest() {
			list.clear();
			assertEquals(0,list.size());
		}
		
		@Test
		public void reverseTest() {
			List <Object> newList = new ArrayList<Object>();
			for(int i=0; i<list.size(); i++) {
				newList.add(list.get(i));
			}
			list = list.reverse(list);
			int j = 0;
			boolean result = true;
			while(j <= list.size()/2) {
				if(newList.get(j)!=list.get(list.size()-1-j)) {
					result=false;
					break;
				}
				j++;
			}
			assertTrue(result);
		}


}
