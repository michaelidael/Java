//word list imports the list and initializes at zero to safely start this redundant linked list assignment
public class WordList
{
	WordMeaningNode list;

	WordList()
	{
		list = null;
	}

//adding of a word meaning utilizing good ol' linked lists the old fashioned way. 
void add(WordMeaning www)
{
	//temp points towards the wordmeaning node and calls the nodes function. 
	WordMeaningNode temp = new WordMeaningNode(www);

	//if the list is null then the list is complete. 
	if (list == null)
		list = temp;
		//else time to get to work
		else
		{
			//head equals to list and tail is null to avoid garbage memory address being assigned. 
			WordMeaningNode head = list;
			WordMeaningNode tail = null;
			boolean found = false;

		//while the head is not null and is found
		while(head != null && !found)
			//if the values of the wordmeaning and its name are less than zero than work is complete. 
			if( temp.wordMeaningGetter().nameGetter().compareTo(head.wordMeaningGetter().nameGetter()) < 0 )
				found = true;
			//if they are not null and still open continue appending. 
			else
			{
				//tail points to head and head is equal to next node. 
				tail = head;
				head = head.next;
			}
				//temp.next points to next node and that is appended as new head.
				temp.next = head;
			
			//if the tail is null then list is equal to temp node. 
			if (tail == null)
				list = temp;
			//else tail.next points towards temp. 
			else
				tail.next = temp;
		}
}
	//wrapper case in case the list is empty. 
	boolean listEmpty()
	{
		boolean empty;
			if (list == null)
			{
				empty = true;
			}
			
			else
			{
				empty = false;
			}
			return empty;
	}

	//appends results of input string
	public String toString()
	{
		int count = 0;
		String result = "";
		WordMeaningNode current = list;
	
	//while the current list is not null then increment count for words in list
	//and then alsu appent the result on to the string.
	while (current != null)
	{
		count++;
		result += current.wordMeaningGetter().nameGetter() + current.wordMeaningGetter().defGetter()+"\n";
		current = current.next;
	}
	//once it is null then give final count of words in list. 
	return result + "\nNumber of words in list : " + count;
	}

//function to remove a word and move to obsolete word list. 
public void remove(String word) {
	
	boolean booly = false;
	WordMeaningNode current = list;
	WordMeaningNode pre = null;
	
	//while current list is not empty do work. 
	while (current != null)
	{
		//if current word is true then pre node is null then go into the next node and grab the information. 
		if(current.wordMeaningGetter().nameGetter().equalsIgnoreCase(word)==true){
			if(pre == null)
			{
				list=list.next;
			}
		//else pre.next points towards current lists nodes next value. once bool returns true then break from loop.
		else
		{
			pre.next=current.next;
		}
			booly = true;
			break;
		}
		//if not then pre points to current and continue on to the next one until complete. 
		pre=current;
		current = current.next;
	}
		//if boolean returns false then the data to be removes is not found and display error msg. 
		if(booly == false)
		{
			throw new NullPointerException("Error: Data not found.");
		}
}

}