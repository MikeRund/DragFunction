README

This file will cover the thinking behind the approach taken, a high-level overview, decisions made,
and ideas to optimize for speed

*********************************************************************************************************
APPROACH REASONING

Looking at the problem, I broke things down into chunks that I could code the solution for. For example,
in order to check if a vertex of A was within 20 points of a vertex of B, this was how I ratioanlized 
the problem:
  Code will need to find the closest vertex
    --> Code will need to compare distances between vertices of shape A and shape B
      --> Code will need to calculate distances bewtween vertices
        --> Code will need to define a vertex
        
Which led to the following:
  Vertex class
    --> Polygon class
      --> calculateDistance() method 
        --> calculateClosestVertex() method

Similarly, I followed the same line of thought for points and midpoints. I.e, in order to compare
distances between midpoints and vertices, I would need to generate a list of midpoints

This resulted in the format of my code, where functionality was split into different packages. I.e 
function, geometry, model, and util. 

I decided that a Polygon class would be useful to encapsulate methods for generating 
coordinates. This way, the later code remains short and neat, while also allowing easier testing, refactoring
and changes. GeometryUtil then provides methods which provide the analytic tools needed to run the algorithm.

*********************************************************************************************************
HIGH-LEVEL OVERVIEW

As mentioned in the last section, functionality was split into relevant packages. The basis of the code is the Coord, 
Polygon and GeometryUtil classes. 

A list of Coord objects is used to store the list of vertices of shapeA, which the Polygon class then uses to generate 
a list of midpoints and equally spaced points between each consecutive vertex. The generation of these lists allow 
easy implementation and testing of methods to check which vertex / midpoint / point in shape A is closest to a vertex
in shape B. These methods are encapsulated in the static GeometryUtil class. The PointData class allows the closest
vertex / midpoint / point to be stored and returned as well as the relevant distance.

Before writing the algorithm for the dragMove() function, the SnapResult class was created to store the relevant data 
that dragMove() will need to return. Also, the ResultBuilder class contains a method to generate the boilerplate code
required to create and set the SnapResult object to the correct result. 

With all the elements of the algorithm handled, the dragMove() function simply checks if the first condition is met when
the function is called, if not the code moves onto the next condition, and continues until a snapping condition is met 
or the algorithm determines that no snapping occurs. If a snapping condition is met, the relevant points and distance
are stored in a PointData obj which is then parsed to the ResultBuilder, along with a string detailing which type of 
snapping occurred. ResultData then builds the SnapResult, including the snapDetails string and calculating the new 
snapped vertices of B utilizing the calculatedSnapped() method in GeometryUtil. 

*********************************************************************************************************
SPEED-OPTIMIZATION RECOMMENDATIONS

An obvious cause of speed issues in this code is the inclusion of nested-loops, specifically when checking distances 
between all vertices. One workaround would be to not actually calculate the distance between all vertices / midpoints 
/ points. For example, if shape A is significantly higher than shape B, we can confidently say that the bottom vertices 
of shape B will not need to be checked to find the closest distance. The same logic can be applied if shape A is 
significantly more left, right, or below B. 
   
