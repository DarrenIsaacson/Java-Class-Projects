package PoolsPract;

public class Main {

    public static void main(String[] args) {
        Pools como = new Pools("Como Park", 25);
        Pools ymca = new Pools("YMCA Downtown", 20);
        Pools edina = new Pools ("Edina", 50);


        double totalDistance = edina.distanceForLaps(5);
        System.out.println(totalDistance);


        System.out.println(edina);
    }
}
