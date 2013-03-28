
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
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ceejii.gui.ExampleSearchSuggestionListener;
import com.ceejii.search.ExampleSearchProvider;
import com.ceejii.search.SearchProvider;


//DONE: Add Searcher composite object and interface for it. Add default search implementation.

//DONE: Add Quick and Full search functionality where Full is triggered by Enter key. 

//DONE: internationalization or get/set for search instruction.

//DONE: Fix resizing problems that depends on how what hierarchy of containg containers exist.

//TODO: Support for actions when clicking a search suggestion

//TODO: Support for actions when hovering over a search suggestion

//TODO: Use nicer looking components for example search.

//TODO: Decide how to handle search delays. In Searcher or SearchSuggestionComponent



/**
 * Copyright Christoffer Jonsson. All rights reserved. 
 * 
 * @author Christoffer Jonsson
 *
 */
public class SearchSuggestionComponent extends JPanel implements SearchSuggestionDisplayer {

	private static final long serialVersionUID = -8154225394939376705L;

	private String searchInstruction = "Skriv en plats";
	private JPanel suggestionsPanel = null;

	protected SearchProvider searchProvider;

	public SearchSuggestionComponent(SearchProvider searchProvider){
		if(searchProvider == null) {
			throw new NullPointerException("SearchProvider for SearchSuggestionComponent must not be null.");
		}
		this.searchProvider = searchProvider;
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
		JTextField searchField = new JTextField(searchInstruction);
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
				JTextField jTextField = (JTextField)event.getSource();
				String searchStringBeforeKeyPress = jTextField.getText();
				if(searchStringBeforeKeyPress.equals(searchInstruction)){
					//Key pressed in search field but the search field contains the default instruction, remove the default text first!
					jTextField.setText("");
					//Remove all mouselisteners so a mouse-click won't remove the search instruction as well.
					//NOTE: Assumes there is only one mouselistener that removes search instruction.
					MouseListener[] mouseListeners = jTextField.getMouseListeners();
					for (int i = 0; i < mouseListeners.length; i++) {
						jTextField.removeMouseListener(mouseListeners[i]);
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent event) {
				// Handles normal key entry by searching for the string.
				super.keyPressed(event);
				String searchString = ((JTextField)event.getSource()).getText();
				SearchSuggestionComponent component =SearchSuggestionComponent.this;
				SearchProvider provider = component.searchProvider;
				if(event.getKeyCode() == KeyEvent.VK_ENTER){
					provider.fullSearchForString(searchString, component);
				} else {
					provider.quickSearchForString(searchString, component);
				}
				System.out.println(searchString);
			}
		};
		searchField.addKeyListener(listener );
		return searchField;
	}

	/**
	 * Shows the results in the search suggestion component.
	 * 
	 * @param names the List of name strings.
	 * @param ids the List of id strings.
	 * @param clues the list of clue strings.
	 */
	public void showSearchResults(List<String> names) {
		if(names == null){
			return;
		}
		List<ExampleSearchResultButton> componentList = buildSearchResultsComponentList(names);
		showSearchResultsComponents(componentList);
		this.revalidate();
	}

	private List<ExampleSearchResultButton> buildSearchResultsComponentList(List<String> names) {
		List<ExampleSearchResultButton> list = new ArrayList<ExampleSearchResultButton>();
		String[] namesArray = new String[names.size()];
		namesArray = names.toArray(namesArray);
		String name;
//		String[] idsArray = (String[]) ids.toArray();
//		String id;
//		String[] cluesArray = (String[]) clues.toArray();
//		String clue;
		for (int i = 0; i < namesArray.length; i++) {
			name = namesArray[i];
//			if(idsArray.length >= i){
//				id = idsArray[i];
//			} else {
//				id = "";
//			}
//			if(cluesArray.length >= i){
//				clue = cluesArray[i];
//			} else {
//				clue = "";
//			}
			list.add(new ExampleSearchResultButton(name, name, name));
		}
		return list;
	}
	
	public <T extends JComponent & SearchSuggestion> void showSearchResultsComponents(List<T> results) {
		if(suggestionsPanel == null) {
			suggestionsPanel = new JPanel();
		} else {
			suggestionsPanel.removeAll();
		}
		BoxLayout boxLayout = new BoxLayout(suggestionsPanel, BoxLayout.PAGE_AXIS);
		suggestionsPanel.setLayout(boxLayout);
		for (JComponent result : results) {
			if(!(result instanceof SearchSuggestion)) {
				throw new IllegalArgumentException("Programming error. Search results must implement the SearchSuggestion interface.");
			}
			suggestionsPanel.add(result);
		}
		add(suggestionsPanel);
	}

	public String getSearchInstruction() {
		return searchInstruction;
	}

	public void setSearchInstruction(String searchInstruction) {
		this.searchInstruction = searchInstruction;
	}

}
