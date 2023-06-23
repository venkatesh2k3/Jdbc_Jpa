package sample;

import java.io.*;
import java.io.IOException;

public class File2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
/*FileOutputStream fo=new FileOutputStream("D:\\tesl.txt");
String s=("helloworld");
byte[] b=s.getBytes();
fo.write(b);
fo.close();
	}

}*/
	//specific line from file//	
		String s = " ";
		int i;
		try {
			FileReader fr = new FileReader("/home/training/Desktop/phanisha/topper.txt");
			BufferedReader br = new BufferedReader(fr);
			for (i=1;i<10;i++) {
				if (i==5) {
					s = br.readLine();
				} else
					br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Line: " + s);
	}
}
		
		 /* int i= 0;
	      try 
	      {
	    	  BufferedReader br= new BufferedReader(new FileReader("/home/training/Desktop/phanisha/topper.txt"));
	      
	     
	          while (br.readLine() != null) 
	        	  i++;
	          System.out.println(i);
	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	      return;

	      }}*/
		
		
