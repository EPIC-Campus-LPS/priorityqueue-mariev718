# Lab 10: Priority Queue

## Objective
Priority queues have a number of applications in programming, such as scheduling jobs for CPU or processing the order of printing jobs. Depending on how the priority is defined (i.e. time entered into queue, length of job, etc.) the average waiting time for jobs to be completed will vary.

In this lab, you will implement your own generic PriorityQueue class that will store a queue using a heap. A priority queue is a queue in which the element with highest priority (noted by the “smallest” value for this lab) is always at the front of the queue.
## Creating a Priority Queue
For this assignment, you are to use the provided `PriorityQueue.java` class. You are to fill out all of the stubbed methods for this class. The methods that are labeled private are helper methods that also need to be filled. These can (and should) be used in other methods of this class. Remember to handle the cases when the queue is empty. The toString method should just show the contents of the array (from index 0, up to size – 1).

Your class will be tested with the instructor’s main. Be sure to test yours thoroughly and be sure to NOT change the names of the methods and files in the skeleton. If you would like to add your own helper methods, you are welcome to do so.
## Testing
Please create JUnit tests with 85% coverage for your program.
## Javadoc
Fill in the Javadoc comments and generate a Javadoc HTML reference for your program.
## Rubric
4 points – All requested items are present. Functional and efficient `PriorityQueue` class as described above. Javadoc reference for the class. JUnit tests with a coverage report of at least 85%.
3 points – Some of the requested items are missing. Classes are complete but are missing Javadoc reference. Test cases are missing or incomplete.
2 points – Missing or incomplete. Student should re-attempt