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
	UI.java
	
	This class describes the GUI for the app.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JFrame implements ActionListener 
{
	private JTextField wordField;
	private JTextArea meaningArea;
	
	public UI()
	{
		super("Sabdakon");
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
	
		
		//"wordField" receives the user input
		wordField = new JTextField("Search...");
		textField.addActionListener(this);
		c.gridwidth = GridBagContraints.REMAINDER;
		c.fill = GridBagConstraints.HORIZONTAL;
		add(wordField, c);

		//"meaningArea" displays the meaning
		meaningArea = new JTextArea();
		meaningArea.setEditable = false;
		JScrollPane scrollPane = new JScrollPane(meaningArea);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		add(scrollPane, c);
		
			
	}	
	
	public void actionPerformed(ActionEvent event)
	{
		String word = textField.getText();
		WiktionaryParser wiktionaryParser = new WikionaryParser(word);
		meaningArea.append(wiktionaryParser.meaning());
	}
}
