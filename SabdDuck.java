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

  	This is the module that communicates with DuckDuckGo. 
*/

import java.util.Scanner;		//for getting input from a source
import java.net.URL;			//class representing a URL
import java.net.URLConnection;		//abstract class, represents connection between app and URL
import java.net.MalformedURLException;
import java.io.InputStreamReader;	//converts bytes to characters using a specified charset
import java.io.IOException;


public class SabdDuck
{
	private String word;
	private String result;
	private String formattedOutput="";

	private void getFromURL(String word)
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
				result = urlContent.nextLine();
				
				if(result.indexOf("Definition")>=0)
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

	private void formatResult()
	{
		int startIndex = 0;
		int stopIndex = 0;

		formattedOutput+="\n\nDuckDuckGo:\n\n"+word+": ";

		if(result.indexOf("\"\"")>=0)
		{
			formattedOutput+="Error: Word Not Found.\n_______________\n\n";	
		}

		else if(result.indexOf("Definition")>=0)
		{	
			startIndex = result.indexOf("Definition")+14;
			if(result.indexOf("definition:")>=0)
			{
				startIndex = result.indexOf("definition:")+12;
				formattedOutput+="\"";
			}	
			stopIndex=result.lastIndexOf("\",");
			formattedOutput+=result.substring(startIndex, stopIndex)+"\"\n_______________\n\n";
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
