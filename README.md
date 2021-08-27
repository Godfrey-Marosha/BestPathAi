# BestPathAi
The A* (A-Star) search algorithm.

# The A* (A-Star) search algorithm 
The A* (A-Star) search algorithm is a path-finding algorithm with many uses, including Artificial Intelligence for games. The search builds the route from tile to tile until it reaches the goal. 
To help choose the best possible tile the algorithm will use an equation that takes into account the distance from the tile to the goal and the cost of moving to that tile.

Movement Cost for Terrain:

 # Non-walkable:
    N/A = Water (~)

  Walkable:

    1 = Flatlands (. or @ or X)
    2 = Forest (*)
    3 = Mountain (^)

Test Map:

  @*^^^   
  ~~*~.    
  **...
  ^..*~
  ~~*~X

 @ = User start
X = The goal tile

Test Map Solution:
 # = Best path
  ##^^^
  ~~#~.
  **.#.
  ^..#~
  ~~*~#
 
When you have a working solution, try it out on this move involved map:

large_map.txt

Please supply your large_map.txt with the "#" path your logic walked as part of the solution.
