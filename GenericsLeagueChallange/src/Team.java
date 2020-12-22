import java.util.ArrayList;

public class Team <T extends Player> implements Comparable<Team<T>> {       // Creating a Team class with a type parameter
                                                                            // so it can include only the right type of players.
    private String name;                                                    // Adding functionality so a simulation of a league can be implemented.
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    private ArrayList<T> members = new ArrayList<>();
    private int gD =0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGD() {
        return gD;
    }

    public int getPlayed() {
        return played;
    }

    public boolean addPlayer (T player) {
        if (this.members.contains(player)) {
            System.out.println("This player is already added to the team");
            return false;
        }
        System.out.println("Player " +  player.getName() + " added to " + this.name + " team.");
        this.members.add(player);
        return true;
    }

    public int numPlayers () {
        return this.members.size();
    }

    public void matchResult (Team<T> opponent, int ourScore, int theirScore) {              // A method which takes the match between two teams
        String message;                                                                     // of the same type and updates their fields according to the result.
        this.played++;
        this.gD += ourScore - theirScore;
        if (ourScore > theirScore) {
            this.won++;
            message = " beat ";
        } else if (theirScore > ourScore) {
            this.lost++;
            message = " lost to ";
        } else {
            this.tied++;
            message = " tied with ";
        }

        if (opponent != null) {
            System.out.println(this.name + message + opponent.getName() + "\t" + ourScore + ":" + theirScore);
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking () {                                     // A ranking method that defines the point system for the teams.
        return (won * 3) + tied;                                // In this example the ranking and compareTo method are optimized for
    }                                                           // a soccer team and league.

    public void printPlayers () {
        System.out.println("------------------------");
        System.out.println(this.name);
        System.out.println("------------------------");
        for (int i=0; i<this.members.size(); i++) {
            System.out.println((i+1) + ". " + this.members.get(i).getName());
        }
        System.out.println("------------------------");
    }

    @Override
    public int compareTo(Team<T> team) {                            // An overridden compareTo method, so we can use "Collections.sort" method.
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
          if (this.gD > team.gD) {
              return -1;
          } else if (this.gD < team.gD) {
              return 1;
            }
          else {
              return 0;
          }
        }
    }
}
