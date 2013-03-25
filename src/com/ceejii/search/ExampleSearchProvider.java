package com.ceejii.search;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.ceejii.gui.component.SearchSuggestionComponent;
import com.ceejii.gui.component.SearchSuggestionDisplayer;

public class ExampleSearchProvider implements SearchProvider {

	@Override
	public void quickSearchForString(String searchString,
			SearchSuggestionDisplayer view) {
		//NOTE: For future Java versions the view could instead be a function pointer/lambda that handles the display of the result.
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

	}

	@Override
	public void fullSearchForString(String searchString,
			SearchSuggestionDisplayer view) {
		System.out.println("Full search (Enter key pressed).");
	}

}
