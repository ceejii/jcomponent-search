package com.ceejii;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import com.ceejii.gui.component.SearchSuggestionComponent;
import com.ceejii.search.ExampleSearchProvider;

public class Startup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Create a main windows and fill it with a SearchSuggestionComponent.
		JFrame window = new JFrame("Sökförslag");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new FlowLayout());
		window.getContentPane().add(new SearchSuggestionComponent(new ExampleSearchProvider()));
		window.pack();
		window.setVisible(true);
	}

}
