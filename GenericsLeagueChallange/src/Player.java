public abstract class Player {              // Creating an abstract class Player from which different
                                            // types of players will extend.
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }
}
