import java.io.File;
import java.util.Scanner;

public class Parser {

    public PlayerList parseData(String input){
        String fileLocation = input;
        Scanner sc = new Scanner(fileLocation);
        String csv = sc.next();
        PlayerList pl = new PlayerList();
        String[] csvArray = csv.split(",");

        for (int a = 0; a < (csvArray.length / 9); a++){
            Player player = new Player();
        }

        return pl;
    }


}
