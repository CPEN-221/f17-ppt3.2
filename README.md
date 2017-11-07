CPEN 221 / Fall 2017

Programming Proficiency Test
=========

November 7, 2017

## General Instructions

+ You have 72 minutes (1h 12m) to complete the assigned tasks.
+ Take your time to read the question.
+ Skeleton code can be obtained by cloning this repository. Add JUnit to your build path in Eclipse.
+ Best of luck!

## Submission Instructions

+ Submit your work to the Github classroom repository that was created for your.
+ **Do not alter the directory/folder structure. You should retain the structure as in this repository.**
+ Do not wait until the last minute to push your work to Github. It is a good idea to push your work at intermediate points as well. _I would recommend that you get your Git and Github workflow set up at the start._

## Honour Code

By submitting your work to Github you agree to the following:

+ You did not consult with any other person in completing the examination.
+ You did not aid any other person in the class in completing their examination.
+ If you consulted any external sources, such as resources available on the World Wide Web, in completing the examination then you have cited the source. (You do not need to cite class notes or Sun/Oracle Java documentation.)
+ You are not aware of any infractions of the honour code for this examination.

> Violations of this honour code will be treated as a case of academic misconduct and will dealt with under UBC policies governing such issues. A consequence of this may be to nullify this exam for everyone that submits work for grading!

## Question: Bag of Strings
> The skeleton source code for this question is in the package `BagOString`. You have to implement the required method in the class `BagOString`. You may import the provided code as a Gradle project in Eclipse.

A `BagOString` allows us to store `Strings`s (including duplicates) and provide some operations on the collection.

We shall define the **weight** of a bag of `String`s as follows: it is the sum of the squares of the counts of the different alphabets in the bag. (Upper- and lowercase alphabets are treated the same. All other characters can be ignored.) If a bag has the `String`s `"abba"` and `"baa baa"` then `a` occurs 6 times and `b` occurs 4 times, and the weight of the bag is `6*6 + 4*4 = 52`.

Here are the essential operations that a `BagOString` supports:

1. **Creators**
	1. Create an empty `BagOString`
	2. Create a `BagOString` using an array of `Strings`s as initial values
2. **Mutators**
	1. Add a given `String`
	2. Remove one occurrence of a given `String`
	 **Observers**
	1. Check if a `String` is in the bag
	2. Return a count of the number of occurrences of a `String` in the bag
	3. Return a count of the number of occurrences of an alphabet in the bag (other characters can be ignored)
	4. Return the weight of the bag (weight was defined earlier)
	5. Verify equality: two `BagOString` are equal if and only if each alphabet occurs the same number of times in each bag
	6. A suitable hash code operation

### Specifications

```
// Create an empty OddEvenBag
BagOString()

// Create a BagOString using the elements in the provided array
// requires: seedArray is not null
BagOString(String[] seedArray)

// add s to the BagOString
void add(String s)

// remove s from the BagOString
// if s does not exist in the Bag then do nothing
void remove(String s)

// return true if this BagOString contains s
// and false otherwise
boolean contains(String s)

// count the occurrences of String s in the bag
int getCount(String s)

// count the occurrences of char c in the bag
int getCount(char c)

// return the weight of the bag
long weight()
```

Although not listed above, `equals()` and `hashCode()` should be implemented.

### Test Cases

```java
@Test
public void test1() {
	BagOString boss = new BagOString();
	boss.add("frodo");
	assertTrue(boss.contains("frodo"));
	assertEquals(7, boss.weight());
}

@Test
public void test2() {
    	BagOString boss = new BagOString(new String[] { "frodo", "bilbo" });
    	assertTrue(boss.contains("bilbo"));
    	assertEquals(18, boss.weight());
}

@Test
public void test3() {
    	BagOString boss1 = new BagOString(new String[] { "for", "do" });
    	BagOString boss2 = new BagOString(new String[] { "frodo" });
    	assertTrue(boss1.equals(boss2));
}

@Test
public void test4() {
    	BagOString boss = new BagOString(new String[] { "frodo", "bilbo" });
    	assertTrue(!boss.contains("sauron"));
}

@Test
public void test5() {
    	BagOString boss = new BagOString(new String[] { "potter" });
    	boss.add("granger");
    	boss.add("weasley");
    	assertTrue(boss.contains("potter"));
    	boss.remove("potter");
    	assertTrue(!boss.contains("potter"));
}

@Test
public void test6() {
    	BagOString boss = new BagOString(new String[] { "potter" });
    	boss.add("potter");
    	assertEquals(2, boss.getCount("potter"));
}

@Test
public void test7() {
    	BagOString boss = new BagOString(new String[] { "potter" });
    	boss.add("potter");
    	boss.add("voldemort");
    	assertEquals(5, boss.getCount('t'));
}
```

## What Should You Implement / Guidelines

+ You should implement all the methods that are indicated with `TODO`.
+ Passing the provided tests is the minimum requirement. Use the tests to identify cases that need to be handled. Passing the provided tests is *not sufficient* to infer that your implementation is complete and that you will get full credit. Additional tests will be used to evaluate your work. The provided tests are to guide you.
+ You can implement additional helper methods if you need to but you should keep these methods `private` to the appropriate classes.
+ You do not need to implement new classes.
+ You can use additional standard Java libraries by importing them.
+ Do not throw new exceptions unless the specification for the method permits exceptions.

## Answers to FAQs

#### Can I consult Java documentation and other Internet-based sources?

Yes, you can. The point of this test is not to demonstrate mastery over syntax but that you can solve a problem in a reasonable amount of time with reasonable resources.

*If you find useful information online outside the official Java documentation and the course material, you must cite the source. You should do so by adding comments in your source code.*

Naturally you are expected to adhere to all of the course and UBC policies on academic integrity.

#### Isn't one hour too short to produce a working implementation?

The questions are straightforward, and these are not very different from what one might sometimes encounter on a job interview (for example). The difference is that you get less time during an interview (10-15 minutes) with no access to additional resources. So the time allotted is reasonable in that regard and I am expecting that everyone will be able to clear this bar. The goal is that it is possible to say, at a minimal level, what everyone who completes this course can achieve.

#### Why am I not guaranteed full credit if my implementation passes all the provided tests?

It is easy to develop an implementation that passes the provided tests and not much else. A good-faith implementation that passes all the provided tests is very likely to pass other tests too.
