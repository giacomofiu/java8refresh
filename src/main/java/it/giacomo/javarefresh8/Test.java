package it.giacomo.javarefresh8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//from TutorialsPoint examples 
public class Test {

	
	public static void main(String[] args) {
			
	  List<String> names1 = new ArrayList<>();
	  names1.add("Mahesh ");
      names1.add("Suresh ");
      names1.add("Ramesh ");
      names1.add("Naresh ");
      names1.add("Kalpesh ");
	  
      List<String> names2 = new ArrayList<>();
      names2.add("Mahesh ");
      names2.add("Suresh ");
      names2.add("Ramesh ");
      names2.add("Naresh ");
      names2.add("Kalpesh ");
	
      Test test1 = new Test();
      //test1.sortUsingJava7(names1);
      //System.out.println("Sort using Java 7 syntax: ");
      //System.out.println(names1);
      
      test1.sortUsingJava8(names1);
      System.out.println("Sort using Java 8 syntax: ");
      System.out.println(names1);
      
      int x1 = 10;
      int x2 = 5;
      
      MathOperation additionJava7 = new MathOperation() {
		
		@Override
		public int operation(int a, int b) {			
			return a + b;
		}
	  };

      //Java 8 with type declaration
      MathOperation addition = (int a, int b) -> a + b;

      //without type declaration
      MathOperation subtraction = (a, b) -> a - b;
      
      //with return statement along with curly braces
      MathOperation multiplication = (int a, int b) -> { return a * b; };
      
      //without return statement and without curly braces
      MathOperation division = (int a, int b) -> a / b;
      
      System.out.println(x1 + " + " + x2 + " = " + test1.operate(x1, x2, addition));
      System.out.println(x1 + " - " + x2 + " = " + test1.operate(x1, x2, subtraction));
      System.out.println(x1 + " * " + x2 + " = " + test1.operate(x1, x2, multiplication));
      System.out.println(x1 + " / " + x2 + " = " + test1.operate(x1, x2, division));
      
      
      GreetingService greetingService1 = (String message) -> {System.out.println("Hello " + message);};
      
      System.out.println();
      greetingService1.sayMessage("Giacomo");
      System.out.println();
         
      //static method reference
      names1.forEach(System.out::println);
      
          
      //more functional interfaces
      List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
      // Predicate<Integer> predicate = n -> true
      // n is passed as parameter to test method of Predicate interface
      // test method will always return true no matter what value n has.
      
      System.out.println("Print all numbers:");
      eval(listInteger, n -> true);
      
      // Predicate<Integer> predicate1 = n -> n%2 == 0
      // n is passed as parameter to test method of Predicate interface
      // test method will return true if n%2 comes to be zero
      System.out.println();
      System.out.println("Print even numbers:");
      eval(listInteger, n -> (n % 2) == 0);
      

      // Predicate<Integer> predicate2 = n -> n > 3
      // n is passed as parameter to test method of Predicate interface
      // test method will return true if n is greater than 3.
      System.out.println();
      System.out.println("Print numbers greater than 3:");
      eval(listInteger, n -> (n > 3));
      
      
      System.out.println("\n");
      Car car = new Car();
      car.print();
      
      //Streams - represents a sequence of objects from a source, which supports aggregate operations
      List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
      //get count of empty string
      List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
	  for(String str : filtered) {
		  System.out.print(str + " ");
	  }
	  
      
      List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
      //get list of unique squares
      List<Integer> squareList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
      System.out.println("\n");
      System.out.println("List of unique squares:");
      for(Integer in : squareList) {
		  System.out.print(in + " ");
	  }
      
      System.out.println("\n");
      //print 10 random numbers using limit
      Random random = new Random();
      //random.ints().limit(10).forEach(System.out::println);
      //anche .forEach(i -> System.out.println(i))
      
      //print 10 random numbers using limit in a sorted order
      System.out.println("Print ten random numbers in a sorted order:");
      //you can put also intCons inside forEach instead of System.out::println
      IntConsumer intCons = i -> System.out.println(i); 
      random.ints().limit(10).sorted().forEach(System.out::println);
      
      
      System.out.println("\n");
      //parallelStream
      long count = strings.parallelStream().filter(str -> str.isEmpty()).count();
      System.out.println("Count of empty strings: " + count);

      System.out.println("\n");
      //Collectors can be used to return a list or a string
      System.out.println("Filtered List: " + filtered);
	  String mergedString = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(", "));
	  System.out.println("Merged List: " + mergedString);
	  
	  
	  //Statistics
	  IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
	  System.out.println("\n");
	  System.out.println("Highest number in list: " + stats.getMax());
	  System.out.println("Lowest number in list: " + stats.getMin());
	  System.out.println("Sum of all numbers in list: " + stats.getSum());
	  System.out.println("Average of all numbers in list: " + stats.getAverage());
	  
	  
	  
