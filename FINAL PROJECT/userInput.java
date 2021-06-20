public class userInput { //make things form user to object, so it can be safe.
  String id_name;
  int id_age;
  boolean legible;

  public userInput(String n, int m, boolean k){ //this is constructor
    id_name = n;
    id_age = m;
    legible = k;
  }

  public String toString(){
    //converts the class object into the string format: "user, age, legible"
    String tempString = id_name + "," + Integer.toString(id_age) + ",";
    tempString = (legible) ? tempString + "legible": tempString + "illegible";
    return tempString + "\n";
  }
}
