import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class League<T extends Team> {                           // Creating a League class with a type parameter
                                                                // so it can include only the right type of teams.

    private String name;
    private ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public ArrayList<T> getTeams() {
        return teams;
    }

    public boolean addTeam (T team) {
        if (this.teams.contains(team)) {
            System.out.println("This team is already added to the league");
            return false;
        }
        System.out.println("Team " +  team.getName() + " added to " + this.name);
        this.teams.add(team);
        return true;
    }

    public void randomMatches () {                                  // Simulation of matches between all the teams in the league.
        boolean changeHome = false;                                 // Each team faces all of the other teams twice.
        Random random = new Random();                               // The result is pseudo-random with a small advantage to the home team.
        for (int k=0; k<2; k++) {                                   // The results provided try to simulate a soccer game. The goal is
            for (int i=0; i<this.teams.size()-1; i++) {             // to test the functionality. In a general case each sport should have appropriate score.
                for (int j = (i + 1); j < this.teams.size(); j++) {
                    int home = (changeHome) ? random.nextInt(5) : random.nextInt(6);
                    int guest = (changeHome) ? random.nextInt(6) : random.nextInt(5);
                    this.teams.get(i).matchResult(this.teams.get(j), home, guest);
                }
            }
            changeHome = true;
        }
    }

    public void printLeagueTable () {                                                       // Sorting the final league standings and printing them in a
        Collections.sort(teams);                                                            // orderly fashion. The used ranking is for soccer, hence
        System.out.println("=================================================");            // the displayed parameters are suitable mainly for this type of sport.
        System.out.println(this.name + " League table:");
        System.out.println("=================================================");
        System.out.println(String.format("%-20s %s     %s", "Team", "Goal difference", "Points"));
        System.out.println("-------------------------------------------------");
        for (int i=0; i<teams.size(); i++) {
            System.out.println(String.format("%-25s %-15s %s", ((i+1) + ". " + teams.get(i).getName()), String.format("%+d", teams.get(i).getGD()),  teams.get(i).ranking()));
        }
        System.out.println("=================================================");
    }
}
