#Assignment 2 Makefile

JC = javac

JFLAGS = -g

#default
default: Searcher.class nameSearchTree.class surnameSearchTree.class

#Dependencies

Searcher.class: Searcher.java
	$(JC) $(JFLAGS) Searcher.java

nameSearchTree.class: nameSearchTree.java
	$(JC) $(JFLAGS) nameSearchTree.java

surnameSearchTree.class: surnameSearchTree.java
	$(JC) $(JFLAGS) surnameSearchTree.java

clean:
	$(RM) *.class

