
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
public class Input extends Thread{
	static Scanner sc=new Scanner(System.in);
	static File file=new File("direction.txt");
	static FileOutputStream out;
	static BufferedOutputStream bOut;
	static boolean isGameOver=false;

	public static void main(String...args) {
		try {
			out=new FileOutputStream(file);
			bOut=new BufferedOutputStream(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(!isGameOver) {
			clear();
			System.out.print("Dir - ");
			char dir=sc.next().charAt(0);
			String s=dir+"";
			try {
				bOut.write(s.getBytes());
				bOut.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	static void clear(){
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception e){
			
		}
	}
	
}
