import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class read_txt extends fileText implements InnerfileText{
    int oldCount = 0;

    public void read(){
        try {
            File file = new File("data.txt"); //name of file here
            Scanner sc = new Scanner(file); //file is a File object above
            while(sc.hasNextLine()){
                String[] data = sc.nextLine().split(",", 3); //split the string into 3 and add ','
                //data[0] is the name, data[1] is the age, data[2] is if they're legible
                users.add(new userInput(data[0], Integer.parseInt(data[1]), (data[2].equals("legible")) ? true : false));
                if(Integer.parseInt(data[1]) > 65){
                    oldCount++;
                }
            }
            sc.close();
        } catch (FileNotFoundException e){// this the else
            System.out.println("Error: File not found");
            e.printStackTrace();
        }
    }

    @Override
    public void printMessage(){//polymorphism form fileText
        System.out.println("File succesfully loaded!");
    }
}
