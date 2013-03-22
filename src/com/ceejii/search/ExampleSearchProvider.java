package com.ceejii.search;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.ceejii.gui.component.SearchSuggestionComponent;

public class ExampleSearchProvider implements SearchProvider {

	@Override
	public void quickSearchForString(String searchString,
			SearchSuggestionComponent view) {
		//TODO: This near circular dependency of the Component being sent to the 
		// search provider and the provider being composite in the Component is a
		// little awkward I think. Redesign? MVC?
		List<String> db = new ArrayList<String>();
		db.add("Stockholm");
		db.add("Göteborg");
		db.add("Malmö");
		db.add("Stockport");
		List<String> results = new ArrayList<String>();
		String lowerCase = searchString.toLowerCase();
		if (!searchString.equals("")) {
			for (String line : db) {
				if (line.toLowerCase().startsWith(lowerCase)) {
					results.add(line);
				}
			}
		}
		view.showSearchResults(results);
		((JFrame)view.getTopLevelAncestor()).pack();

	}

	@Override
	public void fullSearchForString(String searchString,
			SearchSuggestionComponent component) {
		System.out.println("Full search (Enter key pressed).");
	}

}
