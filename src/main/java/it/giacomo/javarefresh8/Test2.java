package it.giacomo.javarefresh8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		List<String> listBookString = new ArrayList<>();
		listBookString.add("Vipp");
		listBookString.add("Cap Crunch");
		listBookString.add("Whirlwind");
		listBookString.add("Wilderness");
		
		//with java 7
		Collections.sort(listBookString, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});

	for(String book : listBookString) {
		//System.out.println("book: " + book);
	}
	
	//with java 8
	Collections.sort(listBookString, (o1, o2) -> o1.compareTo(o2));
	listBookString.forEach(System.out::println);
	
	//do something with streams
	List<String> listBookFiltered = listBookString.stream().filter(book -> book.startsWith("W")).collect(Collectors.toList());
	listBookFiltered.forEach(s1 -> System.out.println("books with W: " + s1));
	
	}

}
