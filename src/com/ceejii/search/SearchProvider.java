package com.ceejii.search;

import com.ceejii.gui.component.SearchSuggestionComponent;
import com.ceejii.gui.component.SearchSuggestionsDisplayer;

public interface SearchProvider {

	void quickSearchForString(String searchString, SearchSuggestionsDisplayer view);

	void fullSearchForString(String searchString,
			SearchSuggestionsDisplayer view);

}
