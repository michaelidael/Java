//this is the initialization class for the word's meaning utilizing a linked list.
//next is initialized as null since thats to avoid random memory addresses messing around with its pointing.
public class WordMeaningNode
{
	WordMeaning wordMeaning;
	WordMeaningNode next;

	WordMeaningNode(WordMeaning www)
	{
		wordMeaning = www;
		next = null;
	}

public WordMeaning wordMeaningGetter()
{
	return wordMeaning;
}
}