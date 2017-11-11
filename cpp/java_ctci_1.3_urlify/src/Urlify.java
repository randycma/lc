
public class Urlify {

	public static void urlify(char[] s, int len)
	{
		int rightIdx = s.length - 1; // assuming the array has exactly the required number of trailing spaces
		int iter = len - 1;
		
		while(iter >= 0)
		{
			if(s[iter] != ' ')
			{
				s[rightIdx--] = s[iter--];
			}
			else
			{
				s[rightIdx--] = '0';
				s[rightIdx--] = '2';
				s[rightIdx--] = '%';
				--iter;
			}
		}
	}
	
	
	public static void main(String[] args) {
		String s = new String("Mr John Smith    ");
		char[] input = s.toCharArray();
		urlify(input, 13);
		System.out.println(input);
	}

}
