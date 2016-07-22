/*Assignment5.java
 * October 7, 2015
 * Simulation using toString() and enum.
 */

import java.util.*;
public class Assignment5 {
	public static void main(String[] args) {
		Donut d = new Donut();
		int[] z= new int [5];
		int counter  =0, temp = 0;
		while(counter <5){
			z[counter++]=d.RandomFilling();
		}
		LazySusan l =new LazySusan();		
		for(int i = 0; i<5; i++){
			temp = z[i];
			System.out.println(z[i]);
			System.out.println(l);
			//l.Randomizer(d.RandomFilling());
		}
	}
}

enum Filling{
	CREME, STRAWBERRY, GRAPE, APPLE, CINNAMON, BLUEBERRY, BANANA
}

class Elvis{
	private LazySusan lS;
	private Donut [] donut2;
	public Elvis(){
		lS= new LazySusan();
		donut2 = new Donut [5];
	}	
	public String toString(){
		return ("a "+ Filling.values() +" " );
	}	
}

class Donut{
	private int don ;
	public Donut(){}
	
	public String toString(){		
		return ("a " + Filling.values()[don] + " filled donut" );
	}
	public int RandomFilling(){
		Random rnd = new Random();
		int x = rnd.nextInt(Filling.values().length);
		don= x;
		return don;			
	}
}

class LazySusan{
	private Donut [] donut1;
	private int[] x = new int [5];
	private int temp;
	public LazySusan(){
		donut1= new Donut[5];
		for(int i =0; i< donut1.length; i++){
			donut1[i]= new Donut();
		}
	}
	public String toString(){
		return ("a " + Filling.values()[temp] + " filled donut");		
	}
	public void Randomizer(Donut[] donut1){
		for(int i =0; i < donut1.length; i++){
			x[i]= donut1[i];
		}	
	}
}
