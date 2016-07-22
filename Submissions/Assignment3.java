/*Assignment3.java
 *September 15, 2015
 *This java program will calculate the score of the first frame of a game of bowling.
 *If you don’t bowl, scoring is actually quite complicated
 */

import java.util.Random;

public class bowlRandom {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		int x1 = ran.nextInt(11);
		int score=0;
		int x2=0;
		int x3=0;
		
		if(x1<10){
			x2 = ran.nextInt(11-x1);
			if((x1+x2)<10){
				score=x1+x2;
			} else {
				x3 = ran.nextInt(11);
				score = x1+x2+x3;					
			}
		} else {
			x2 = ran.nextInt(11-x1);
			if(x2<10) {
				x3 = ran.nextInt(11-x2);
				score=x1+x2+x3;
			} else {
				x3 = ran.nextInt(11);
				score=x1+x2+x3;
			}	
		}
		
		System.out.println ("first =" + x1);
		System.out.println ("second =" + x2);
		if(x1+x2==10){
			System.out.println ("third =" + x3);
		}		
		System.out.println("Score is " + score);
	}
}
