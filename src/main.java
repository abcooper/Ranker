import java.util.Scanner;

public class main {
    public static void main(String [ ] args) {

        //create parser and take csv as input
        PlayerList playerList = new PlayerList();
        Parser parser = new Parser();
        Scanner scan = new Scanner(System.in);
        String userInput = "1";
        while(!userInput.equalsIgnoreCase("q")){

            System.out.println("1: Add a .csv \n2:Get list of all players \n3:Search for a player \n0: Quit");
            userInput = scan.next();

            switch (Integer.parseInt(userInput)){
                case 1:
                    System.out.println("What is the file location of the csv?");
                    userInput = scan.next();
                    parser.parseData(userInput, playerList);
                    break;
                case 2:
                    playerList.printPlayers();
                    break;

            }




        }

        //parser creates players and adds them to playerlist
        //enter input loop where user controls

    }
}
