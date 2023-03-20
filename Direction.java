import java.io.*;

public class Direction {
	File file;
	FileInputStream in;
	BufferedInputStream bin;
	static Direction direction;
	char currentDirection;
	
	static {
		direction=new Direction();
	}
	private Direction() {
		currentDirection=' ';
		try {
		file = new File("direction.txt");
		in =new FileInputStream(file);
		bin=new BufferedInputStream(in);
		}
		catch(Exception e) {
			
		}
	}
	
	public char getCurrentDirection() {
		try {
		    int i=0;
		    while((i=bin.read())!=-1) {
		    	currentDirection=(char)i;
	    	}
		}catch(Exception e) {
			
		}
		return currentDirection;
	}
	
}
