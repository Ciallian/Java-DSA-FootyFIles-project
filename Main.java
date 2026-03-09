public class Main {
    record SoccerPlayer(int age, double rating, String name, String nationalTeam, String club, String position, double value, double wage) {}

    public static void main(String[] args) {
        SoccerPlayer player1 = new SoccerPlayer(12, 8.7, "Rory", "Zimbabwe", "Shamrock Rover's", "BAck", 10, 0.02);
       
        System.out.println(player1.age);
        System.out.println(player1.rating);
        System.out.println(player1.name);
        System.out.println(player1.nationalTeam);
        System.out.println(player1.club);
        System.out.println(player1.position);
        System.out.println(player1.value);
        System.out.println(player1.wage);
    }

}
