import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import java.util.Map;

public class Player {
    //fields
    //name, position, team, Map string statType: Map string site : stat
    //Average ranking, high, low, same for adp

    //methods
    //calc data

    String name, position, team;
    Map<String,Map<String,Double>> stats;

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
}
