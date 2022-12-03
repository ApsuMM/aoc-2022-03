package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader =  new BufferedReader(new FileReader(Main.class.getClassLoader().getResource("data.txt").getFile()));
		int total = 0;
		int counter = 0;
		
		String line = null;
		String[] lines = {null, null, null};
		while ((line = reader.readLine()) != null)
		{
			lines[counter] = line;
			counter++;
			
			if (counter == 3)
			{
				for (int i = 0; i < line.length(); i++)
				{
					CharSequence cs = Character.toString(line.charAt(i));
					if (lines[0].contains(cs) && lines[1].contains(cs))
					{
						Integer number = mapNumber(line.charAt(i));
						total = number != null ? total+=number : total;
						break;
					}
				}
				counter = 0;
			}
		}
		System.out.println(total);
	}
	
	public static Integer mapNumber(char letter)
	{
		int j = 1;
		for (char i = 'a'; i <= 'z'; i++)
		{
			if (i == letter)
			{
				return j;
			}
			j++;
		}
		
		for (char i = 'A'; i <= 'Z'; i++)
		{
			if (i == letter)
			{
				return j;
			}
			j++;
		}
		return null;
	}
	
	public static Character findFirstDuplicate(String firstPart, String secondPart)
	{
		char[] chars = firstPart.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			char currentChar = chars[i];
			for (int j = 0; j < secondPart.length(); j++)
			{
				if (currentChar == secondPart.charAt(j))
				{
					return currentChar;
				}
			}
		}
		return null;
	}

}