	  //sort hashmap by keys
	  Map<Integer, String> mapToSort = new HashMap<>();
	  mapToSort.put(55, "John");
      mapToSort.put(22, "Apple");
      mapToSort.put(66, "Earl");
      mapToSort.put(77, "Pearl");
      mapToSort.put(12, "George");
      mapToSort.put(6, "Rocky");
      
      List<Entry<Integer, String>> entriesList = new ArrayList<>(mapToSort.entrySet());
      //with Java 7
//      Collections.sort(entriesList, new Comparator<Map.Entry<Integer, String>>() {
//
//			@Override
//			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
//				
//				return o1.getKey().compareTo(o2.getKey());
//			}
//      });
      //with Java 8
      //Last code of 2020!!!!!!!!!!
      Comparator<Entry<Integer, String>> comp = (o1, o2) -> o1.getKey().compareTo(o2.getKey());
      Collections.sort(entriesList, comp);
      //also direct way
      //Collections.sort(entriesList, (Entry<Integer, String> o1, Entry<Integer, String> o2) -> o1.getKey().compareTo(o2.getKey()));
      Map<Integer, String> orderedMap = new LinkedHashMap<>();
      for(Entry<Integer, String> entry : entriesList) {
    	  orderedMap.put(entry.getKey(), entry.getValue());
      }
      //print
      System.out.println("\n");
      System.out.println("Map ordered by keys:");
      for(Entry<Integer, String> entry : orderedMap.entrySet()) {
    	  System.out.println(entry.getKey() + " " + entry.getValue());
      }

      //sorting hashmap by values with stream
      System.out.println("Sorting hashmap by values with stream:");
      mapToSort.entrySet().stream().sorted(Map.Entry.<Integer, String>comparingByValue()).forEach(System.out::println);
      //by keys: Map.Entry.<Integer, String>comparingByKey()

      
      //Collectors toMap() - from Baeldung examples
      List<Book> bookList = new ArrayList<Book>();
      bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
      bookList.add(new Book("The Two Towers", 1954, "0345339711"));
      bookList.add(new Book("The Return of the King", 1955, "0618129111"));
      
      Map<String, String> bookMap = bookList.stream().collect(Collectors.toMap(Book::getIsbn, Book::getName));
      System.out.println("Book list converted to map:");
      bookMap.entrySet().stream().forEach(System.out::println);
      
      //Solving key conflict
      //this will cause IllegalStateException
      //Map<Integer, Book> bookMapByYear = bookList.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity()));
      //you have to use a third parameter, the mergeFunction that indicates that, in the case of a collision, we keep the existing entry:
      Map<Integer, Book> bookMapByYear = bookList.stream().collect(Collectors.toMap(Book::getReleaseYear, Function.identity(), (existing, replacement) -> existing));
      System.out.println("Book list converted to map keyed by releasedYear:");
      bookMapByYear.entrySet().stream().forEach(book -> System.out.println(book.getValue().getReleaseYear() + " " + book.getValue().getName()));
      
      
      //store stream in reference
	  Stream<String[]> str = Stream 
					.of(new String[][] { { "GFG", "GeeksForGeeks" }, 
										{ "g", "geeks" }, 
										{ "GFG", "geeksforgeeks" } }); 
	
