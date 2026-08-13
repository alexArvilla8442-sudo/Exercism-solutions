public class FootballMatchReports {    

    public static void main(String[] args) {
        onField(1);
        onField(2);
        onField(5);
        onField(3);
        onField(4);
        onField(6);
        onField(7);
        onField(8);
        onField(9);
        onField(10);
        onField(11);

        onField(13);
        onField(-1);

    }

    public static String onField(int shirtNum) {
        //if(shirtNum >= 1 && shirtNum <= 11) {
            String shirtNumDescription = switch(shirtNum){
                case 1 -> "goalie";
                case 2 -> "left back";
                case 3, 4 -> "center back";
                case 5 -> "right back";
                case 6, 7, 8 -> "midfielder";
                case 9 -> "left wing";
                case 10 -> "striker";
                case 11 -> "right wing";
                default -> "invalid";
            };

            return shirtNumDescription;
        /*}else{
            return "Invalid shirt number";
        }*/
    }
}

/*
    * The player descriptions are as follows:

1 -> "goalie"
2 -> "left back"
3 & 4 "center back"
5 -> "right back"
6, 7, & 8 -> "midfielder"
9 -> "left wing"
10 -> "striker"
11 -> "right wing"
Implement the static FootballMatchReports.onField() method to output a player description based on their shirt number.

FootballMatchReports.onField(10);
// => "striker"
*
*
* Modify the FootballMatchReports.onField() method to return 'invalid' when a shirt number outside the range 1-11 is processed.

            FootballMatchReports.onField(13);
// => "invalid"
    * */
