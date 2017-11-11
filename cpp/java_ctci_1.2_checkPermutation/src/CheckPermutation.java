import java.util.Arrays;

public class CheckPermutation {

	// O(N)
	public static boolean checkPermutation(String a, String b)
	{
		if(a.length() != b.length())
		{
			return false;
		}
		
		int count[] = new int[256]; // initialized to 0?
		
		for(Character c : a.toCharArray())
		{
			++(count[c]);
		}
		
		for(Character c : b.toCharArray())
		{
			--(count[c]);
		}
		
		for(int i : count)
		{
			if (i != 0)
			{
				return false;
			}
		}
		return true;
	}
	
	public static String sort(String s)
	{
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	// O(n log n).  Note that .equals does not work for char[], so we use String
	public static boolean checkPermutation2(String a, String b)
	{
		if(a.length() != b.length())
		{
			return false;
		}
		
		// sort both arrays, iterate through and compare
		return sort(a).equals(sort(b));
	}
	
	public static void main(String[] args) {
		String a = new String("hello");
		String b = new String("jello");
		
		System.out.println(checkPermutation(a, b));
		System.out.println(checkPermutation2(a, b));
	}

}

