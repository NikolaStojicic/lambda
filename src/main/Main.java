/*
 * Created on May 9, 2018
 *
 */
package main;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		list.add("k");
		list.add("l");
		list.add("h");
		list.add("s");
		list.add("a");
		list.add("e");
		list.add("b");
		// Iterator<Object> iter = list.iterator();
		// while (iter.hasNext())
		// System.out.println(iter.next());
		//
		// for (Object obj : list)
		// System.out.println(obj);
		list.forEach(System.out::println);
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("After sort:");
		list.forEach(item -> {
			System.out.println("Sorted: " + item);
		});
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("key1", "value1");
		String value = myMap.get("key1");
		System.out.println(value);
	}
}
