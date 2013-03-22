package com.ceejii.gui.component;

import java.util.List;

import javax.swing.JComponent;

public interface SearchSuggestionDisplayer {

	void showSearchResults(List<String> results);

	void showSearchResultsComponents(List<JComponent> results);

}