	  // Get Map from String 
	  // using toMap() method and solving key conflicts
	  //you can store a lambda expression in a variable, you have to match parameters<K,V,etc.> as where you will want to use it  
	  Function<String[], String> keyMapper = p -> p[0];
	  Map<String, String> 
	  		map = str 
					.collect(Collectors 
								.toMap(p -> p[0], p -> p[1], (s, a) -> s + ", " + a)); //seems that s and a are two values that shares same key
	  								  //here you can set keyMapper instead of direct lambda expression
	  // Print the Map 
	  System.out.println();
	  System.out.println("GeeksForGeeks Map:" + map);
	}
	
	
	
	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {				
				return s1.compareTo(s2);
			}			
		});
	}
		
	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	
	private interface MathOperation {
		int operation(int a, int b);
	}
	
	interface GreetingService {
		void sayMessage(String message);
	}
	
	private static void eval(List<Integer> list, Predicate<Integer> predicate) {
		
		for(Integer n : list) {
			if (predicate.test(n)) {
				System.out.print(n + " ");
			}
		}
	}
	
	
	private int getCountEmptyStringUsingJava7(List<String> strings) {		
		int count = 0;
		for(String s : strings) {
			count = s.isEmpty() ? (count++) : count; 
		}
		return count;
	}
	
	
	private int getCountLength3UsingJava7(List<String> strings) {
		int count = 0;
		for(String s : strings) {
			if(s.length() == 3) {
				count += 1;
			}
		}
		return count;
	}

	private List<String> deleteEmptyStringsUsingJava7(List<String> strings){
		List<String> filteredList = new ArrayList<>();
		for(String s : strings) {
			if(!s.isEmpty()) {
				filteredList.add(s);
			}
		}
		
		return filteredList;
	}
	
	
	private String getMergedStringUsingJava7(List<String> strings, String separator){
		StringBuilder sbuild = new StringBuilder();
		for(String s : strings) {
			if(!s.isEmpty()) {
				sbuild.append(s);
				sbuild.append(separator);
			}
		}
		
		String mergedString = sbuild.toString();
		
		//because of separator character at ending
		return mergedString.substring(0, mergedString.length()-2);
	}
	
	
   private List<Integer> getSquares(List<Integer> numbers) {
	      List<Integer> squaresList = new ArrayList<Integer>();
			
	      for(Integer number: numbers) {
	         Integer square = new Integer(number.intValue() * number.intValue());
				
	         if(!squaresList.contains(square)) {
	            squaresList.add(square);
	         }
	      }
	      return squaresList;
	   }


   private Integer getMax(List<Integer> numbers) {
	   Integer max = numbers.get(0);
	   for(int i = 1; i<numbers.size(); i++) {
		   Integer num = numbers.get(i);
		   if(num > max) {
			   max = num;
		   }
	   }
	   
	  return max; 
   }

   private Integer getMin(List<Integer> numbers) {
	   Integer min = numbers.get(0);
	   for(int i = 1; i<numbers.size(); i++) {
		   Integer num = numbers.get(i);
		   if(num < min) {
			   min = num;
		   }
	   }
	   
	  return min; 
   }


   private Integer getSum(List<Integer> numbers) {
	      Integer sum = numbers.get(0);
			
	      for(int i = 1; i < numbers.size(); i++) {
	         sum += numbers.get(i);
	      }
	      return sum;
	   } 

   
   private Integer getAverage(List<Integer> numbers) {
	      return getSum(numbers) / numbers.size();
	   }   


}
