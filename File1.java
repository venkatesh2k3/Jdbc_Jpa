package sample;

import java.io.*;

public class File1 {
	public static void main(String[] args) throws Exception {
		/*
		 * File f=new File("D:\\tesl.txt "); if(f.createNewFile()) {
		 * System.out.println("created"); } } }
		 */
		try {

//		FileOutputStream fo = new FileOutputStream("/home/training/Desktop/phanisha/topper.txt");
//		String s = "hello world";
//		byte[] b = s.getBytes();
//		fo.write(b);
//		fo.close();
//		System.out.println("Done...");
//	}catch(Exception e) {
//		e.printStackTrace();
//	}

//FileInputStream fi= new FileInputStream("D:\\tesl.txt");
//int i= fi.read();
//System.out.println((char)i);
//fi.read();
//fi.close();
//}
//}

//	FileInputStream fi= new FileInputStream("/home/training/Desktop/phanisha/topper.txt");
//	int i;
//	while((i=fi.read())!=-1){
//		System.out.print((char)i);
//	}
//	fi.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//}
//}
//			 FileOutputStream fo= new  FileOutputStream(("/home/training/Desktop/phanisha/topper.txt"));
//			BufferedOutputStream bo = new BufferedOutputStream( fo);
//			String s = "hello world";
//			byte[] b = s.getBytes();
//			bo.write(b);
//			bo.close();
//			System.out.println("Done...");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}		
//}
//}

			FileInputStream fi = new FileInputStream("/home/training/Desktop/phanisha/topper.txt");
			BufferedInputStream bi = new BufferedInputStream(fi);
			int i;
			while ((i = bi.read()) != -1) {
				System.out.print((char) i);
			}
			bi.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
//	 reader 		
			/*
			 * Reader r = new FileReader(("/home/training/Desktop/phanisha/topper.txt"));
			 * int i = r.read(); while (i != -1)
			 *  {
			 *   System.out.print((char)i); i= r.read(); 
			 *   }
			 * r.close(); 
			 * } catch (Exception e) 
			 * {
			 *  e.getMessage();
			 *  } 
			 *  } 
			 *  }
			 */
//			
			FileInputStream fi1 = new FileInputStream("/home/training/Desktop/phanisha/topper.txt");
			DataInputStream di = new DataInputStream(fi1);
			BufferedReader br = new BufferedReader(new InputStreamReader(di));
			FileOutputStream fo = new FileOutputStream("/home/training/Desktop/phanisha/vowels.txt");
			BufferedOutputStream bi1 = new BufferedOutputStream(fo);
			FileOutputStream fo1 = new FileOutputStream("/home/training/Desktop/phanisha/consonants.txt");
			BufferedOutputStream bo1 = new BufferedOutputStream(fo1);
			String s = br.readLine();
			char ch;
			for (int j = 0; j < s.length(); j++) {
				ch = s.charAt(j);
				if ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u') || (ch == 'A')
						|| (ch == 'E') || (ch == 'I') || (ch == 'O') || (ch == 'U')) {
					bi1.write(ch);
				} else {
					bo1.write(ch);

				}

			}
			bi1.close();
			bo1.close();
			System.out.println("done");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
