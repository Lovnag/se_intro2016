public class Main{
	public static void main(String[] args)
	{
		System.out.println(polynome("basb"));
	}
	
	
	public static boolean polynome(String s)
	{
		if ( (s.length()==0) || (s.length()==1) ) 
		{
			return true;
		}
		else if ( s.charAt(0)!=s.charAt(s.length()-1)) 
		{
			return false;
		}
		else
                {
			return(polynome(s.substring(1,s.length()-1)));
		}
	}
}
