/*Assignment8.java
 * October 27,2015
 * A thief breaks into a penthouse pad and collects valuables.  He doesn’t have a lot of time, so he might miss a few. 
 *  He throws them into his loot bag and rappels off the roof down to the street.  That’s a long way down!  On the way down, 
 *  he drops his bag and those valuables that are breakable, like China, break.  When he gets home he estimates the value of the haul. 
 */
 
import java.text.NumberFormat;
import java.util.Random;

public class Assignment8 {
	public static void main(String[] args) {
		Penthouse p = new Penthouse();
		p.relinquishValuables(new Diamond(10000.01));
		p.relinquishValuables(new Bond(3000));
		p.relinquishValuables(new Gold(20000));
		p.relinquishValuables(new Antique(9000));
		p.relinquishValuables(new China(4000));
		p.relinquishValuables(new Cash(40000));
		p.relinquishValuables(new China(2000));
		p.relinquishValuables(new Antique(5000));
		p.printCurrency();
		Thief t = new Thief();
		t.getaBag().loot(p.robbery());
		t.getaBag().breakAllValuables();
		p.printCurrency();
		t.getaBag().printContents();
	}
}
		
abstract class Valuable {
	private NumberFormat sign;
	private String w;
	
	//constructor
	public Valuable(double worth) {
		sign = NumberFormat.getCurrencyInstance();
		w = sign.format(worth);
	}

	/* setWorth(double)
	 * Method Type:void
	 * Parameters: double
	 * Purpose: passes in a double then changes that double with a dollar sign into a String
	 */
	public void setWorth(double wor) {
		w = sign.format(wor);
	}
		
	/* getWorth()
	 * Method Type:String
	 * Parameters:0
	 * Purpose: returns the String with a dollar sign.
	 */
	public String getWorth() {
		return w;
	}

}

class Cash extends Valuable {
	//constructor
	public Cash(double w) {
		super(w);
	}

	/* toString()
	 * Method Type: String
	 * Parameters:0
	 * Purpose: Returns a String with cash and how much it is worth (getter function)
	 */
	public String toString() {
		return ("This is cash and it is worth " + getWorth());
	}
}

class Bond extends Valuable {
	//constructor
	public Bond(double w) {
		super(w);
	}
	
	/* toString()
	 * Method Type: String
	 * Parameters:0
	 * Purpose: Returns a String with bond and how much it is worth (getter function)
	 */
	public String toString() {
		return ("This bond is worth " + getWorth());
	}
}

class Gold extends Valuable {
	//constructor
	public Gold(double w) {
		super(w);
	}

	/* toString()
	 * Method Type: String
	 * Parameters:0
	 * Purpose: Returns a String with gold and how much it is worth (getter function)
	 */
	public String toString() {
		return ("This gold is worth " + getWorth());
	}
}

class China extends Valuable implements Breakable {
	//constructor
	public China(double w) {
		super(w);
	}

	/* toString()
	 * Method Type: String
	 * Parameters:0
	 * Purpose: Returns a String with china and how much it is worth (getter function)
	 */
	public String toString() {
		return ("The china is worth " + getWorth());
	}

	/* breakIt()
	 * Method Type: void
	 * Parameters:0
	 * Purpose: breaks the items and sets it to 0.
	 */
	public void breakIt() {
		setWorth(0);
	}
}

class Antique extends Valuable implements Breakable {
	//constructor
	public Antique(double w) {
		super(w);
	}
	
	/* toString()
	 * Method Type: String
	 * Parameters:0
	 * Purpose: Returns a String with antique and how much it is worth (getter function)
	 */
	public String toString() {
		return ("This antique is worth " + getWorth());
	}

	/* breakIt()
	 * Method Type: void
	 * Parameters:0
	 * Purpose: breaks the items and sets it to 0.
	 */
	public void breakIt() {
		setWorth(0);
	}
}

class Diamond extends Valuable {
	//constructor
	public Diamond(double w) {
		super(w);
	}
	
	/* toString()
	 * Method Type: String
	 * Parameters:0
	 * Purpose: Returns a String with diamond and how much it is worth (getter function)
	 */
	public String toString() {
		return ("The diamond is worth " + getWorth());
	}
}

class Jade extends Valuable {
	//constructor
	public Jade(double w) {
		super(w);
	}

	/* toString()
	 * Method Type: String
	 * Parameters:0
	 * Purpose: Returns a String with jade and how much it is worth (getter function)
	 */
	public String toString() {
		return ("The jade is worth " + getWorth());
	}
}

	/* breakIt()
	 * Method Type: void
	 * Parameters:0
	 * Purpose: breaks the items and sets it to 0.
	 */
interface Breakable {
	public void breakIt();
}

class Penthouse {
	private NumberFormat sign;
	private Valuable[] v, va;
	private int counter;
	private final int maxValuables;
	private Random r;

	//constructor
	public Penthouse() {
		maxValuables = 10;
		r = new Random();
		counter = 0;
		v = new Valuable[maxValuables];
		sign = NumberFormat.getCurrencyInstance();
	}

	/* printCurrency()
	 * Method Type: void
	 * Parameters: 0
	 * Purpose: Prints the items inside the penthouse.
	 */
	public void printCurrency() {
		System.out.println("The Penthouse has ");
		for (int i = 0; i < counter; i++) {
			if (v[i] != null) {
				System.out.println(v[i]);
			}
		}
	}
		
	/*relinquishValuables(Valuable) 
	 * Method Type: void
	 * Parameters: an instance Valuable
	 * Purpose: passes an instance of Valuable and if the counter is less than the maximum number of
	 * items in the array then add that item to the array.
	 */
	public void relinquishValuables(Valuable value) {
		if (counter < maxValuables) {
			v[counter++] = value;
		}
	}
		
	/* robbery()
	 * Method Type: Array of Valuable
	 * Parameters: 0
	 * Purpose: Generates a random number of items the thief steals, minimum of 1, then generates another random number
	 * of which items the thief steals, sets it to null and once finishes returns the array.
	 */
	public Valuable[] robbery() {
		int next = 1+r.nextInt(counter);
		int steal;
		va = new Valuable[next];
		for (int i = 0; i < next; i++) {
			do{
				steal = r.nextInt(counter);
			}while(v[steal] ==null); 
			
			va[i] = v[steal];
			v[steal] = null;
		}
		return va;
	}
}

class LootBag {
	private Valuable[] va;
	private int maxva;
	
	//constructor
	public void loot(Valuable[] value) {
		maxva = value.length;
		va = new Valuable[maxva];

		for (int i = 0; i < value.length; i++) {
			va[i] = value[i];			
		}
	}

	/* printContents()
	 * Method Type: void
	 * Parameters: 0
	 * Purpose: Prints out the array.
	 */
	public void printContents() {
		System.out.println("The bag has ");
		for (int i = 0; i < va.length; i++) {
			System.out.println(va[i]);
		}
	}

	/* breakAllValuables()
	 * Method Type: void
	 * Parameters: 0
	 * Purpose: Goes thru the array and checks the array if the items inside of it are able to access 
	 * the function.
	 */
	public void breakAllValuables() {
		for (int i = 0; i < va.length; i++) {
			if (va[i] instanceof Breakable) {
				Breakable b = (Breakable) va[i];
				b.breakIt();
			}
		}
	}
}

class Thief {
	private LootBag lb;
	//constructor
	public Thief() {
		lb = new LootBag();
	}

	/* getaBag()
	 * Method Type: Lootbag
	 * Parameters:0
	 * Purpose: returns the lootbag
	 */
	public LootBag getaBag() {
		return lb;
	}
}