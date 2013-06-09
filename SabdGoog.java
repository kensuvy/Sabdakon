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
 	SabdGoog.java	

  	This class receives data from Google.
*/

import java.util.Scanner;		//for getting input from commandline
import java.net.URL;			//class representing a URL
import java.net.URLConnection;		//abstract class, represents connection between app and URL
import java.net.MalformedURLException;
import java.io.InputStreamReader;	//converts bytes to characters using a specified charset
import java.io.IOException;


public class SabdGoog
{
	private String word;
	private String meaning;
	private String formattedOutput="";

	private void getFromURL(String word)
	{
		URL url;
		String urlstring = "http://en.m.wiktionary.org/wiki/"+word; 
		try 
		{
			url = new URL(urlstring);
	 
			URLConnection conn = url.openConnection();
 
                        Scanner urlContent = new Scanner(conn.getInputStream());
			while(urlContent.hasNext())
			{
				meaning += urlContent.nextLine();
				
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

	private void formatResult()
	{
		int startIndex = 0;
		int stopIndex = 100;

		formattedOutput+="<h2>Wiktionary</h2>";

		if(meaning.indexOf("There were no results matching the query.")>=0)
		{
			formattedOutput+="<b>"+word+": Error: Word Not Found</b>";
		}
		else 
		{
			
			formattedOutput+=meaning+"<hr/>";
			
		}
		
	}

	public void setWord(String s)
	{
		word = s;
	}

	public String getFormattedOutput()
	{
		getFromURL(word);
		formatResult();
		return formattedOutput;
	}

}

