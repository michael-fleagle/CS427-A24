# CS427-A24
Repository for the CS427 A24 assignment

Below is the A24 assignment as provided by Dr. Andonie of Central Washington University



Q1. Implement in Java the greedy algorithm for giving change with minimum number of coins:

   while (more coin-sizes && change<amount owed)
        choose the largest remaining coin-size
        if (adding the coin does not make the change exceed the amount owed)
             then add coin to change
             else delete coin-size

   Design specifications:

    Represent the coin denominations in a heap ADT using the PriorityQueue or the PriorityBlockingQueue class. Make the heap independent of the application by using class IntegerCompare, implementing Comparator.
    Represent the change in a set ADT using the HashMap or the TreeMap class.
    You should enter the coin denominations (any denominations, not only the "normal" denominations) and the amount owed. The program should display the change.

Q2. Find an instance (the amount owed and the available set of coin sizes) for which your program cannot give the change, even when this is theoretically possible.

Q3. Analyze your algorithm (worst case only). Don’t forget that you are using a heap and a map (it is a good idea to review execution times for these data structures).

Q4. Could we use other data structures instead of heap and map to improve our implementation? Give ideas and use arguments (asymptotic time, easy to implement, etc).

 

Submit the source code for Q1 and the answers to Q2-Q4. 
