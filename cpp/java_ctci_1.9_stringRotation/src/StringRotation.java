
public class StringRotation {

	public static boolean isSubstring(String target, String s)
	{
		// dummy, assume it works
		return true;
	}
	
	public static boolean isRotation(String s1, String s2)
	{
		/*
		 * The idea is that if s2 is a rotation of s1, then there must be a pivot point n where the
		 * rotation happens. If we concatenate s2 with itself (i.e. s2s2), we will end up rebuilding s1
		 * somewhere in the middle if s2 is a rotation of s1.  Thus we will only need to check if s1 is 
		 * a substring of s2s2 (assuming that the lengths are the same).
		 */
		if(s1.length() == s2.length() && s1.length() > 0) // should 0 length strings be true or false?
		{
			return isSubstring(s1, s2+s2);
		}
		return false;
	}

}
