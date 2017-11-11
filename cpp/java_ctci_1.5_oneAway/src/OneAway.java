
public class OneAway {

	public static boolean oneAway(String a, String b)
	{
		// Absolute difference of the length of the two strings should be <= 1
		int lenDiff = Math.abs(a.length() - b.length());
		if(lenDiff > 1)
			return false;
		
		int i=0;
		int j=0;
		boolean foundMismatch = false;
		for(; i < a.length() && j < b.length(); ++i, ++j)
		{
			// If the two characters are different, and string length is the same, then we need to record that
			// we've seen a difference.  If we get a second mismatch then that means they are not one away.
			
			// If the two characters are different, and string length is off by 1, 
			// we are looking for insertion/removal. Increment the longer string by 1
			// and continue comparing. If we get a second mismatch then that means they are not one away.
			
			if(a.charAt(i) != b.charAt(j))
			{
				if(foundMismatch)
					return false;
				foundMismatch = true;
				
				if(lenDiff == 1)
				{
					if(a.length() > b.length())
					{
						++i;
					}
					else
					{
						++j;
					}
				}
			}
		}
				
		// second term here is for the case where the difference is at the end of the string and the
		// for loop exits before checking it.
		return foundMismatch || (!foundMismatch && lenDiff == 1);
		
	}
	
	public static void main(String[] args) {
		System.out.println(oneAway("pale", "pale"));
		System.out.println(oneAway("pale", "ple"));
		System.out.println(oneAway("pales", "pale"));
		System.out.println(oneAway("pale", "bale"));
		System.out.println(oneAway("pale", "bake"));
		System.out.println(oneAway("pale", "labe")); // should be false
	}

}
