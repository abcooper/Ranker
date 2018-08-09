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

}
