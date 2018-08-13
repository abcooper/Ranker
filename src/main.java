import java.util.Scanner;

public class main {
    public static void main(String [ ] args) {

        //create parser and take csv as input
        PlayerList playerList = new PlayerList();
        Parser parser = new Parser(playerList);
        Scanner scan = new Scanner(System.in);
        String userInput = "1";
        while(!userInput.equalsIgnoreCase("q")){

            //todo print range
            System.out.println("1: Add a .csv \n2:Get list of all players \n3:Search for a player \n4:Search for a position on a team \n0: Quit");
            userInput = scan.nextLine();

            try{
                Integer.parseInt(userInput);
                switch (Integer.parseInt(userInput)){
                    case 1:
                        break;
                    case 2:
                        playerList.printPlayers();
                        break;
                    case 3:
                        System.out.println("Enter player name");
                        String name = scan.nextLine();
                        playerList.printPlayer(name);
                        break;
                    case 4:
                        System.out.println("Enter position");
                        userInput = scan.next();
                        System.out.println("Enter team");
                        String team = scan.next();
                        playerList.printPlayer(userInput, team);
                        break;
                }
            }
            catch(NumberFormatException ex){
                System.out.println("Wanrning: Enter an Integer");
            }





        }

        //parser creates players and adds them to playerlist
        //enter input loop where user controls

    }
}
