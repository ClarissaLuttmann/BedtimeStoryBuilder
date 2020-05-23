/* Hello parent! Welcome to the Bedtime Story Builder, my first GitHub project! This program is designed as an interactive tool to create simple custom bedtime stories for children. 
 * While the story frame itself is static, the tool teaches basic story composition and trains child creative skills. 
 * To get started with your first story, go ahead and and follow the instructions!:) 
 * 
 * General info: Every story consists of basic components that I would like to introduce to you: 
 - CHARACTER: this is the main protagonist of the story. It can be a hero figure or other persona that the child can well identify with. For example,the character could be a curious young cat, a unicorn, princess, pirate, child or even a grumpy potato.
 - SETTING: this is where your story takes place. It can be a real or imaginary place, big or small. For example, the setting could be in space, a medieval castle or tiny pond.
 - PROBLEM: this is the introduction of a change to the status quo, an obstacle that the character has to overcome. Generally, the greater the problem, the better the story. For example, the problem could be a big wave, an explosion, or simply a letter with a message.
 - FRIEND/VILLAIN: this is a secondary character who interacts with the main protagonist in tackling the problem. The friend supports the main character at solving the problem, whereas the villain introduces the problem. 
 - SOLUTION: this is an occurrance or action that leads to the resolution of the initial problem. For example, a solution could be a magic want, sunshine, or key. 
 - OUTCOME: this is the final state that is achieved after the resolution of the problem. 
 - THEME: the is the overarching message conveyed through the story. This one might be quite challenging for younger children though. For example, the theme could be love, persistence or the importance of honesty. 
 * 
 * They serve as a guiding frame from the creation of initial bedtime stories in this program and can well be used outside of it as well. 
 * After creating initial bedtime stories with this Bedtime Story Builder, feel free to expand them, add context in between the lines, and perhaps even draw illustrations with the 
 * children and create a small personal book. It's a great exercise to expand children's makers skills and awaken their love for literacy. 
 * 
 */

// This import is intended to allow the use of the Java Scanner, to accept and process user input 
import java.io.FileWriter;  
import java.util.Scanner; 

/**
 * Generates new bedtime stories for kids based on supplied input.
 * @author jacar
 *
 */
public class BedtimeStoryBuilder {
	// The following method identifies the selected strings' first letter and converts the 'a' in front of the CHARACTER, FRIEND and VILLIAN name in the text to 'an' if either have 'a', 'e', 'i', 'o' or 'u' as the first letter 
	public static String vocalScan(String character) {
		// The following scans the character name for its first letter  
		char first_CHARACTER = character.charAt(0);
		String result; 
		// The following code converts a = "a" to "an" if the CHARACTER, FRIEND, or VILLAIN entry either have 'a', 'e', 'i', 'o' or 'u' as the first letter 
		if (first_CHARACTER == 'a' || first_CHARACTER == 'e' || first_CHARACTER == 'i' || first_CHARACTER == 'o' || first_CHARACTER == 'u') {
			result = "an ";
		} 
		else {
			result = "a ";
		} 
		return result; 
	}
	
