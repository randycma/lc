
public class PalindromePermutation {

	public static boolean palindromePermutation(String s)
	{
		int count[] = new int['z'-'a'+1];
		
		int countOdd = 0;
		for (Character c : s.toLowerCase().toCharArray())
		{
			if(c <= 'z' && c >= 'a')
			{
				++count[c-'a']; // ignores everything that's not in alphabet (whitespace, numbers, etc.)
				if(count[c-'a'] % 2 == 1) // is odd
				{
					++countOdd;
				}
				else
				{
					--countOdd;
				}
			}
		}
		
		// if countOdd is 0 or 1, then we return true
		return countOdd <= 1;
	}
	
	public static void main(String[] args) {
		System.out.println(palindromePermutation("abbba"));

	}

}
