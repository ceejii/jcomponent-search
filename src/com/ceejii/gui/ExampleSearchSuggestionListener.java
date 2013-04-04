package com.ceejii.gui;

import java.awt.event.ActionEvent;

import com.ceejii.gui.data.SearchSuggestion;

public class ExampleSearchSuggestionListener implements SearchSuggestionListener {
	
	public void resultChosen(ActionEvent event) {
		SearchSuggestion source = (SearchSuggestion) event.getSource();
		String id = source.getSuggestionId();
		String name = source.getSuggestionName();
	}

	public void resultHovered(ActionEvent event) {
		if(event.getSource() instanceof SearchSuggestion) {
			SearchSuggestion source = (SearchSuggestion) event.getSource();
			String clue = source.getSuggestionClue();
			System.out.println("Hovered " + source.getSuggestionName());
		}
	}

	public void resultNoLongerHovered(ActionEvent event) {
		if(event.getSource() instanceof SearchSuggestion) {
			SearchSuggestion source = (SearchSuggestion) event.getSource();
			String clue = source.getSuggestionClue();
			System.out.println("No longer hovering " + source.getSuggestionName());
		}
	}

}
