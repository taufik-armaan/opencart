package opencart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OccuranceOfChara {

	public static void main(String[] args) {

		
		String s1= "selenium";

		int totalCount = s1.length();
		
		int totalCountAfterRemove = s1.replaceAll("e","").length();
		int count = totalCount-totalCountAfterRemove;
		System.out.println(count);
		
	}
}
		