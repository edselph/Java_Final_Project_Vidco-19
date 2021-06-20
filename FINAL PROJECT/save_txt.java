import java.io.FileWriter;
import java.io.IOException;

public class save_txt extends fileText implements InnerfileText{

    public void saveArray(){
        //save users into file
        try
        {
            FileWriter savingInput = new FileWriter("data.txt");
            for(int i = 0; i < users.size(); i++){
                savingInput.write(users.get(i).toString());
            }
            savingInput.close();
        }
        catch (IOException e)
        {
            System.err.println("Error!!!");
            e.printStackTrace();
        }
    }

    @Override
    public  void printMessage(){
        System.out.println("File succesfully saved!");
    }
}
