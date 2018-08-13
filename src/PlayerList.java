import javax.sound.midi.SysexMessage;
import java.util.ArrayList;

public class PlayerList {
    private ArrayList<Player> playerList;

    public PlayerList(){
        playerList = new ArrayList<Player>();
    }

    public Player getPlayer(String[] data){
        for(Player player : playerList){

            //ToDo find a more flexible way to compare names
            if(player.getName().equalsIgnoreCase(data[0])){
                return player;
            }
        }
        return null;
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public void printPlayers(){
        //todo add different ways to view
        if(playerList.size() == 0){
            System.out.println("No players have been added.");
        }
        System.out.println("Name: \t\t\tPosition: \t\t\tTeam:");
        for(Player player: playerList){
            System.out.println(player.getName() + "\t\t\t" +player.getPosition() + "\t\t\t" + player.getTeam());
        }
    }

    public void printPlayer(String name){
        boolean found = false;
        for(Player player : playerList){
            if(player.getName().contains(name)){
                System.out.println("Rank: \t\tName: \t\t\tPosition: \t\t\tTeam:");
                System.out.println(player.getName() + "\t\t\t" +player.getPosition() + "\t\t\t" + player.getTeam());
                return;
            }
        }

        System.out.println("No players were found.");
    }

    public void printPlayer(String position, String team){
        boolean found = false;
        for(Player player : playerList){
            if(player.getPosition().equalsIgnoreCase(position) && player.getTeam().equalsIgnoreCase(team)){
                if(!found) {
                    System.out.println("Rank: \t\tName: \t\t\tPosition: \t\t\tTeam:");
                }
                found = true;
                System.out.println(player.getName() + "\t\t\t" +player.getPosition() + "\t\t\t" + player.getTeam());
            }
        }

        if(!found){
            System.out.println("No players were found.");
        }
    }
}
