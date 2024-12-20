// Name: Ariana Rocha 
// Andrew id: afrocha

import java.util.Scanner;

/** Class Palindromer takes up to 10 phrases, checks to see 
 *  if each is a palindrome, displays the phrases and the count
 *  of how many were palindromes.
 */

public class Palindromer {
    /* Class data: */
	private static Scanner scanner = new Scanner(System.in);
	private String[] plist;
	private int pcount = 0;

    /** inputPalindromes:
     *  Parameters: int n, the number of phrases to be entered.
     *  Returns: a String[] array containing the phrases.
     *  Creates an array of Strings, then prompts the user
     *  to enter phrases.
     */
	//it calls inputPalindromes( ) to enter that many phrases into Palindromer's internal String array.
	public String[] inputPalindromes(int n) {
		String[] new_string = new String[n];
		for (int pcount = 0; pcount < n; pcount++) {
			System.out.print("Enter Palindrome Test Phrase " + String.valueOf(pcount+1) + ": ");
			new_string[pcount] = scanner.nextLine();
		}
		return new_string;
	}
	
    /** displayPalindromes:
     *  Parameters: none
     *  Returns: void
     *  For each phrase in plist[], call cleanString( ) to create
     *  an all-upper-case, letters only version of the phrase;
     *  check if that String is a palindrome - if so, say so;
     *  if not, say that. Increment pcount with the number of
     *  palindromes found.
     */
	public void displayPalindromes() {
        for (String phrase : plist) {
			String cleaned = cleanString(phrase);
			if(isPalindrome(cleaned)) {
				System.out.println(phrase + " is a palindrome.");
				pcount++;
			} else {
				System.out.println(phrase + " is NOT a palindrome.");
			}
		}
	}
	
    /** isPalindrome:
     *  Parameter: String s to test for palindromity
     *  Returns: boolean
     *  If s is a palindrome, return true, otherwise
     *  return false
     */
	public boolean isPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
		return s.equals(reversed);
	}
	
    /** cleanString:
     *  Parameter: String s to be cleaned
     *  Returns: String, upper case letters only
     *  Removes non-letters from s, converts to upper case.
     */
	public String cleanString(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c: s.toCharArray()) {
			if (Character.isLetter(c)) {
				sb.append(Character.toUpperCase(c));
			}
		}
		String newString = sb.toString();
		return newString;
	}
	
    /** getPcount:
     *  Parameters: none
     *  Returns: int, the value of pcount
     *  Standard getter function
     */
	public int getPcount() {
        return pcount;
	}

    /** DO NOT CHANGE THIS METHOD */
	// Main method prompts the user for the number of palindromes too be entered. 
	//// After an error check it calls inputPalindroms() to enter that many phrases into P's internal String array
	//// It then calls displayPalindromes( ), which should examine each cleaned-up phrase to see if it's a palindrome; 
	////// It does this using the helper methods cleanString( ) -- already coded -- and isPalindrome()
	//// It displays the phrases, one by one, and whether or not they are palindromes, and counts / displays the number of phrases that are palindromes.
	public static void main(String[] args) {
		Palindromer palindromer = new Palindromer();
		System.out.println("Palindromer App\n");
		System.out.print("Enter the number of palindromes to store (10 max): ");
		int count = Integer.parseInt(palindromer.scanner.nextLine());
		if (count > 0 && count < 10) {
			palindromer.plist = palindromer.inputPalindromes(count);
			System.out.println();
			palindromer.displayPalindromes();
			System.out.println("\nNumber of palindromes: " + palindromer.getPcount());
		} else {
			System.out.println("Sorry, cannot do that number");
		}
	}
}
