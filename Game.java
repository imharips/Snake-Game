
import java.util.*;
public class Game {
	static Scanner sc=new Scanner(System.in);
	Snake snake=new Snake();
	Direction direction;
	Input input;
	public char currentDirection=' ';
	public boolean isGameOver=false;
	public int difficulty;
	public void enterOptions(){
		System.out.print("\n\n\t\t\t\tChoose the size of the field : ");
		snake.boardSize=sc.nextInt();
		snake.init();
		direction=Direction.direction;
		input=new Input();
		System.out.print("\n\n\t\t\t\tChoose the difficulty\n\t\t\t\te - easy\n\t\t\t\tm - medium\n\t\t\t\th - hard");
		char diff=sc.next().charAt(0);
		switch(diff){
			case 'e':
			difficulty=600;
			break;
			case 'm':
			difficulty=400;
			break;
			case 'h':
			difficulty=200;
			break;
			default:
			difficulty=400;
		}
	}
	
	public void play() {
		input.start();
		while(!isGameOver) {
			try{
				Thread.sleep(400);
			}
			catch(Exception e){
				
			}
			
			clear();
			
			snake.print();
			
			snake.isOut();
			if(snake.isGameOver) {
				isGameOver=true;
				break;
			}
			snake.eat();
			snake.updateFruitQue();
			//System.out.println(currentDirection);
			currentDirection=direction.getCurrentDirection();
			System.out.println(currentDirection);
			snake.move(currentDirection);
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
