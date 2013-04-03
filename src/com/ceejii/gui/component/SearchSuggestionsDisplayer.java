package com.ceejii.gui.component;

import java.util.List;

import javax.swing.JComponent;

import com.ceejii.gui.SearchSuggestionListener;
import com.ceejii.gui.data.SearchSuggestion;

public interface SearchSuggestionsDisplayer {

	void showSearchResults(List<String> names, SearchSuggestionListener listener);

	<T extends JComponent & SearchSuggestion> void showSearchResultsComponents(List<T> results);

}
