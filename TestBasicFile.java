import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class TestBasicFile {

public static void main(String[] args) throws FileNotFoundException, IOException {
//init to false until proven to be true (1)
	boolean done = false;

	String menu = "Menu\n1. File Info (Name, Path, Size) \n2. Backup a Specific File\n3. " + "Word Count\n4. Exit";
	//while not done run this new file. 
	while (!done) {
		BasicFile file = new BasicFile();
		String stringCheese = JOptionPane.showInputDialog(menu);

		try {
			int input = Integer.parseInt(stringCheese);
			
			//switch case exp below. 
			switch (input) {
			//if they select this option before selecting a file. 
			case 1:
				JOptionPane.showMessageDialog(null, "For the name, path, and size of a file please select one from the next menu.", "File Selection", JOptionPane.INFORMATION_MESSAGE);
				file.fileSelection();
				//if the file exists, run that file name 
				if (file.exists()) {
					displayInfo(file.toString(), "File");
				} 
				else {
					file.fileSelection();
				}
				break;
				
				//if the file backup option selected, then go to the file select and call fileBackup() class/function/whateva.
			case 2:
				file.fileSelection();

					if (file.exists()) {
						displayInfo(file.toString(), "File");
					}
					else {
						file.fileSelection();
					}

					file.fileBackup();
					break;
			//if the word count option selected go into file.wordCount class/function and pass to it the file that was pulled. 		
			case 3:
				file.fileSelection();

					if (file.exists()) {
						displayInfo(file.wordCount(), "Word Count");
					}
					else {
						file.fileSelection();
					}
					break;
			//simple exit. 
			case 4:

				done = true;
				break;
			default:
			}
		}
		catch (NumberFormatException e) {
			System.exit(0);
		}
		catch (NullPointerException e) {
			System.exit(0);
}
}
}

//typ display func. 
static void displayInfo(String s, String info) {
JOptionPane.showMessageDialog(null, s, info, JOptionPane.INFORMATION_MESSAGE);
}

}