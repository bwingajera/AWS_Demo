import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo {

	
/*	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		String bigString=scanner.next();
		String smallString=scanner.next();
		searchAnagramSubstring(bigString, smallString);
		for (int i = 0; i < bigString.length(); i++) {			
			String second="";
			
			second=bigString.substring(i, bigString.length());
			System.out.println(second);
			for (String string : args) {
				
			}
		}
		
		
	}*/
	static boolean compareArr(int[] countTXT,int[] countPATT)
	{
		for(int i=0; i<256; i++)
		{
			if(countTXT[i]!=countPATT[i])
			 return false;
		}
		return true;
	}
	static void search(String patt, String txt)
	{
		int countTXT[] = new int[256];
		int countPATT[] = new int[256];
 
		for(int i=0; i<patt.length(); i++)
        {
        	countTXT[txt.charAt(i)]++;
        	countPATT[patt.charAt(i)]++;
        }
        for(int i=patt.length(); i<txt.length(); i++)
        {
        	if(compareArr(countTXT,countPATT)==true)
        	 System.out.print((i-patt.length())+" ");
 
        	countTXT[txt.charAt(i)]++;
        	countTXT[txt.charAt(i-patt.length())]--;
        }
        if(compareArr(countTXT,countPATT)==true)
        	 System.out.print("Connt"+(txt.length()-patt.length())+" dddd");
	}    
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String txt = br.readLine();
		String patt = br.readLine();
		search(patt, txt);
	}
}
