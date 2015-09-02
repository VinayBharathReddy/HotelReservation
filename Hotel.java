/*
  the Hotel is an ArrayList of Reservations
  it allows a person to request a room and cancel their reservation
  also we can add more rooms
*/
import java.util.ArrayList;

public class Hotel{
  //instance variable, ArrayList tracks current reservations
  private ArrayList<Reservation> rooms;
  private int rnum = 1;
  //constructors, can specify how many rooms to start with
  //default is 5 rooms
  Reservation reserveObj;

  /**
   *constructor.
   */
  public Hotel() {
    rooms = new ArrayList<Reservation>();
    rooms.ensureCapacity(5);
    for (int i = 0; i < 5; i++) {
      rooms.add(null);
    }
  }

  /**
   *Constructor.
   */
  public Hotel(int numRooms) {
    rooms = new ArrayList<Reservation>();
    rooms.ensureCapacity(numRooms);
    for (int i = 0; i < numRooms; i++) {
      rooms.add(null);
    }
  }

  //adds more rooms to the hotel, returns true on success
  /**
   *method for build rooms.
   */
  public boolean buildRooms(int num) {
    //make sure the parameter is valid
    if (num <= 0) {
      return false;
    }
    //increase the capacity of the Vector
    rooms.ensureCapacity(rooms.size() + num);
    for (int i = 0; i < num; i++) {
      rooms.add(null);
    }
    //report succes
    return true;
  }

  //reserves and returns an available room
  //or returns -1 if the hotel is full
  /**
   *method for reserve room.
   */
  public int reserveRoom(String person) {
    for (int i = 0; i < rooms.size(); i++) {
      if (rooms.get(i) == null) {
        reserveObj = new Reservation(person);
        reserveObj.setRoom(rnum);
        rooms.set(i,reserveObj);
        rnum++;
        return rnum - 1;
      }
    }
    return -1;
  }

  //reserves a particular room for this person
  //returns false on failure (eg. room is already reserved)
  /**
   *Reserve room with person and room number.
   */
  public boolean reserveRoom(String person, int roomNum) {
    try {
      if (rooms.get(roomNum - 1) == null) {
        reserveObj = new Reservation(person,roomNum);
        rooms.set(roomNum  - 1,reserveObj);
        rnum++;
        return true;
      }
    } catch (Exception vb) {
      return false;
    }
    return false;
  }
  //cancels all reservations by this person
  /**
   *Cancelling Reseravations.
   */
  public void cancelReservations(String person) {
    for (int i = 0; i < rooms.size(); i++) {
      if (rooms.get(i) != null) {
        if (rooms.get(i).getName().equals(person)) {
          rooms.set(i,null);
        }
      }
    }
  }

  //prints out all the current reservations to the screen
  //also should display the total number of reservations and vacancies
  /**
   *Printing reservations.
   */
  public void printReservations() {
    for (int i = 0; i < rooms.size(); i++) {
      if (rooms.get(i) != null) {
        System.out.println(rooms.get(i));  
      } else {
        System.out.println((i + 1) + " is not reserved");
      }
    }
  }
}