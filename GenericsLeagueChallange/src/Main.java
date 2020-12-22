public class Main {

    public static void main(String[] args) {
        BaseballPlayer rick = new BaseballPlayer("Rick");                       // Creating a few players to test functionality.
        SoccerPlayer david = new SoccerPlayer("David");
        SoccerPlayer steven = new SoccerPlayer("Steven");

        Team <BaseballPlayer> redSox = new Team<>("Boston Red Sox");            // Teams are defined with type parameter so they
        redSox.addPlayer(rick);                                                        // will accept only the right type of players.

        Team <SoccerPlayer> liverpool = new Team<>("Liverpool");                // Creating a few teams to form a League
        liverpool.addPlayer(david);                                                    // and test functionality.
        liverpool.addPlayer(steven);
        liverpool.printPlayers();
        Team <SoccerPlayer> arsenal = new Team<>("Arsenal");
        Team <SoccerPlayer> manUtd = new Team<>("Manchester United");
        Team <SoccerPlayer> everton = new Team<>("Everton");

        League <Team<SoccerPlayer>> premiership = new League<>("Premiership");  // Creating the league.
        premiership.addTeam(arsenal);
        premiership.addTeam(liverpool);
        premiership.addTeam(manUtd);
        premiership.addTeam(everton);

        premiership.randomMatches();                                                    // Simulation of two matches between each team.

        premiership.printLeagueTable();                                                 // Printing the final standings of the league.

    }
}
