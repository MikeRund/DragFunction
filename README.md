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

Similarily, I followed the same line of thought for points and midpoints. I.e, in order to compare
distances between midpoints and vertices, I would need to generate a list of midpoints

This resulted in the format of my code, where functioanility was split into different packages. I.e 
function, geometry, model, and util. 

I decided that a Polygon class would be useful to encapsulate methods for anlayzing / generating 
coordinates. This way, the later code remains short and neat, while also easier testing, refactoring
and changes. 

*********************************************************************************************************
HIGH-LEVEL OVERVIEW
As mentioned in the last section 
  
