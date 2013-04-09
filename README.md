jcomponent-search
=================

A JComponent (Java) for searching with live searchresults while you type

#Detailed description
It's a Swing JComponent that can display search results as you type. It searches using a SearchProvider that you have 
to supply. It's rather simple to provide it, just implement an interface with two methods and handle searches with a 
string as the search term. You can optionally supply your own JComponent objects to be displayed as search suggestions 
or you can use the defaults. Finally you have to implement an interface that contains the logic for what to do when the 
user either selects a search results or if the user starts or stops hovering the search suggestion with the mouse.

#Future possible features
* Delay between search and last keypress
* Example styled search suggestion
* JavaDoc

#Known issues
None.

#Checklists for developers using this component

## Normal usage
1. Download and add to your project.
2. Create a new class that implements SearchProvider and implement the two required methods. See included 
ExampleSearchProvider for inspiration.
3. Create a containing JPanel, JFrame or re-use an existing container. Add a new instance of SearchSuggestionComponent 
to it. Give your implementation of SearchProvider as parameter to the SearchSuggestionComponent constructor.
4. (Recommended) Add a ComponentListener to the searchSuggestionComponent instance and implement the componentResized 
with window.pack; (Where window is the container you put the SearchSuggestionComponent in. This resizes your panel 
when the number of search suggestions change or their size change.
5. Create a SearchSuggestionListener that does whatever you want to do when a search suggestion is clicked or hovered.

## Implementing your own JComponent for SearchSuggestions
1. Create a new class that extends JComponent and implements SearchSuggestion

#Distribution formats
Source only

#External dependencies
None.

#Java version required
1.5 or later.

#License
BSD 3-clause license. See LICENSE file.
