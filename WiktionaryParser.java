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
	WiktionaryParser.java
	
	This class gets the meaning from Wiktionary.org and formats it.
*/

import java.net.*;
import java.io.*;

public class WiktionaryParser
{
	private String searchWord;
	private BufferedReader receivedText;
	private BufferedReader formatedText;

	public WiktionaryParser(String word)
	{
		searchWord = word;
	}
	
	private void getPage()
	{
		URL searchUrl;
		
		try
		{
			url = new URL("http://en.m.wiktionary.org/wiki/"+searchWord);
			URLConnetion connection = url.openConnection();
			buffReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		}
		catch (MalformerURLException error)
		{
			error.printStackTrace();
		}
		catch (IOException error)
		{
			error.printStackTrace();
		}
	}
	private void formatPage()
	{
		
	}
}
