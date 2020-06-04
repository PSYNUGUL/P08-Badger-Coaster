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
/**
 * This class is used to modify constructor and initialize the field values provided.
 */
public class BoardingGroup {
  /**
   * Name of the group to be added
   */
  private String groupName;

  /**
   * Size of the group to be added
   */
  private int groupSize;

  /**
   * VIP class of group - gets advantage in line
   */
  private boolean isVip;

  /**
   * Initializes the name and size of group according to parameter values
   * 
   * Sets the class of group as normal in default
   */
  public BoardingGroup(String groupName, int groupSize) {
    this.setName(groupName);
    this.setNumber(groupSize);
    setVip(false);
  }

  /**
   * Returns size of group
   * 
   * @return size of the group
   */
  public int getNumber() {
    return groupSize;
  }

  /**
   * Sets the size of the group
   */
  public void setNumber(int number) {
    this.groupSize = number;
  }

  /**
   * Returns name of group
   * 
   * @return name of the group
   */
  public String getName() {
    return groupName;
  }

  /**
   * Sets the name of the group
   */
  public void setName(String name) {
    this.groupName = name;
  }

  /**
   * Returns boolean value depending on the class of the group
   * 
   * @returns true if group is VIP class
   */
  public boolean isVip() {
    return isVip;
  }

  /**
   * Sets the class of the group
   */
  public void setVip(boolean isVip) {
    this.isVip = isVip;
  }
}
