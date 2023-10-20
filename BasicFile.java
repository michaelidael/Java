import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.io.StreamTokenizer;

public class BasicFile {
	
//Var declaration for File, a file selector and a new file for the backup if need be.	
File file;
JFileChooser fileSelector;
File file2 = new File(".", "File Backup");


BasicFile() {
	fileSelector = new JFileChooser(".");
}

//fileSelection does exactly as stated. selects a file
public void fileSelection() {
	int statRes = fileSelector.showOpenDialog(null);

//tries lines below if the filechooser approves user input as invalid. 
try {
	if (statRes != JFileChooser.APPROVE_OPTION) {
	throw new IOException();
}

file = fileSelector.getSelectedFile();

//if file is not found/exists then throw an exception.  
if (!file.exists()) {
	throw new FileNotFoundException();
}
	}

//message to be displayed in case of error. 
catch (FileNotFoundException e){
JOptionPane.showMessageDialog(null, "No File Found ", "Error", JOptionPane.INFORMATION_MESSAGE);
} 
catch (IOException e) {
	System.exit(0);
					  }
}

//fileBackup creates a backup file of the sample user input selected file. 
void fileBackup() throws FileNotFoundException {
//declaring input and output as null so it is confirmed to have zero erroneous values in memory block.  
DataInputStream in = null;
DataOutputStream out = null;

//try to read file and put it into backup file. 
try {
	in = new DataInputStream(new FileInputStream(file));
	out = new DataOutputStream(new FileOutputStream(file2));

//reads file size in bytes
try {
while (true) {
	byte dataSz = in.readByte();
	out.writeByte(dataSz);
			 }
	} 

//display once completed
catch (EOFException e) {
JOptionPane.showMessageDialog(null, "File backup completed.", "Complete", JOptionPane.INFORMATION_MESSAGE);
} 
catch (IOException e) {
JOptionPane.showMessageDialog(null, "File Not Found ", "Error", JOptionPane.INFORMATION_MESSAGE);
						}
	}
//once all said and done we can try to close the file input and output streams. 
finally {
	try {
			in.close();
			out.close();
		}
		catch (Exception e) {
			//if it cant, display error msg once again. 
			display(e.toString(), "Error");
							}
		}

}



//time to see if my boolean game still exists
boolean exists() {
	return file.exists();
}

//typical toString appender
public String toString() {
	return file.getName() + "\n" + file.getAbsolutePath() + "\n" + file.length() + " bytes";
}

//wordCounter init to 0.
public String wordCount() {
	try {
		//initialize all to zero but minimum there will be one line unless empty or sum. but technically still one line. Roll the Dice. 
		int wordCount = 0,
		numberCount = 0,
		lineCount = 1,
		characterCount = 0,
		totalWords = 0;

//file reader initialization.
FileReader r = new FileReader(file);
StreamTokenizer toke = new StreamTokenizer(r);

toke.resetSyntax();
toke.whitespaceChars(0, ' ');
toke.wordChars('a', 'z');
toke.wordChars('A', 'Z');
toke.wordChars('0', '9');
//had to google this bad boy to make sure that end of line is valid. 
toke.eolIsSignificant(true);

//keep going token to token until EOF is met.
while (toke.nextToken() != StreamTokenizer.TT_EOF) {
	//switch case was easiest ^_^
	switch (toke.ttype) {
	case StreamTokenizer.TT_NUMBER:
		numberCount++;
		break;
		
	case StreamTokenizer.TT_WORD:
		characterCount += toke.sval.length();
		wordCount++;
		break;
	case StreamTokenizer.TT_EOL:
		lineCount++;
		break;
	case StreamTokenizer.TT_EOF:
		break;
	default:
}
}
//close reader, 
r.close();
//arithmetic for word count. 
totalWords = numberCount + wordCount;
//return line,word,char count. 
return file.getName() + " has " + lineCount + " line(s), " + totalWords + " word(s), and " + characterCount + " characters. ";
} 
	catch (IOException e) {
		display(e.toString(), "Error");
	}
return " ";
}

//display func. 
void display(String msg, String s) {
JOptionPane.showMessageDialog(null, msg, s, JOptionPane.ERROR_MESSAGE);
}

}