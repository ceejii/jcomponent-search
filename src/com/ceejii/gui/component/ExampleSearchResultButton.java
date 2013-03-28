package com.ceejii.gui.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.ceejii.gui.SearchSuggestionEvent;
import com.ceejii.gui.SearchSuggestionListener;

public class ExampleSearchResultButton extends JButton implements SearchSuggestion {

	private String id;
	private String clue;
	private String name;
	private SearchSuggestionListener searchSuggestionListener;

	public ExampleSearchResultButton(String name, String id, String clue) {
		super(name);
//		this.setText(name);
		this.name = name;
		this.id = id;
		this.setToolTipText(this.clue);
		this.clue = clue;
		this.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Mouse Clicked on button: " + ExampleSearchResultButton.this.getText() + " " + ExampleSearchResultButton.this.name);
			}

			public void mouseEntered(MouseEvent arg0) {
				//TODO: THis should call the SearchSuggestionComponent method that notifies listeners. Or should you just register listener on the JComponent.
				System.out.println("Mouse Entered over button: " + ExampleSearchResultButton.this.getText() + " " + ExampleSearchResultButton.this.name);
				searchSuggestionListener.ResultHovered(new SearchSuggestionEvent(ExampleSearchResultButton.this.name,ExampleSearchResultButton.this.id,ExampleSearchResultButton.this.clue));
			}

			public void mouseExited(MouseEvent arg0) {
				System.out.println("Mouse Exited over button: " + ExampleSearchResultButton.this.getText() + " " + ExampleSearchResultButton.this.name);
			}

			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	public String getSuggestionId() {
		return this.id;
	}

	public String getSuggestionClue() {
		return this.clue;
	}

	public String getSuggestionName() {
		return this.name;
	}

	public void addSearchSuggestionListener(SearchSuggestionListener listener) {
		this.searchSuggestionListener = listener;
	}
}
