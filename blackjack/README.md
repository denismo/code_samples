Sample project demonstrating design and implementation of the application that estimates the value of a BlackJack hand.

Specification
=============

Write a program which accepts two inputs, representing two
playing cards out of a standard 52 card deck. Add these two cards
together to produce a blackjack score, and print the score on the screen
for the output.
 
Cards will be identified by the input, the first part representing the
face value from 2-10, plus A, K, Q, J. The second part represents the
suit S, C, D, H.
 
The blackjack score is the face value of the two cards added together,
with cards 2-10 being the numeric face value, and A is worth 11, and K,
Q, J are each worth 10.

Requirements
============

* Java 8

Usage
=====

1. Build using maven
    
> mvn package
  
2. Run the application

  Mode 1: 
  
    java -jar target/blackjack-1.0-SNAPSHOT-jar-with-dependencies.jar
  
  Will ask for input of cards. Sample input: AS,2D
  
  Mode 2: 
  
    java -jar target/blackjack-1.0-SNAPSHOT-jar-with-dependencies.jar AS,2D
  
  
 