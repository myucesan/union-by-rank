# UnionFind by the union by rank method.
UnionFind class that is used to keep track of disjoint sets. Usually used in combination with the Kruskal MST Algorithm to check for cycles.

Rank equals the depth of the tree. When you compare two disjoint sets you merge the set with the smaller rank into the set with the larger rank. If the ranks are equal you merge the the set with the "representative" with the bigger index into the set of the "representative" with the smaller index.

## Definitions
The representative is the root node that represents a disjoint set.

## Applications

- Kruskal's Minimum Spanning Tree Algorithm to keep track of when a cycle is created.
