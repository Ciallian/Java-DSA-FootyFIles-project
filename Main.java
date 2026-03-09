public class Main {
    record SoccerPlayer(int age, double overall, double potential, String name, String nationalTeam, String club, String position, long value, long wage, int contractStart, int contractEnd) {}

    public static void main(String[] args) {
        SoccerPlayer player1 = new SoccerPlayer(12, 8.7, 7.0, "Rory", "Zimbabwe", "Shamrock Rover's", "BAck", 10, 2, 02, 11);
    }

}
