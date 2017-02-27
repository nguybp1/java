/* JavaGamev6.java
 * Brandon Nguyen
 * Nishant Thomas
 * COP1210C
 * Professor Michelle Levine
 * Nov 21, 2016
 * Team Project Team 6
 * Who Wants to Be a Java Programmer? v.6 (Java Quiz game)
 * Requirements:
 * . add 1 more question/answer set from Chapter 7
 * . parallel arrays of size 10: questionArray[], answerA[], answerB[], answerC[], answerD[], correctAnswer[], pointValue[] 
 * . for loop store read data from file into parallel arrays
 * . parallel arrays of size 3: highNames[3], highScores[3]
 * . Modify “highscore.txt” to includes three names and three scores (John 3, Jane 2, Joe 1)
 * . public static void ReadInHighScores(string[] name, int[] score) store values in parallel highNames[3] and highScores[3]
 * . public static void CompareScores(int userScore, string userName, string[] name, int[] score) compare with parallel arrays
 * . public static void UpdateHighScores(string[] highName, int[] highScore) update “highscore.txt” with names and scores from arrays
 */

// Import JOptionPane, Scanner, Arrays, io
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class JavaGamev6 {

	public static void main(String[] args) throws IOException {
		// Declare and initialize variables
		String userName;
		int totalScore=0,questionLine=7,questionSet=9;
		char userInput; 
		final int SIZE = 10;
		// Declare parallel arrays
		String[] questionArray=new String[SIZE];
		String[] answerA=new String[SIZE];
		String[] answerB=new String[SIZE];
		String[] answerC=new String[SIZE];
		String[] answerD=new String[SIZE];
		char[] correctAnswer=new char[SIZE];
		int[] pointValue=new int[SIZE];
		String[] highNames=new String[3];
		int[] highScores=new int[3];
		
		// Display an Introduction to the Game using DialogBox
		JOptionPane.showMessageDialog(null, "Who Wants to Be a Java Programmer? v.6\n");
		// Display DialogBox to prompt for userName
		userName = JOptionPane.showInputDialog("Please, enter your name: ");
		
		// Display main menu in DialogBox using do while loop
		do {
			// Call DisplayMainMenu()
			userInput = DisplayMainMenu();

			// Decision structure for menu using switch
			switch(userInput){
				
				// If user select option 1 (See Rules), display DialogBox with rules for game
				case '1':			
					// Call DisplayRules()
					DisplayRules();
					
					break; // break for case 1
						
				// If user select option 2 (Play Game), display DialogBox with questions/answers
				case '2':
					// Reset totalScore
					totalScore=0;
					
					// Open myFile and read data into inFile
					File myFile = new File("questions.txt");
					Scanner inFile = new Scanner(myFile);
					
					// External for loop to keep track of question sets
					for(int i=0;i<questionSet;i++){
						// Internal for loop to loop through line by line
						for(int j=0;j<questionLine;j++){
							// Read a line from inFile into str 
							String str = inFile.nextLine();
							if(j==0)
								// Assign question to questionArray
								questionArray[i] = str;
							if(j==1)
								// Assign answer A to answerA
								answerA[i] = str;
							if(j==2)
								// Assign answer B to answerB
								answerB[i] = str;
							if(j==3)
								// Assign answer C to answerC
								answerC[i] = str;
							if(j==4)
								// Assign answer D to answerD
								answerD[i] = str;
							if(j==5)
								// Assign correct answer to correctAnswer
								correctAnswer[i] = str.charAt(0);
							if(j==6)
								// Assign point to pointValue
								pointValue[i]=Integer.parseInt(str);
						} // end internal for loop
					} // end external for loop
					// Accumulate totalScore
					totalScore=ProcessQuestion(questionArray, answerA, answerB, answerC, 
							answerD, correctAnswer, pointValue);
					// Call DisplayScore()
					DisplayScore(totalScore);
					// Close the question/answers file. 
					inFile.close();
					// Get highNames and highScores
					ReadInHighScores(highNames,highScores);
					// Compare highNames and highScores through CompareScores()
					CompareScores(totalScore,userName,highNames,highScores);
					// Update highNames and highScores
					UpdateHighScores(highNames,highScores);
						
					break; // break for case 2
						
				// If user select option 3 (Exit), display DialogBox with the goodbye message
				case '3':
					// Display final results if played
					if(totalScore>0)
						JOptionPane.showMessageDialog(null, userName+", here are your final results:\n"
							+ "Total Score: "+totalScore+"\n");
					// Display goodbye message
					JOptionPane.showMessageDialog(null, "Bye, "+userName+"!\n");
					
					break; // break for case 3
					
				// If user made wrong menu choice, display DialogBox to prompt user to reselect
				default:			
					JOptionPane.showMessageDialog(null, userName
							+", please, select proper choice!\n");
					
			} // end switch
			
		} while(userInput!='3'); // end external do while loop

	} // end main
	
	// Method for DisplayMainMenu()
	public static char DisplayMainMenu(){
		// Display menu choice
		char choice=((String)JOptionPane.showInputDialog(
				 	"Please, input 1, 2 or 3 for the following main menu:\n"
				+ "1) See Rules\n2) Play Game\n3) Exit\n"
				+ "Enter your selection here: ")).charAt(0);		
		// return user choice
		return choice;
	}
	// Method for DisplayRules()
	public static void DisplayRules(){
		// Display rules
		JOptionPane.showMessageDialog(null, "Here are the rules for the game!\n"
			+ "1) There are 9 sets of questions and 4 possible answers each\n"
			+ "2) There are certain point(s) for correct answer\n"
			+ "3) No cheat\n"
			+ "4) Have fun\n");
	}
	// Method for ProcessQuestion()
	public static int ProcessQuestion(String[] q1, String[] ansA, String[] ansB, 
				String[] ansC, String[] ansD, char[] correctAns, int[] pointValue){
		// Declare and initialize variables
		int myScore=0, earnPt;
		String answer="", display;
		char compare=' ';
		// Only 9 question sets
		for(int i=0;i<q1.length-1;i++){
			// Reset display and earnPt;
			display="";
			earnPt=0;
			// Combine all question/answers to display using JOptionPane
			display+=(q1[i]+"\n"+ansA[i]+"\n"+ansB[i]+"\n"+ansC[i]+"\n"+ansD[i]+"\n");
			// Display question/answer choices using JOptionPane
			JOptionPane.showMessageDialog(null, display);		
			// Prompt user for answer choice using JOptionPane
			answer = JOptionPane.showInputDialog("Correct answer for this question will get "
				+pointValue[i]+" points.\n"
				+"Enter A, B, C, or D for answer here: ");
			// Convert compare to upper case
			compare=Character.toUpperCase(answer.charAt(0));
			// Check if correct answer
			if(compare==correctAns[i]){
				// Assign pointValue to earnPt
				earnPt=pointValue[i];
				// Display correct message and earnPt
				JOptionPane.showMessageDialog(null, "Correct answer.\n"
					+"Your points for this answer: "+earnPt);
			}	else {
				// Display incorrect message and earnPt
				JOptionPane.showMessageDialog(null, "Incorrect answer.\n"
					+"Your points for this answer: "+earnPt);
			}
			// Accumulate myScore
			myScore+=earnPt;
		}
		// Return user earned point
		return myScore;
	}
	// Method for ReadInHighScores()
	public static void ReadInHighScores(String[] name, int[] score) throws IOException{
		// Declare and initialize variables
		int count=0;
		String blank;
		// Open myFile and read data into inFile
		File myFile = new File("highscore.txt");
		Scanner inFile = new Scanner(myFile);
		while(inFile.hasNext()){
			name[count] = inFile.next();
			score[count] = inFile.nextInt();
			blank = inFile.nextLine();
			count++;
		}
		// Close inFile. 
		inFile.close();
	}
	// Method for CompareScore()
	public static void CompareScores(int userScore, String userName, 
			String[] name, int[] score){
		for (int i=0;i<score.length;i++){
			// If highest score less than userScore
			if(i==0&&score[i]<userScore){
					name[i+2]=name[i+1];
					score[i+2]=score[i+1];
					name[i+1]=name[i];
					score[i+1]=score[i];
					name[i]=userName;
					score[i]=userScore;
				break;
			} 
			// If higher score less than userScore
			if (i==1&&score[i]<userScore){
					name[i+1]=name[i];
					score[i+1]=score[i];
					name[i]=userName;
					score[i]=userScore;
				break;
			}
			// If last high score less than userScore
			if (i==2&&score[i]<userScore){
				name[i]=userName;
				score[i]=userScore;
				break;
			}
		}
	}
	// Method for DisplayScore()
	public static void DisplayScore(int score){
		// Display results after each question/answers
		JOptionPane.showMessageDialog(null, "Here are your results so far:\n"
			+ "Total Score: "+score+"\n");
	}
	public static void UpdateHighScores(String[] highName, int[] 
			highScore) throws IOException{
		// Open myFile and write to highscore.txt
		PrintWriter myFile = new PrintWriter("highscore.txt");
		for (int i=0;i<highScore.length;i++){
			myFile.println(highName[i]+" "+highScore[i]);
		}
		// Close inFile. 
		myFile.close();		
	}

} // end class JavaGamev6
