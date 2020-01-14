package co.arum.generic;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		GenericTest<String> testString = new GenericTest<String>();
		testString.set("TOT");
		System.out.println(testString.get());
		
		GenericTest<Integer> testInteger = new GenericTest<Integer>();
		testInteger.set(8);
		System.out.println(testInteger.get() + 69);
		
//		List<int> list = new ArrayList<int>();
	}

}
