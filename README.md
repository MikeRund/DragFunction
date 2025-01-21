# Drag Move

This file will cover the thinking behind the approach taken, a high-level overview, decisions made,
and ideas to optimize for speed.

## PROBLEM
This repo implements the solution to the following problem set:

![image](https://github.com/user-attachments/assets/4b00d8f9-66a3-49f9-969c-4d198b7cdb6e)

## VIEWING ORDER 

The best order for first viewing this project, showcasing the logic flow and implementation steps, is as follows 

        1. README
        2. Coord
        3. Polygon
        3a. (PolygonTest)
        4. PointData 
        5. GeometryUtil 
        5a. (GeometryUtilTest)
        6. SnapResult
        7. ResultBuilder
        8. DragMove
        8a. (Main)




## HIGH-LEVEL OVERVIEW

Functionality was split into relevant packages. The basis of the code is the Coord, Polygon and GeometryUtil classes.

A list of Coord objects is used to store the list of vertices of shapeA, which the Polygon class then uses to generate
a list of midpoints and equally spaced points between each consecutive vertex. The generation of these lists allow
easy implementation and testing of methods to check which vertex / midpoint / point in shape A is closest to a vertex
in shape B. These methods are static and encapsulated in the GeometryUtil class. The PointData class allows the closest
vertex / midpoint / point to be stored and returned as well as the relevant distance.

Before writing the algorithm for the dragMove() function, the SnapResult class was created to store the required data
that dragMove() will need to return. Also, the ResultBuilder class contains a method to generate the boilerplate code
needed to create and set the SnapResult object to the correct result.

With all the elements of the algorithm handled, the dragMove() function simply checks if the first snapping condition is
met via the calculateDistance() function, if not the code moves onto the next condition, and continues until a snapping
condition is met or the algorithm determines that no snapping occurs. If a snapping condition is met, the relevant points
and distance are stored in a PointData object which is then parsed to the ResultBuilder, along with a string detailing 
which type of snapping occurred. ResultData then builds the SnapResult, including the snapDetails string and calculating 
the new snapped vertices of B utilizing the calculatedSnapped() method in GeometryUtil.

The main method only served as a way to run some dummy data, and showcases each condition of the algorithm activating.
*********************************************************************************************************

## APPROACH REASONING

Looking at the problem, I initially broke the required functionality down into bite-sized chunks that I could code
the solution for. For example, in order to check if a vertex of A was within 20 points of a vertex of B, this was how
I rationalized the problem:

    --> Code will need to find the closest vertex
      --> Code will need to compare distances between vertices of shape A and shape B
        --> Code will need to calculate distances between vertices
          --> Code will need to define a vertex

Which led to the following:

    --> Vertex class
      --> Polygon class
        --> calculateDistance() method 
          --> calculateClosestVertex() method

Similarly, I followed the same line of thought for points and midpoints. I.e, in order to compare distances between
midpoints and vertices, I would need to generate a list of midpoints.

This resulted in the format of my project, where functionality was split into different packages. I.e function,
geometry, model, and util.

I decided that a Polygon class would be useful to encapsulate methods for generating midpoints and line points. This way,
the later code remains short and neat, while also allowing easier testing, refactoring and changes. In regard to 
generating points between vertices, I opted to not just focus on integral points on a line and instead generate equally
spaced points. This approach made sense to me as we'd want shape B to snap fairly close to the position it is in when 
we meet the third snapping criteria. Also, depending on shape A there could be very little to no integral points 
between a pair of vertices.

GeometryUtil then provides methods which provide the analytic tools needed to run the algorithm. Again, I thought it best
to encapsulate all the geometric methods in one utility class for code neatness, and easy testing / changes. Originally,
I just had the methods in GeometryUtil returning the closest distance between the desired type of co-ordinate. But of
course, the dragMove() function has to return information on which vertex has activated the snap condition. This lead me
to incorporate the PointData class into the methods of GeometryUtil. This way, the methods that calculate the distance
between the relevant co-ordinates can also return each co-ordinate as well as the distance inside a PointData object.

The same line of thinking is what led to the SnapResult class, which allows the required data to be easily handled.
The introduction of the ResultBuilder class happened when I noticed most of the code for the dragMove function was 
repeated in each if-elif block. Moving this boilerplate code to a class to generate this each time was simple as the 
only difference in the code (whether the snap was a vertex / midpoint / point) could be parsed in as a String.

*********************************************************************************************************
## SPEED-OPTIMIZATION RECOMMENDATIONS

An obvious cause of speed issues in this code is the inclusion of nested-loops, specifically when calculating closest  
points. One workaround would be to not actually calculate the distance between all vertices / midpoints 
/ points. For example, if shape A is significantly higher than shape B, we can confidently say that the bottom vertices 
of shape B will not need to be checked to find the closest distance. The same logic can be applied if shape A is 
significantly more left, right, or below B. By utilizing an algorithm to check for extreme points we'd be able to 
determine whether a considerable amount of distance checks could be eliminated. 

Another method of optimizing the distance calculations between vertexes would be to incorporate spatial indexing techniques.
Specifically, I believe that quad trees would be the best choice for this problem due to its efficient indexing for 
point data, and its search function which can be modified to return the closest node of a given point. This would 
take the calculateClosest..() methods from O(n^2) to O(Log(N)) time complexity, where n is the number of points and 
N is the size of the distance. 
   
