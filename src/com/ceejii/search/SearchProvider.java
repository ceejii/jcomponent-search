package com.ceejii.search;

import com.ceejii.gui.component.SearchSuggestionComponent;

public interface SearchProvider {

	void quickSearchForString(String searchString, SearchSuggestionComponent view);

	void fullSearchForString(String searchString,
			SearchSuggestionComponent component);

}
