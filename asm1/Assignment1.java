/*Assignment1.java
 *August 27,2015
 *This prints certain statements if i%3 ==0 or not
 */

public class Print {
	public static void main(String[] args) {
			//for loop from 0 to 19
			for(int i =0; i<20; i++){
				//if statements for  i%3
				if(i%3 == 0){
					System.out.println("How now\nbrown cow");				
				}
				//everything else not =0 for i%3
				else{
					System.out.printf("How now ");
					System.out.println("brown cow");
				}					
			}
	}
}
