
import javax.swing.JOptionPane;

public class EncryptionTesty 
{

	public static void main(String arg[])
	{
		
		String code = "";
		String output = "";
		
		//Input display 2 console
		String text = JOptionPane.showInputDialog("Enter Message");
		output += "The original message is \n" + text + "\n";
		
		//encryption mode func call
		Cipher c = new Caesar(text);
		c.encrypt();
		code = c.getEncodedMessage();
		output += "\nCaesar Cipher\n The encrypted message is \n" + code + "\n" ;
		
		//decryption mode func call
		c.decrypt(code);
		code = c.getDecodedMessage();
		output += "The decrypted message is \n" + code + "\n" ;
		
		//transpose mode func call
		c = new Transpose(text);
		c.encrypt();
		code = c.getEncodedMessage();
		output += "\nTranspose\n The encrypted Transpose message is \n" + code + "\n" ;
		c.decrypt(code);
		code = c.getDecodedMessage();
		output += "The decrypted Transpose message is \n" + code + "\n" ;
		
		//reverser mode func call
		Reverser r = new Reverser(text);
		r.encrypt();
		code = r.reverseText(code);
		output += "\nReverser\n The encrypted Reverse message is: \n" + code + "\n" ;
		code = r.decode(code);
		output += "The decrypted Reverse message is: \n" + code + "\n" ;
		
		//Display 2 Console 
		display(output);
	}
		static void display (String s) 
		{
			JOptionPane.showMessageDialog(null, s, "Encrypt/decrypt",JOptionPane.INFORMATION_MESSAGE);
		}

}
