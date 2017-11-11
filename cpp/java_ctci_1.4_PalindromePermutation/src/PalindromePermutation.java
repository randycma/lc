
public class PalindromePermutation {

	public static boolean palindromePermutation(String s)
	{
		// 0 means even number of occurrences (including 0), and 1 means odd number of occurrences
		int bitMask = 0; 
		for (Character c : s.toLowerCase().toCharArray())
		{
			if(c <= 'z' && c >= 'a')
			{
				int val = c-'a';
				bitMask ^= (1 << (val));
			}
		}
		
		// check that exactly 0  bits are set or exactly 1 bit is set.
		return (bitMask == 0) || (bitMask & (bitMask - 1)) == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(palindromePermutation("hbah"));
	}

}
