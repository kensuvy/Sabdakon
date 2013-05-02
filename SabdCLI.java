/*
	Copyright 2013, Subhankar Sahu

	Author(s): Subhankar Sahu                                 
	Public Repo: https://github.com/kensuvy/Sabdakon                                                

	This file is part of Sabdakon.

    	Sabdakon is free software: you can redistribute it and/or modify
   	it under the terms of the GNU General Public License as published by
    	the Free Software Foundation, either version 3 of the License, or
    	(at your option) any later version.

    	Sabdakon is distributed in the hope that it will be useful,
    	but WITHOUT ANY WARRANTY; without even the implied warranty of
    	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    	GNU General Public License for more details.

    	You should have received a copy of the GNU General Public License
    	along with Sabdakon.  If not, see <http://www.gnu.org/licenses/>.
	
*/

/*	
 	SabdCLI.java	

  	This is a simple CLI version of Sabdakon.
*/

import java.util.Scanner;		//for getting input from commandline
import java.net.URL;			//class representing a URL
import java.net.URLConnection;		//abstract class, represents connection between app and URL
import java.net.MalformedURLException;
import java.io.InputStreamReader;	//converts bytes to characters using a specified charset
import java.io.IOException;


public class SabdCLI
{
	static String word;
	static String meaning;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		while(true)
		{		System.out.print("Enter word: ");
				word = input.nextLine();	
				getFromURL(word);
				formatResult();
		}
	}

	public static void getFromURL(String word)
	{
		URL url;
		String urlstring = "http://api.duckduckgo.com/?q="+word+"&format=json&pretty=1"; 
		try 
		{
			url = new URL(urlstring);
	 
			URLConnection conn = url.openConnection();
 
                        Scanner urlContent = new Scanner(conn.getInputStream());
			while(urlContent.hasNext())
			{
				meaning = urlContent.nextLine();
				
				if(meaning.indexOf("Definition")>=0)
					break;
				
			}
		}
 
		
		catch(MalformedURLException e) 
		{
			e.printStackTrace();
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void formatResult()
	{
		int startIndex = 0;
		int stopIndex = 0;

		System.out.printf("\n\n%s\n_______________\n\n", word);

		if(meaning.indexOf("\"\"")>=0)
		{
			System.out.printf("Error: Word Not Found.\n_______________\n\n");	
		}

		else if(meaning.indexOf("Definition")>=0)
		{	
			startIndex = meaning.indexOf("Definition")+14;
			if(meaning.indexOf("definition:")>=0)
			{
				startIndex = meaning.indexOf("definition:")+12;
				System.out.print("\"");
			}	
			stopIndex=meaning.lastIndexOf("\",");
			System.out.printf("%s\"\n_______________\n\n", meaning.substring(startIndex, stopIndex));
		}


	}

}
