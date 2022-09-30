public class Passenger {
    private int destination;
    private String goal;
    private String name;

    public Passenger(int destination, String goal, String name){
        this.destination = destination;
        this.goal = goal;
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public int getDestination(){
        return destination;
    }

    public String getGoal(){
        return goal;
    }
}