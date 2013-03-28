package com.ceejii.gui.component;

import com.ceejii.gui.SearchSuggestionListener;

public interface SearchSuggestion {
	
	/**
	 * Gets the id of the SearchSuggestion. There are no specific requirements for this id. It doesn't have to be unique
	 * or have some specified format. It's intended to be useful for the implementer of the SearchSuggestionDisplayer interface.
	 * @return
	 */
	public String getSuggestionId();
	
	/**
	 * The hover data is what is returned from the SearchSuggestion when a further clue about the content is requested.
	 * 
	 * @return an Object of any kind, the using class is expected to know the type.
	 */
	public String getSuggestionClue();

	/**
	 * Gets the name that is displayed for the search result. This will be the most prominent information in the SearchResult.
	 * 
	 * @return a String
	 */
	public String getSuggestionName();
	
	public void addSearchSuggestionListener(SearchSuggestionListener listener);
}
