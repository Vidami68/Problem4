
public class SortString {
	
	
	public static void main (String args[])
	{
		String text = "To be or not to be, that is the question;"
				+" Whether `tis nobler in the mind to suffer" 
				+" the slings and arrows of outrageous fortune,"
				+" or to take arms against a sea of troubles,"
				+" and by opposing end them?";
				
		String str = removeExtraMarks(text);
		
		int n = numberOfWords(str);
		
		String[] arrayOfWords = textToWords(n,str);
		
		String[] sortedArray = bubbleSort(arrayOfWords);
		
		for (int i = 0; i < n ; i++)
			System.out.println(sortedArray[i]);

	}
	
	// Eliminating extra marks in the text such as full stop, comma and etc.
	public static String removeExtraMarks(String text)
	{
		String newText = text.replaceAll("[.,:;?'!`]", "");
		return newText;
	}
		
	// Calculating the number of words in the text.
	// Number of words is equal to number of spaces + 1.
	public static int numberOfWords(String text)
	{
		int numberOfWords = 0;
		for (int i = 0; i < text.length(); i++)
		{
			if (text.charAt(i) == ' ')
				numberOfWords++;
		}
		numberOfWords++;
		return numberOfWords;
	}
		
	// Converting the text into an array of words
	// Spaces were assumed as word separators
	public static String[] textToWords(int numberOfWords, String text) 
	{
		String[] arrayOfWords = new String[numberOfWords];
		int i = 0;
		int j = 0;
		for (int k = 0; k < text.length(); k++)
		{
			if (text.charAt(k) == ' ')
			{
				arrayOfWords[i++] = text.substring(j, k);
				j = k + 1;
			}
		}
		arrayOfWords[numberOfWords-1] = text.substring(j,text.length());
		return arrayOfWords;				
	}
		
	// Using bubble sort algorithm to sort the array of words
	public static String[] bubbleSort(String[] arrayOfWords)
	{
		int n = arrayOfWords.length;
		String temp;
		String[] sortedArray = new String[n]; 
			
			
		for(int k = 0; k < n; k++)
			sortedArray[k] = arrayOfWords[k].toLowerCase();
					
		for(int i = 0; i < n-1 ; i++)
		{
			for (int j = i+1 ; j < n; j++)
			{
				if (sortedArray[i].compareTo(sortedArray[j]) > 0)
				{
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[j];
					sortedArray[j] = temp;	
				}
			}
				
		}
		return sortedArray;
	}

}
