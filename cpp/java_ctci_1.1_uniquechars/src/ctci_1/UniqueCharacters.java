/**
 * 
 */
package ctci_1;

import java.util.HashSet;

/**
 * @author randy
 *
 */

/*
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */

public class UniqueCharacters {

	public static boolean allUnique(String s)
	{
		HashSet<Character> hs = new HashSet<Character>();
		for (Character c : s.toCharArray())
		{
			if(hs.contains(c))
			{
				return false;
			}
			hs.add(c);
		}
		return true;
	}
	
	public static boolean allUnique2(String s) // assuming all lower case, a->z
	{
		int checker = 0; // 0 all bits
		for (Character c : s.toCharArray())
		{
			int val = c - 'a';
			if((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	// if no additional datastructures allowed, then you can brute force with two indices O(n^2)
	// or sort the string (destroy it) and iterate through.

	public static void main(String[] args) {
		System.out.println(allUnique2("test"));
		System.out.println(allUnique2("abc"));
		System.out.println(allUnique2("fdsa"));
		System.out.println(allUnique2("as"));
		System.out.println(allUnique2("fewufweuif"));
	}

}
