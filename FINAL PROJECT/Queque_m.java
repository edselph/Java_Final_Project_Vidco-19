import java.util.Scanner;

public class Queque_m{
  public static void main(String[] args) {
    //variables
    Scanner input = new Scanner(System.in);
    boolean quit = false;
    read_txt readFile = new read_txt();
    save_txt saveFile = new save_txt();
    userInput user; //this is object

    //load from data.txt
    readFile.read();

    //start the menu
    while(!quit){
      int choice = Options(input);
      switch (choice) {
        case 1:// for option 1
          user = Option_1(input);
          if(user.id_age > 65){
            readFile.users.add(readFile.oldCount, user);
          } else {
            readFile.users.add(user);
          }
          break;
        case 2:
          Option_2(readFile);
          break;
        case 3:
          readFile = Option_3(input, readFile);
          break;
        case 4: // close the menu and also save
          System.out.println("Thankyou for using Vidco-19 vaccine queue");
          saveFile.users = readFile.users;
          saveFile.saveArray();
          quit = true;
          break;
        default:
          System.out.println("Yo put the correct option, me mad >:( ");
          break;
      }
    }
    input.close();
  }

  public static int Options(Scanner input)
  {
    System.out.println("Wellcome to Vidco-91 Vaccine line");
    System.out.println("-------------------------");
    System.out.println("Please choose this options");
    System.out.println("-------------------------");
    System.out.println("1 - Enter an user");
    System.out.println("2 - Open an existing user");
    System.out.println("3 - Delete existing user");
    System.out.println("4 - Quit/Exit");
    System.out.println("-------------------------");
    int choice = input.nextInt();
    return choice;
  }

  public static userInput Option_1(Scanner input)
  {
    System.out.println("\n-------------------------\n");
    System.out.println("You have chosen option 1");
    System.out.println("-------------------------\n");
    System.out.print("Please enter your name: \n");
    String name = input.next(); //input
    System.out.println("Please input your age: ");
    int age = input.nextInt(); //input
    System.out.println("\nWelcome user: "+ name + "," + age);
    System.out.println("");
    System.out.println("Dear "+name +" , "+ age);
    System.out.println("Have you contracted with Vidco-19?(yes/no)");
    String answer = input.next();
    boolean legible = (answer.equals("no") && age>18) ? true : false; // if statement to check the user awnser yes or no
    String legibleMessage = (legible) ? "\nyou are legible to take the vaccine :) \n": "\nyou cannot take the vaccine unfortunately";
    System.out.println(legibleMessage);
    userInput newUser = new userInput(name, age, legible);
    return newUser;
  }

  public static void Option_2(read_txt dataFile){// read the data arraylist of every thing inside the data
    System.out.println("Name    Age    Legibility    Queue Number");
    for(userInput user: dataFile.users){// print the data queue and add number queue for easy read 
      String legible = (user.legible) ? "legible" : "illegible";
      int queueNumber = dataFile.users.indexOf(user) + 1;
      System.out.println(user.id_name + "    " + user.id_age + "    " + legible + "          " + queueNumber);
    }
  }

  public static read_txt Option_3(Scanner input, read_txt dataFile)//delete the data you want
  {
    System.out.println("\n-------------------------\n");
    System.out.println("You have chosen option 3");
    System.out.println("-------------------------\n");
    System.out.print("Please enter the name: \n");
    String name = input.next(); //input
    System.out.println("Please input their age: ");
    int age = input.nextInt(); //input
    for(int i = 0; i < dataFile.users.size(); i++){// for searching each stuff inside the arraylist
      if(dataFile.users.get(i).id_name.equals(name) && dataFile.users.get(i).id_age == age){
        System.out.println(name + " deleted!");
        dataFile.users.remove(i);
        break;
      }
    }
    return dataFile;
  }
}
