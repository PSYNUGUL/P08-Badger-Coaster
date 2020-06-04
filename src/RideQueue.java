//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: Badger Coaster
// Files: BoardingGroup.java , RideQueue.java, ThemeParkApp.java
////////////////
// Course: CS300 Spring 2020
//
// Author: Yeon Jae Cho
// Email: ycho226@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: none
// Partner Email: none
// Partner Lecturer's Name: none
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understood the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: none
// Online Sources: just piazza
//
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * This class implements QueueADT<T> with type of BoardingGroup for using the classes provided with
 * changed Type value.
 * 
 * This class is used to modify constructor and methods, and initialize the field values provided.
 */
public class RideQueue implements QueueADT<BoardingGroup> {
  /**
   * First group in line.
   */
  private BGNode front;

  /**
   * Last group in line.
   */
  private BGNode back;

  /**
   * Max number of people that can fit into the queue.
   */
  private int capacity;

  /**
   * Number of people in group.
   */
  private int numOfPeople;

  /**
   * Number of groups in line.
   */
  private int numOfGroups;

  /**
   * Constructs an empty queue with the designated capacity.
   * 
   * @param capacity the number of people this queue can fit
   */
  public RideQueue(int capacity) {
    this.capacity = capacity;
    front = null;
    back = null;
  }

  /**
   * Determines whether or not this queue is empty.
   * 
   * @return true when queue is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    if (numOfGroups != 0) {
      return false;
    }
    return true;
  }

  /**
   * Gives the number of groups waiting in line.
   * 
   * @return the current number of groups in the queue.
   */
  @Override
  public int size() {
    return numOfGroups;
  }

  /**
   * Returns the BoardingGroup at the front of this queue without removing it.
   *
   * @return group on the first of the line
   * @throw NoSuchElementException if this queue is empty
   */
  @Override
  public BoardingGroup peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("There is no group waiting for the ride in line.");
    }
    return front.getGroup();
  }

  /**
   * Adds the new group into the queue.
   * 
   * @param newGroup new group to be added into waiting line
   * @throws IllegalStateException if new group cannot fit into the queue
   */
  @Override
  public void enqueue(BoardingGroup newGroup) {
    if (newGroup.getNumber() + numOfPeople > capacity) {
      throw new IllegalStateException(
          "There is no space in line for the new group to be added in line.");
    }

    BGNode groupNode = new BGNode(newGroup);

    if (newGroup.isVip()) {
      BGNode forcedGroup = front;
      front = groupNode;
      front.setNext(forcedGroup);
    }

    if (numOfGroups == 0) {
      front = groupNode;
      back = groupNode;
    } else {
      back.setNext(groupNode);
      back = groupNode;
    }

    int newSize = newGroup.getNumber();
    for (int i = 0; i < newSize; i++) {
      numOfPeople++;
    }
    numOfGroups++;
  }

  /**
   * Returns the BoardingGroup at the front of this queue and removes it.
   * 
   * @return the BoardingGroup that was removed from this queue.
   * @throws NoSuchElementException if queue is empty
   */
  @Override
  public BoardingGroup dequeue() {
    BoardingGroup removedGroup;
    if (isEmpty()) {
      throw new NoSuchElementException("There is no group in line to be removed.");
    } else {
      numOfGroups--;
      removedGroup = front.getGroup();
      front = front.getNext();
    }
    return removedGroup;
  }

  /**
   * Removes all groups from this queue, making this an empty queue.
   */
  @Override
  public void clear() {
    numOfPeople = 0;
    numOfGroups = 0;
    front = null;
    back = null;
  }

  /**
   * Returns a string representation of this RideQueue.
   * 
   * @return queue represented as a string.
   */
  public String toString() {
    String s = "Number of People in Queue: " + numOfPeople + "\n";
    s += "Number of Groups in Queue: " + numOfGroups + "\n";
    s += "Group Names in Queue: ";
    BGNode current = front;
    while (current != null) {
      String groupName = current.getGroup().getName();
      s += groupName + " ";
      current = current.getNext();
    }
    return s;
  }
}


