jcomponent-search
=================

A JComponent (Java) for searching with live searchresults while you type

#Detailed description
It's a Swing JComponent that can display search results as you type. It searches using a SearchProvider that you have 
to supply. It's rather simple to provide it, just implement an interface with two methods and handle searches with a 
string as the search term. You can optionally supply your own JComponent objects to be displayed as search suggestions 
or you can use the defaults. Finally you have to implement an interface that contains the logic for what to do when the 
user either selects a search results or if the user starts or stops hovering the search suggestion with the mouse.

#External dependencies
None.

#Java version required
1.5 or later.

#License
All rights reserved. To be changed to some open-source license in the future.
