package com.ceejii.search;

import com.ceejii.gui.component.SearchSuggestionComponent;
import com.ceejii.gui.component.SearchSuggestionDisplayer;

public interface SearchProvider {

	void quickSearchForString(String searchString, SearchSuggestionDisplayer view);

	void fullSearchForString(String searchString,
			SearchSuggestionDisplayer view);

}
