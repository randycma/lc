
public class StringCompression {

	public static String stringCompression(String s)
	{
		char currentChar = '0'; // dummy
		int currentCount = 0;
		StringBuilder sb = null;
		for(Character c : s.toCharArray())
		{
			if(c != currentChar)
			{
				if(sb == null)
				{
					sb = new StringBuilder();
					currentChar = c;
					
				}
				else
				{
					// mark down letter and count then reset
					sb.append(currentChar);
					sb.append(currentCount);
					
					currentChar = c;
					currentCount = 0;
				}
			}

			++currentCount;
		}
		
		sb.append(currentChar);
		sb.append(currentCount);
		
		String compressedStr = sb.toString();
		return s.length() > compressedStr.length() ? compressedStr : s;
	}
	
	// alternatively -- a bit more concise.
	public static String stringCompression2(String s)
	{
		int currentCount = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < s.length(); ++i) {
			++currentCount;
			if(i + 1 >= s.length() || s.charAt(i+1) != s.charAt(i))
			{
				// write
				sb.append(s.charAt(i));
				sb.append(currentCount);

				currentCount = 0;
			}
		}
		String compressedStr = sb.toString();
		return s.length() > compressedStr.length() ? compressedStr : s;
	}
	
	// another alternative
	public static String stringCompression3(String s)
	{
		// Check length of compressed string first before going ahead with the compression
		// So we don't have to build the string (slow) if we don't need it
		int compressedLength = 0;
		int currentCount = 0;
		for(int i=0; i < s.length(); ++i) {
			++currentCount;
			if(i + 1 >= s.length() || s.charAt(i+1) != s.charAt(i))
			{
				// count character and then number of digits in count;
				currentCount += 1 + (int)(Math.log10(currentCount)+1);
				currentCount = 0;
			}
		}
		
		if(compressedLength >= s.length())
			return s;
		
		// Otherwise just do the compression
		currentCount = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i < s.length(); ++i) {
			++currentCount;
			if(i + 1 >= s.length() || s.charAt(i+1) != s.charAt(i))
			{
				// write
				sb.append(s.charAt(i));
				sb.append(currentCount);

				currentCount = 0;
			}
		}
		String compressedStr = sb.toString();
		return s.length() > compressedStr.length() ? compressedStr : s;
	}
	
	public static void main(String[] args) {
		System.out.println(stringCompression("aabcccccaaa"));
		System.out.println(stringCompression("abcdefg"));
		
		System.out.println(stringCompression2("aabcccccaaa"));
		System.out.println(stringCompression2("abcdefg"));
		
		System.out.println(stringCompression3("aabcccccaaa"));
		System.out.println(stringCompression3("abcdefg"));
	}

}
