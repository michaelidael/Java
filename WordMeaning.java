
//contains word meaning guts and the strings that will be pulled through the get functions/classes
public class WordMeaning
{
	String name;
	String definition;

//wordmeaning function grabs the name and def and sticks them into variables that can be pulled into other classes and used.
//this is why it is a public grabber class. 
	WordMeaning(String wordName, String wordDef)
	{
	name = wordName ;
	definition = wordDef;
	}

	String nameGetter()
	{
		return name;
	}

	String defGetter()
	{
		return definition;
	}
}