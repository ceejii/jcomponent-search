package com.ceejii.gui;

import java.awt.event.ActionEvent;

public interface SearchSuggestionListener {

	public void resultChosen(ActionEvent event);
	
	public void resultHovered(ActionEvent event);
	
	public void resultNoLongerHovered(ActionEvent event);

	public void setSupportsHovering(boolean supportsHovering);
}