	public static void main(String[] args) {
		// The following code initialized our new scanner 
		Scanner scan = new Scanner(System.in);
		
		// The following code (1) asks the user to enter the different components of our story, (2) scans the user's response, and (3) stores the input as String values under their respective category name: 
		System.out.println("The main character in your story is a(n) ____? E.g. elephant, mouse, potato, ... ");
		String CHARACTER = scan.nextLine(); 
		
		System.out.println("The " + CHARACTER + "'s name is ____? E.g. Peppa, Oscar, Leo, ... ");
		String CHARACTER_NAME = scan.nextLine(); 
		
		System.out.println("The story takes place ____? E.g. in a forest, in space, inside a beautiful castle, ... ");
		String SETTING = scan.nextLine(); 
		
		System.out.println(CHARACTER_NAME + "'s best friend is a(n) ____? E.g. parrot, kangaroo, snail, ... ");
		String FRIEND = scan.nextLine(); 
		
		System.out.println(FRIEND + "'s name is ____? ");
		String FRIEND_NAME = scan.nextLine(); 
		
		System.out.println("Complete the sentence: " + CHARACTER_NAME + " and " + FRIEND_NAME + " love to ____? E.g. eat ice cream, climb in the trees, fly over the clouds, ...  "); 
		String FAVOURITE_ACTIVITY = scan.nextLine(); 
		
		// The following code section converts the String FAVOURITE_ACTIVITY to the same string with the verb containing the '-ing' 
		// The following code create an integer 'a' that reflects the first instance in the string FAVOURITE ACTIVITY where a " " occurs 
		int a; 
		if (FAVOURITE_ACTIVITY.contains(" ")) {
			a = FAVOURITE_ACTIVITY.indexOf(" ");
		} 
		// This code applies if the input contains only the verb
		else {
			a = FAVOURITE_ACTIVITY.length() + 1;
		}
		// Create a new string to reflect the altered text 
		String FAVOURITE_ACTIVITY1 = FAVOURITE_ACTIVITY; 
		
		// The following code checks the input for exceptional verb forms
		// If the verb ends with "ie", the final two letters are deleted and '-ying' added 
		if (	FAVOURITE_ACTIVITY.charAt(a-2) == 'i' && FAVOURITE_ACTIVITY.charAt(a-1) == 'e') {
				FAVOURITE_ACTIVITY1 = (FAVOURITE_ACTIVITY.substring(0,(a-2)) + "ying" + FAVOURITE_ACTIVITY.substring(a));
					}
		
		// The following code checks whether the first word (verb) in the string FAVOURITE_ACTIVITY ends with a vocal, and if so, deletes the vocal 
		else if (FAVOURITE_ACTIVITY.charAt(a-1) == 'e') {
			FAVOURITE_ACTIVITY1 = (FAVOURITE_ACTIVITY.substring(0,(a-1)) + "ing" + FAVOURITE_ACTIVITY.substring(a));
		}
		
		// If the verb ends in a consonant + vovel + consonant, the final consonant is doubled and '-ing' added
		else if (( FAVOURITE_ACTIVITY.charAt(a-3) != 'a' && FAVOURITE_ACTIVITY.charAt(a-3) != 'e' && FAVOURITE_ACTIVITY.charAt(a-3) != 'i' && FAVOURITE_ACTIVITY.charAt(a-3) != 'o' && FAVOURITE_ACTIVITY.charAt(a-3) != 'u' ) 
			&& (FAVOURITE_ACTIVITY.charAt(a-2) == 'a' || FAVOURITE_ACTIVITY.charAt(a-2) == 'e' || FAVOURITE_ACTIVITY.charAt(a-2) == 'i' || FAVOURITE_ACTIVITY.charAt(a-2) == 'o' || FAVOURITE_ACTIVITY.charAt(a-2) == 'u' )
			&& (FAVOURITE_ACTIVITY.charAt(a-1) != 'a' || FAVOURITE_ACTIVITY.charAt(a-1) != 'e' || FAVOURITE_ACTIVITY.charAt(a-1) != 'i' || FAVOURITE_ACTIVITY.charAt(a-1) != 'o' || FAVOURITE_ACTIVITY.charAt(a-1) != 'u')) {
			int b = a - 1; 
			char c = FAVOURITE_ACTIVITY.charAt(b); 
			FAVOURITE_ACTIVITY1 = (FAVOURITE_ACTIVITY.substring(0,(a)) + c + "ing" + FAVOURITE_ACTIVITY.substring(a));
				}
	
		// The following code covers all remaining regular verbs where "-ing" is added 
		else {
			FAVOURITE_ACTIVITY1 = (FAVOURITE_ACTIVITY.substring(0,(a)) + "ing" + FAVOURITE_ACTIVITY.substring(a));
		}
		
		System.out.println(FAVOURITE_ACTIVITY1); //this is just a test 
		
		System.out.println("The mean villain in your story is a(n) ...? E.g. big wave, crocodile, mean witch, ... ");
		String VILLAIN = scan.nextLine(); 
		
		System.out.println("What did the " + VILLAIN + " do that stops " + CHARACTER_NAME + " and " + FRIEND_NAME + " from " + FAVOURITE_ACTIVITY1 + "? E.g. turned " + FRIEND_NAME + " into a stone, blocked the way, hid the ice cream, ... ");
		String PROBLEM = scan.nextLine(); 
		
		System.out.println("Complete the sentence: Their solution is to ...? E.g. solve three maths riddles, invite the " + VILLAIN + " to " + FAVOURITE_ACTIVITY + " together, ... ");
		String SOLUTION = scan.nextLine(); 
		
		System.out.println("What's the theme of your story? E.g. team-work, mathematics, friendship, creativity, ... ");
		String THEME = scan.nextLine();  
		
		System.out.println("What's the title of your story? E.g. The Day a Tree Fell, About Friendship, A Rabbit's Adventure, ... ");
		String TITLE = scan.nextLine(); 
		
		System.out.println("What's your name?");
		String AUTHOR = scan.nextLine(); 
		
		// The following code converts the title into all-upper case words 
		String TITLE_UP = TITLE.toUpperCase();
		
		// The following method identifies the selected strings' first letter and converts the 'a' in front of the CHARACTER, FRIEND and VILLIAN name in the text to 'an' if either have 'a', 'e', 'i', 'o' or 'u' as the first letter 
		String a_CHARACTER = vocalScan(CHARACTER); 
		String a_FRIEND = vocalScan(FRIEND); 
		String a_VILLAIN = vocalScan(VILLAIN); 
		
		
		// The following code inserts the user input into the bedtime story template
		String BEDTIME_STORY = (TITLE_UP + " - a bedtime story written by " + AUTHOR + "\n\nOnce upon a time, there was " + a_CHARACTER + CHARACTER + " called " + CHARACTER_NAME + " who lived in " +  SETTING + ". \n" 
				+ CHARACTER_NAME + " was best friends with " + a_FRIEND + FRIEND + " called " + FRIEND_NAME + " and together they would " + FAVOURITE_ACTIVITY + " every day. " + CHARACTER_NAME + " and " + FRIEND_NAME + " loved to " + FAVOURITE_ACTIVITY + "!\n" 
				+ "But one day, just as the two were about to " + FAVOURITE_ACTIVITY + ", something unusual happened: " + a_VILLAIN + VILLAIN + " appeared and " + PROBLEM + ". \n " 
				+ CHARACTER_NAME + " and " + FRIEND_NAME + " could no longer " + FAVOURITE_ACTIVITY + " until they made the " + VILLAIN + " go away.\n"
				+ "After thinking about it, " + FRIEND_NAME + " had an idea. " + FRIEND_NAME + " said: 'Let's " + SOLUTION + " !' " + CHARACTER_NAME + " agreed: 'Good idea! Let's " + SOLUTION + " so that we can " + FAVOURITE_ACTIVITY + " together again!'\n" 
				+ "Immediately, the two friends began to " + SOLUTION + " and the " + VILLAIN + " no longer " + PROBLEM + ". While they were finally " + FAVOURITE_ACTIVITY1 + ", they thought about the importance of " + THEME + ". \n\n"); 
		
		// The following code prints the completed bedtime story in the console 
		System.out.println(BEDTIME_STORY); 
		
		// The following code will safe the created bedtime story as a text file 
		try{    
	           FileWriter fw=new FileWriter("D:\\" + TITLE + ".txt");    
	           fw.write(BEDTIME_STORY);    
	           fw.close();    
	    }catch(Exception e){System.out.println(e);}    
        System.out.println("Congrats! Your new bedtime story was successfully saved as 'D:\\" + TITLE + ".txt'! :)"); 
			
	}
                                                                                                                     
}
