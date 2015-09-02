/*
  Reservation class, stores the person and room number in the Hotel
*/

public class Reservation{
  //instance variables
  private String name;
  private int roomNumber;

  //constructors, must supply the name, and optionally a room
  public Reservation(String person) {
    name = person;
  }
  
  public Reservation(String person, int room) {
    name = person;
    roomNumber = room;
  }

  //mutators, set the room number or name
  public void setRoom(int newroom) {
    roomNumber = newroom;
  }

  public void setName(String newname) {
    name = newname;
  }

  public String toString() {
    return (name + "   " + roomNumber);
  }

  //accessors, return the room number or name
  public int getRoom() {
    return roomNumber;
  }

  public String getName() {
    return name;
  }
}