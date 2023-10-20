/*
 * Work done by Michael Soto and Francisco Garcia
 * 
 */

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//contains all of the guts of the dictionary book we are programming. 
public class Dictionary {


public static void main(String[] args)
{

//variable declaration for entries, dictionary, and obsolete/deleted words. 
	WordMeaning entry;
	WordList obsolete = new WordList();
	WordList dictionary = new WordList();
	boolean boolin = true;
	int option = 0;

	//menu options for user to see.
String menuMessage = "1. Enter a word and its definition\n2. Remove a word\n3. Display all words and definitions\n4. Display Obsolete words\n\n Please enter numbers 1-4. \n (Anything greater than 4 will exit the program.)";

do {
	
	option = GetData.intGetter(menuMessage); 
	
	//switch cases ftw
	switch (option) {
	//case 1. user wants to enter a word. so it is inputted into word and the definition into definition.
	case 1:
		String word = GetData.stringGetter("Enter a word :" + " ");
		String definition = GetData.stringGetter("Enter the definition of " + word + " : ");
		definition = " - " + definition;
		entry = new WordMeaning(word, definition);
		dictionary.add(entry);
		JOptionPane.showMessageDialog(null, word + " was added to the dictionary.", "New Entry", JOptionPane.INFORMATION_MESSAGE);
		break;

	//case 2 if the user wants to delete data they enter it into the remove function and then 
	//if found successfully delete. if an exception is caught then it is because it doesn't exist in the dictionary.
	case 2:
		word = GetData.stringGetter("Enter the word to be deleted:");

		try {
			dictionary.remove(word);
			obsolete.add(new WordMeaning(word, " "));
			JOptionPane.showMessageDialog(null, word + " has been removed!", "Word Removal", JOptionPane.INFORMATION_MESSAGE);
			} 
		catch (NullPointerException e) 
		{
			JOptionPane.showMessageDialog(null, word + " does not exist. Sorry!", "Word Removal", JOptionPane.INFORMATION_MESSAGE);
		}
		break;

	//case 3 the user wants to display the current dictionary with its definitions. 
	case 3:
		JTextArea text = new JTextArea(dictionary.toString(), 10, 40);
		JScrollPane pane = new JScrollPane(text);
		JOptionPane.showMessageDialog(null, pane, "Current" + "Dictionary", JOptionPane.INFORMATION_MESSAGE);
		break;
		
	//case 4 user wants to show the obsolete/deleted words. 
	case 4:
		text = new JTextArea(obsolete.toString(), 10, 40);
		pane = new JScrollPane(text);
		JOptionPane.showMessageDialog(null, pane, "Obsolete Words", JOptionPane.INFORMATION_MESSAGE);
		break;
		
	default:
		boolin = false;

}
}
while (boolin);
}
}

