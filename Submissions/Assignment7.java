/*  Assignment7.java
 *  October 15, 2016
 *  Dolphins’ fans that have to work during the game are obsessed 
 *  with staying connected to their team.  So, they register for 
 *  real time alerts from an app that caters to their cravings
 *  In addition, this is to practice using abstract classes.
 */
 
import java.util.*;

public class Assignment7 {
	public static void main(String[] args) {
		SportsFan john = new DolphinsFan("john");
		SportsFan mike = new DolphinsFan("mike");
		SportsFan ray = new JetsFan("ray");
		SportsFan alice = new DolphinsFan("alice");
		SportsFan steve = new JetsFan("steve");
		Scanner in = new Scanner(System.in);

		SportsAlertsApp app = new SportsAlertsApp();
		app.registerForAlerts(john);
		app.registerForAlerts(mike);
		app.registerForAlerts(ray);
		app.registerForAlerts(alice);
		app.registerForAlerts(steve);

		for (int i = 0; i < 5; i++) {
			System.out.print("\n\nWho scored? (d or j)");
			if (in.next().equals("d"))
				app.sendOutAlert(Team.DOLPHINS);
			else
				app.sendOutAlert(Team.JETS);
		}
	}
}

//enum type for team, there are two team in this game, Jets and Dolphins
enum Team {
	DOLPHINS, JETS
}

abstract class SportsFan {
	//declaring variables
	private String name;
	private Team team;
			
	//constructor
	public SportsFan(String n, Team t) {
		name = n;
		team = t;
	}
	
	/* getName()
	 * Method Type: String
	 * Parameters:0
	 * Purpose: returns name
	 */
	public String getName() {
		return name;
	}

	/* getTeam()
	 * Method Type: Team
	 * Parameters: 0
	 * Purpose: returns the team that person belongs to.
	 */
	public Team getTeam() {
		return team;
	}
			
	/* reactsToSportsAlert(Team)
	 * Method Type: abstract void
	 * Parameters: Team
	 * Purpose: if the team passing in is equal to the team inside that class
	 * it will display the name and them cheering else it would display  groaning
	 */
	abstract public void reactToSportsAlert(Team t);
}

class DolphinsFan extends SportsFan {	
	//constructor
	public DolphinsFan(String n) {
		super(n, Team.DOLPHINS);
	}

	/* reactsToSportsAlert(Team)
	 * Method Type:  void
	 * Parameters: Team
	 * Purpose: if the team passing in is equal to the team inside that class
	 * it will display the name and them cheering else it would display  groaning
	 */	
	public void reactToSportsAlert(Team t) {
		if (t == getTeam()) {
			System.out.println(getName() + " cheers");
		} else {
			System.out.println(getName() + " groans");
		}
	}
}

class JetsFan extends SportsFan {
	//constructor
	public JetsFan(String n) {
		super(n, Team.JETS);
	}
	
	/* reactsToSportsAlert(Team)
	 * Method Type: abstract void
	 * Parameters: Team
	 * Purpose: if the team passing in is equal to the team inside that class
	 * it will display the name and them cheering else it would display  groaning
	 */
	public void reactToSportsAlert(Team t) {
		if (t == getTeam()) {
			System.out.println(getName() + " cheers");
		} else {
			System.out.println(getName() + " groans");
		}
	}
}

class SportsAlertsApp {
	//declaring variables
	private SportsFan[] sports;
	private int counter;
	private final int fans;
	
	//constructor
	public SportsAlertsApp() {
		fans = 50;
		sports = new SportsFan[fans];
		counter = 0;
	}
	
	/* registerForAlerts(SportsFan)
	 * Method Type: void
	 * Parameters: SportsFan
	 * Purpose: Passes in sports fan and if the counter is less than the
	 * number of fans, then it will store that fan in the array and add 1
	 * to the counter
	 */
	public void registerForAlerts(SportsFan f) {
		if (counter < fans) {
			sports[counter++] = f;
		}
	}

	/* sendOutAlerts(Team)
	 * Method Type: void
	 * Parameters: Team
	 * Purpose: displays what each person(the array that is stored) 
	 * will do of each team depending on the which team scored.
	 */	
	public void sendOutAlert(Team t) {
		for (int i = 0; i < counter; i++) {
			sports[i].reactToSportsAlert(t);
		}
	}
}