package aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader =  new BufferedReader(new FileReader(Main.class.getClassLoader().getResource("data.txt").getFile()));
		
		String line = null;
		int total = 0;
		while ((line = reader.readLine()) != null)
		{
			line = line.trim();
			int half = line.length() / 2;
			String firstPart = line.substring(0, half);
			String secondPart = line.substring(half, line.length());
			
			Character c = findFirstDuplicate(firstPart, secondPart);
			if (c != null)
			{
				Integer number = mapNumber(c);
				total = number != null ? total+=number : total;
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
