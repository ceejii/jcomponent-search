
package com.ceejii.gui.component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


//TODO: Add Searcher composite object and interface for it. Add default search implementation.

//TODO: Decide how to handle search delays. In Searcher or SearchSuggestionComponent

//TODO: Add Quick and Full search functionality where Full is triggered by Enter key. 

//TODO: Use nicer looking components for example search.

//TODO: internationalization or get/set for search instruction.

//TODO: Support for actions when clicking a search suggestion

//TODO: Support for actions when hovering over a search suggestion


/**
 * Copyright Christoffer Jonsson. All rights reserved. 
 * 
 * @author Christoffer Jonsson
 *
 */
public class SearchSuggestionComponent extends JPanel {

	private static final long serialVersionUID = -8154225394939376705L;

	private static final String SEARCH_INSTRUCTION = "Skriv en plats";
	private JPanel suggestionsPanel = null;

	public SearchSuggestionComponent(){
		setupLayout(this);
		add(buildSearchField(this));
		buildSearchSuggestions();
	}
	
	private void setupLayout(Container parent) {
		BoxLayout boxLayout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		this.setLayout(boxLayout);
	}

	private void buildSearchSuggestions() {
		showSearchResults(null);
	}

	private JComponent buildSearchField(Container parent) {
		JTextField searchField = new JTextField(SEARCH_INSTRUCTION);
		searchField.setPreferredSize(new Dimension(100,24));
		MouseAdapter mouseListener = new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent event) {
				super.mouseClicked(event);
				((JTextField)event.getSource()).setText("");
				((JTextField)event.getSource()).removeMouseListener(this);
			}
		};
		searchField.addMouseListener(mouseListener);
		KeyAdapter listener = new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent event) {
				super.keyPressed(event);
				String searchStringBeforeKeyPress = ((JTextField)event.getSource()).getText();
				if(searchStringBeforeKeyPress.equals(SearchSuggestionComponent.SEARCH_INSTRUCTION)){
					//Key pressed in search field but the search field contains the default instruction, remove the default text first!
					((JTextField)event.getSource()).setText("");
				}
			}
			@Override
			public void keyReleased(KeyEvent event) {
				// Handles normal key entry by searching for the string.
				super.keyPressed(event);
				String searchString = ((JTextField)event.getSource()).getText();
				searchForString(searchString);
				System.out.println(searchString);
			}
		};
		searchField.addKeyListener(listener );
		return searchField;
	}

	protected void searchForString(String searchString) {
		List<String> db = new ArrayList<String>();
		db.add("Stockholm");
		db.add("Göteborg");
		db.add("Malmö");
		db.add("Stockport");
		List<String> results = new ArrayList<String>();
		String lowerCase = searchString.toLowerCase();
		if (!searchString.equals("")) {
			for (String line : db) {
				if (line.toLowerCase().startsWith(lowerCase)) {
					results.add(line);
				}
			}
		}
		showSearchResults(results);
		((JFrame)this.getTopLevelAncestor()).pack();
	}

	public void showSearchResults(List<String> results) {
		if(results == null){
			return;
		}
		 List<JComponent> componentList = buildSearchResultsComponentList(results);
		 showSearchResultsComponents(componentList);
	}

	private List<JComponent> buildSearchResultsComponentList(List<String> results) {
		List<JComponent> list = new ArrayList<JComponent>();
		for (String result : results) {
			list.add(new JButton(result));
		}
		return list;
	}
	
	public void showSearchResultsComponents(List<JComponent> results) {
		if(suggestionsPanel == null) {
			suggestionsPanel = new JPanel();
		} else {
			suggestionsPanel.removeAll();
		}
		BoxLayout boxLayout = new BoxLayout(suggestionsPanel, BoxLayout.PAGE_AXIS);
		suggestionsPanel.setLayout(boxLayout);
		for (JComponent result : results) {
			suggestionsPanel.add(result);
		}
		add(suggestionsPanel);
	}
}
