import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import java.util.HashMap;
import java.util.Map;

public class Player {
    //fields
    //name, position, team, Map string statType: Map string site : stat
    //Average ranking, high, low, same for adp

    //methods
    //calc data

    String name, position, team;
    Map<String,Map<String,Double>> stats;
    boolean picked = false;

    public Player(String[] playerStats){
        name = playerStats[0];
        position = playerStats[1];
        team = playerStats[2];

        for(int a = 0; a < playerStats.length; a+=2){
            
        }

        stats.put("rank",new HashMap<String, Double>());
        stats.put("ADP",new HashMap<String, Double>());

    }

    public void calcAll(){
        this.stats.forEach((k,m) -> calcOneStat(m));
    }

    public void calcOneStat(Map<String, Double> stat){
        SummaryStatistics statsObj = new SummaryStatistics();
        stat.forEach((s,n) -> statsObj.addValue(n));

        stat.put("avg", statsObj.getMean());
        stat.put("low", statsObj.getMin());
        stat.put("high", statsObj.getMax());
        stat.put("std", statsObj.getStandardDeviation());

    }

    public String getName(){
        return name;
    }
    public String getPosition(){
        return position;
    }
    public String getTeam(){
        return team;
    }
}
