import javax.swing.JOptionPane;

//grabs the data that will be put into the dictionary. 
public class GetData
{

	static int intGetter(String s)
	{
		return Integer.parseInt(stringGetter(s));
	}

	static String stringGetter(String s)
	{
		return JOptionPane.showInputDialog(s);
	}
}