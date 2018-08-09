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
    Map<String,Map<String,Double>> statsMap;
    boolean picked = false;

    public Player(String[] playerStats){
        name = playerStats[0];
        position = playerStats[1];
        team = playerStats[2];
        statsMap = new HashMap<String,Map<String,Double>>();
        statsMap.put("rank",new HashMap<String, Double>());
        statsMap.put("adp",new HashMap<String, Double>());

    }

    public void addStat(String[] stats){
        switch(stats[0].toLowerCase()){
            case "rank":
                statsMap.get("rank").put(stats[1], Double.parseDouble(stats[2]));
                break;
            case "adp":
                statsMap.get("adp").put(stats[1], Double.parseDouble(stats[2]));
                break;
            default:
                return;
        }
    }

    public void calcAll(){
        this.statsMap.forEach((k,m) -> calcOneStat(m));
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
