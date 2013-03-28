package com.ceejii.gui;

import java.awt.event.ActionEvent;

import com.ceejii.gui.component.SearchSuggestion;

public class ExampleSearchSuggestionListener implements SearchSuggestionListener {
	
	public void ResultChosen(ActionEvent event) {
		SearchSuggestion source = (SearchSuggestion) event.getSource();
		String id = source.getSuggestionId();
		System.out.println("id: " + id);
		String name = source.getSuggestionName();
		System.out.println("name: " + name);
	}

	public void ResultHovered(ActionEvent event) {
		SearchSuggestion source = (SearchSuggestion) event.getSource();
		String clue = source.getSuggestionClue();
	}

}
