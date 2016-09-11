**CUNY Tech Prep 2016-2017**

# Lab 2 Handout: Stacks, Queues, and Sets

## Definitions

* [Stacks](https://en.wikipedia.org/wiki/Stack_(abstract_data_type))
    - are an abstract data type that serves as an _ordered_ collection of elements. It provides two primary operations, `push(x)` to insert elements into the collection, and `pop()` to remove the most recently inserted element from the collection. This a **LIFO** (Last In, First Out) collection data type.
* [Queues](https://en.wikipedia.org/wiki/Queue_(abstract_data_type))
    - are an abstract data type that serves as an _ordered_ collection of elements. It provides two primary operations, `add(x)` to insert elements into the collection, and `remove()` to remove the first-most inserted element from the collection. This a **FIFO** (First In, First Out) collection data type.
* [Sets](https://en.wikipedia.org/wiki/Set_(abstract_data_type))
    - are an abstract data type that serves as an _unordered_ collection of elements. It provides two primary operations, `add(x)` to insert elements into the collection, and `remove(x)` to remove specific elements. The collection keeps only unique element values, discarding duplicate entries.

## Review Materials

*Videos:*

* [Stacks and Queues, by DerekBanas](https://www.youtube.com/watch?v=JvGZh_BdF-8&index=3&list=PLGLfVvz_LVvReUrWr94U-ZMgjYTQ538nT) (16min)
* [Stacks and Queues, by BlondieBytes](https://www.youtube.com/watch?v=fOHLom4hZME) (27min)

*Textbook:*

* [Stacks, Queues, and Deques](http://www.brpreiss.com/books/opus5/html/page130.html#SECTION007000000000000000000)
* [Basic Sets](http://www.brpreiss.com/books/opus5/html/page385.html#SECTION0013000000000000000000)
* [Stacks and Queues](http://math.hws.edu/javanotes/c9/s3.html)

*Additional Resources:*

* [Test your knowledge, including Big-O](http://pages.cs.wisc.edu/~vernon/cs367/notes/5.STACKS-AND-QUEUES.html)

### Questions to consider

* When do you use a _Stack_ vs a _Queue_?
* Stacks and Queues are simply interfaces to abstract concepts. Both Stacks and Queues can be implemented with either Arrays or LinkedLists. In each case, there are pros and cons. For each, the stack and queue, compare the pros and cons of implementing it with Arrays vs LinkedLists.
* What are the different ways we can implement a _Set_?
