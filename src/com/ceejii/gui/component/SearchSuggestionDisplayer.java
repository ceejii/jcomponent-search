package com.ceejii.gui.component;

import java.util.List;

import javax.swing.JComponent;

public interface SearchSuggestionDisplayer {

	void showSearchResults(List<String> names);

	<T extends JComponent & SearchSuggestion> void showSearchResultsComponents(List<T> results);

}
