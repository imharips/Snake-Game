import java.util.*;
public class Snake {
	//static Scanner sc=new Scanner(System.in);
	public int boardSize;
	public String field[][];
	public int fruitPos[];
	public LinkedList<int[]> snakePos;
	public LinkedList<int[]> fruitQue;
	public String snakeHead;
	public boolean isGameOver;
	
	
	public void init() {
		
		field=new String[boardSize][boardSize];
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++) {
				if((i==0 && j==0) || (i==0 && j==boardSize-1) || (i==boardSize-1 && j==0) || (i==boardSize-1 && j==boardSize-1))
					field[i][j]="+";
				else if(i==0 || i==boardSize-1) 
					field[i][j]="-";
				else if(j==0 || j==boardSize-1)
					field[i][j]="|";
				else 
					field[i][j]=" ";
			}
		}
		
		fruitPos=new int[] {2,6};
		field[2][6]="x";
		snakePos=new LinkedList<>();
		snakePos.add(new int[] {1,4});
		snakePos.add(new int[] {1,3});
		snakePos.add(new int[] {2,3});
		snakePos.add(new int[] {2,2});
		snakeHead=">";
		field[1][4]=">";
		field[1][3]="0";
		field[2][3]="0";
		field[2][2]="0";
		
		fruitQue=new LinkedList<>();
		isGameOver=false;
		
	}
	
	
	
	public void print() {
		int index=0;
		int size=snakePos.size();
		System.out.println("\n\n\n\n\n");
		for(int i=0;i<boardSize;i++) {
			System.out.print("\t\t\t\t");
			for(int j=0;j<boardSize;j++){
				System.out.printf("%2s",field[i][j]);
			}
			System.out.println();
		}
	}
	
	public void eat() {
		
		int head[]=snakePos.getFirst();
		if(head[0]==fruitPos[0] && head[1]==fruitPos[1]){
			fruitQue.add(fruitPos);
			generateNewFruitPosition();
		}
	}

	public void generateNewFruitPosition(){
		int[] newFruitPos={(int)((Math.random()*(boardSize-2-1))+1),(int)((Math.random()*(boardSize-2-1))+1)};
		while(!field[newFruitPos[0]][newFruitPos[1]].equals(" ")){
			newFruitPos[0]=(int)((Math.random()*(boardSize-2-1))+1);
			newFruitPos[1]=(int)((Math.random()*(boardSize-2-1))+1);
		}
		fruitPos=newFruitPos;
		field[fruitPos[0]][fruitPos[1]]="x";
	}
	
	public void isOut() {
		
		int head[]=snakePos.getFirst();
		int tail[]=snakePos.getLast();
		int snakeSize=snakePos.size();
		if(head[0]==0 || head[1]==0 || head[0]==boardSize-1 ||  head[1]==boardSize-1) {
			isGameOver=true;
			return ;
		}
		for(int i=1;i<snakeSize;i++) {
			
			int curr[]=snakePos.get(i);
			if(head[0]==curr[0] && head[1]==curr[1]) {
				isGameOver=true;
				return;
			}
			
		}
		return;
	}
	
	public void move(char dir) {
		int newHead[];
		int curHead[]=snakePos.getFirst();
		int tail[]=snakePos.getLast();
		//System.out.println("in move");
		switch(dir) {
		
		case 'w':
		
			//System.out.println("up");
			newHead=new int[] {curHead[0]-1,curHead[1]};
			snakeHead="^";
			field[curHead[0]][curHead[1]]="0";
			field[tail[0]][tail[1]]=" ";
			field[newHead[0]][newHead[1]]=snakeHead;
			snakePos.addFirst(newHead);
			snakePos.removeLast();
			
			break;
			
		case 's':
		
			//System.out.println("down");
			newHead=new int[] {curHead[0]+1,curHead[1]};
			snakeHead="v";
			field[curHead[0]][curHead[1]]="0";
			field[tail[0]][tail[1]]=" ";
			field[newHead[0]][newHead[1]]=snakeHead;
			snakePos.addFirst(newHead);
			snakePos.removeLast();
			
			break;
			
		case 'a':
		
			//System.out.println("left");
			newHead=new int[] {curHead[0],curHead[1]-1};
			snakeHead="<";
			field[curHead[0]][curHead[1]]="0";
			field[tail[0]][tail[1]]=" ";
			field[newHead[0]][newHead[1]]=snakeHead;
			snakePos.addFirst(newHead);
			snakePos.removeLast();
			
			break;
			
		case 'd':
			
			newHead=new int[] {curHead[0],curHead[1]+1};
			snakeHead=">";
			field[curHead[0]][curHead[1]]="0";
			field[tail[0]][tail[1]]=" ";
			field[newHead[0]][newHead[1]]=snakeHead;
			snakePos.addFirst(newHead);
			snakePos.removeLast();
			
			break;
		}
	}
	
	public static boolean isValidMove(char currentDirection,char newDirection) {
		
		switch(currentDirection) {
		case 'w':
			if(newDirection=='s')
				return false;
			break;
		case 's':
			if(newDirection=='u')
				return false;
			break;
		case 'a':
			if(newDirection=='d')
				return false;
			break;
		case 'd':
			if(newDirection=='a')
				return false;
			break;
		}
		return true;
	}
	
	public void updateFruitQue() {
		if(fruitQue.size()==0) {
			return;
		}
		int tail[]=snakePos.getLast();
		int fruitInQue[]=fruitQue.getFirst();
		if(tail[0]==fruitInQue[0] && tail[1]==fruitInQue[1]) {
			snakePos.add(new int[] {fruitInQue[0],fruitInQue[1]});
			fruitQue.removeFirst();
		}
	}
}
