/*Assignment6.java
 * October 14, 2015
 * Simulation of beer drinking football fans and the security guards that love them.
 */
 
public class Assignment6 {
	public static void main(String[] args) {
			// declare instances
		StadiumSecurity bob = new StadiumSecurity("Bob", "Marino");
		SixPack s = new SixPack();
		NFLFan steve = new NFLFan("Steve", "Harris");
		NFLFan rick = new NFLFan("Rick", "Newhouse");
			//Testing almost all the possibilities 
		System.out.println(s);
		steve.drinkBeer(s.getaBeer());
		System.out.println(bob);
		System.out.println(steve);
		System.out.println(s);

		steve.drinkBeer(s.getaBeer());
		System.out.println(s);
		steve.drinkBeer(s.getaBeer());
		System.out.println(steve);
		System.out.println(s);
		bob.challengebeerDrinker(steve);
		System.out.println(bob);
		
		rick.drinkBeer(s.getaBeer());
		System.out.println(rick);
		System.out.println(s);
		rick.drinkBeer(s.getaBeer());
		System.out.println(rick);
		System.out.println(s);
		rick.drinkBeer(s.getaBeer());
		System.out.println(rick);
		System.out.println(s);
		rick.drinkBeer(s.getaBeer());
		steve.drinkBeer(s.getaBeer());
		System.out.println(rick);
		System.out.println(steve);
		System.out.println(s);

		bob.challengebeerDrinker(rick);
		System.out.println(bob);
	}
}

class Beer {
	private boolean status;	
	//constructor
	public Beer() {
		status = true;
	}	
	/*trackBeer()
	 * Method Type: boolean
	 * Parameters: none
	 * Purpose: returns a boolean that checks if the beer is full(true) or empty(false)
	 */
	public boolean trackBeer() {
		return status;
	}	
	/*DrinkBeer(boolean)
	 * Method Type: void
	 * Parameters: boolean
	 * Purpose: passes a boolean in and sets that boolean to status.
	 */	
	public void DrinkBeer(boolean b) {
		status = b;
	}
}

class SixPack {
	private Beer[] sixPack;
	private int counter, counter2;			
	//Constructor		 
	public SixPack() {
		sixPack = new Beer[6];
		for (int i = 0; i < 6; i++) {
			sixPack[i] = new Beer();
		}
		counter = sixPack.length;
		counter2 = sixPack.length;
	}
	/*getaBeer()
	 * Method Type: boolean
	 * Parameters:none
	 * Purpose: returns a boolean(false) of the array in the counter if counter2 is greater 
	 * than 0 and subtracts counter and counter2 by 1 to check if there is beer still left 
	 * in the six pack else it would return true.
	 */
	public boolean getaBeer() {
		if (counter2 > 0) {
			sixPack[counter - 1].DrinkBeer(false);
			counter--;
			counter2--;
			return sixPack[counter].trackBeer();
		} else {
			return true;
		}
	}
	/*toString()
	 * Method Type:String
	 * Parameters:none
	 * Purpose: returns a string that counts how much beer is left in the six pack after it is
	 * ran with a for loop checking true for the amount of beer left.
	 */	
	public String toString() {
		int beerCount = 0;
		for (int i = 0; i < sixPack.length; i++) {
			if (sixPack[i].trackBeer()) {
				beerCount++;

			}
		}
		return ("I'm a six pack and there are " + beerCount + " beers left.");
	}
}

class Person {
	private String lname, fname;
	//constructor
	Person(String f, String l) {
		fname = f;
		lname = l;
	}
	/*getFname()
	 * Method Type:String
	 * Parameters: none
	 * Purpose: returns first name
	 */	
	public String getFname() {
		return fname;
	}
	/*getLname()
	 * Method Type: String
	 * Parameters: none
	 * Purpose: returns last name
	 */	
	public String getLname() {
		return lname;
	}
	/*toString()
	 * Method Type: String
	 * Parameters:none
	 * Purpose: returns a string with first name and last name
	 */	
	public String toString() {
		return ("My name is " + fname + " " + lname);
	}
}

class NFLFan extends Person {
	private int counter;
	//constructor
	public NFLFan(String f, String l) {
		super(f, l);
		counter = 0;
	}
	/*getBeerCount()
	 * Method Type: int
	 * Parameters:none
	 * Purpose: returns the amount of beers that a person has had
	 */	
	public int getBeerCount() {
		return counter;
	}	
	/*drinkBeer(boolean)
	 * Method Type:void
	 * Parameters:boolean
	 * Purpose: passes in a boolean and checks if it is true of false, if it is false it increments the
	 * counter by 1. If the boolean is true then there is no more beer in the sixpack.
	 */
	public void drinkBeer(boolean s) {
		if (!s) {
			counter++;
		} else {
			System.out.println("There is no more beer to drink.");
		}
	}
	/*toString()
	 * Method Type: String
	 * Parameters: None
	 * Purpose: returns a the name of the person( the  super.toString()), and the 
	 * amount of beers that person has had.
	 */	
	public String toString() {
		return (super.toString() + " I've have had " + getBeerCount() + " beer<s>");
	}
}

class StadiumSecurity extends Person {
	private int count;
	//constructor
	public StadiumSecurity(String f, String l) {
		super(f, l);
		count = 0;
	}
	/*challengebeerDrinker(NFLFan)
	 * Method Type:void
	 * Parameters:NFLFAN
	 * Purpose: passes in an NFLFan and checks how much beer they have had, 
	 * if they have had more than 2, then the count will increment by 1.
	 */	
	public void challengebeerDrinker(NFLFan nf) {
		if (nf.getBeerCount() > 2) {
			count++;
		}
	}
	/*getDrunkFans()
	 * Method Type: int
	 * Parameters:none
	 * Purpose: returns the count of drunk fans
	 */	
	public int getDrunkFans() {
		return count;
	}
	/*toString()
	 * Method Type: String
	 * Parameters: none
	 * Purpose: returns the name (super.toString()) and how manys the security guard
	 * has yelled at.
	 */
	public String toString() {
		return (super.toString() + " I'm a security guard and I've yelled at " + getDrunkFans() + " fan<s>.");
	}
}
