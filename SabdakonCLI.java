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
 	SabdakonCLI.java	

  	This is a simple CLI version of Sabdakon.
*/

import java.util.Scanner;		//for getting input from commandline
import java.net.URL;			//class representing a URL
import java.net.URLConnection;		//abstract class, represents connection between app and URL
import java.net.MalformedURLException;
import java.io.BufferedReader;		//reads text from a character stream, buffers the characters
import java.io.BufferedWriter;		//writes text to a character stream, buffers the characters
import java.io.InputStreamReader;	//converts bytes to characters using a specified charset
import java.io.IOException;


public class SabdakonCLI
{
	static void queryServer(searchWord)
	{
		URL wordUrl;

		try
		{
			url = new URL("http://www.wired.com/");
			URLConnection connection = url.openConnection();	//opens new connection the URL

			//opens the stream and puts it into a BufferedReader
			Buffered Reader buffReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
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

	public static void main(String[] args)
	{
		String searchWord;
		Scanner inputStr = new Scanner(System.in);
		
		if(args.length > 0)					//checks for CLI args
		{
			searchWord = args[0];
		}
		else
		{
			System.out.print("Enter a word: ");
			searchWord = inputStr.nextLine();
		}

		System.out.printf("Word: %s\n", searchWord);

		queryServer(searchWord);
	}


}
