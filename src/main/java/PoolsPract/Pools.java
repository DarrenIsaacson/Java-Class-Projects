package PoolsPract;

public class Pools {

    private String name;
    private double length;
    private boolean isInside;

    Pools(String name, double length){
        this.name = name;
        this.length = length;

    }

    public double distanceForLaps(int laps){
        return laps * length;
    }

    //public boolean defineArea ()

    @Override
    public String toString(){
        return name + " pool is " + length + " meters long.";
    }

}


