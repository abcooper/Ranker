import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Parser {

    public void parseData(String input, PlayerList playerList) {
//        File file = new File(input);

        String csv = "";
        String[] csvArray;
//        try (Scanner sc = new Scanner(file)) {
//            csv = sc.next();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        try {
            csv = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);
        }
        catch (IOException ex){
            System.out.println("IOException");
        }

        csvArray = csv.split(",");

        for (int a = 0; a < csvArray.length - 6 ; a+= 6){
            //try and find player
                //if yes add to existing player
            //if not create new player
            Player player = playerList.getPlayer(Arrays.copyOfRange(csvArray, a, a+3));
            if(player != null){
                player.addStat(Arrays.copyOfRange(csvArray, a+3, a+6));
            }
            else{
                player = new Player(Arrays.copyOfRange(csvArray, a, a+3));
                player.addStat(Arrays.copyOfRange(csvArray, a+3, a+6));
                playerList.addPlayer(player);
            }
        }

    }


}
