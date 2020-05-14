import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CandidateCode {
/*

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            List<Player> playerList = new ArrayList<>();
            while ((line = br.readLine())!=null) {
                String[] input = line.split("\\s+");
                Player player = new Player(input[0], Integer.parseInt(input[1]), input[2]);
                playerList.add(player);
            }
            System.out.println(new GroupPlayers().groupPlayers(playerList));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

class Player {

    String skill;
    int points;
    String town;

    Player(String skill, int points, String town) {
        this.skill = skill;
        this.points = points;
        this.town = town;
    }

}

class GroupPlayers {

    int batsman_min = 3;
    int batsman_max=6;
    int bowler_min=3;
    int bowler_max=6;
    int wk_min=1;
    int wk_max=4;
    int allrounder_min=1;
    int allrounder_max=4;
    int town_max=7;
    int skill_max=100;

    int batsman=0;
    int bowler=0;
    int wk=0;
    int allrounder =0;
    int ipswich = 0;
    int suffolk = 0;
    int points = 0;

    public  int groupPlayers(List<Player> playerList) {
        int combination=0;
        for(int i = 0; i < playerList.size()-11; i++) {
            int playerCount = 0;
            batsman=0;
            bowler=0;
            wk=0;
            allrounder =0;
            ipswich = 0;
            suffolk = 0;
            points = 0;
            for (int j = i; j<playerList.size(); j++) {
                if(addPlayer(playerList.get(j))) {
                    ++playerCount;
                }
                if(playerCount == 11) {
                    ++combination;
                    break;
                }
            }
        }
        return combination;
    }

    public boolean addPlayer(Player player) {

        HashMap
        if(validatePlayerScore(player) && validatePlayerCity(player)) {
            System.out.println(player.skill);;
            if (("Batsman").equals(player.skill.trim()) && batsman < batsman_max) {
                ++batsman;
                addCityAndScore(player);
                System.out.println("batsman");
                return true;
            } else if (("Bowler").equals(player.skill.trim()) && bowler < bowler_max) {
                ++bowler;
                addCityAndScore(player);
                System.out.println("bowler");
                return true;
            } else if (("WicketKeeper").equals(player.skill.trim()) && wk < wk_max) {
                ++wk;
                addCityAndScore(player);
                System.out.println("wk");
                return true;
            } else if (("AllRounder").equals(player.skill.trim()) && allrounder < allrounder_max) {
                ++allrounder;
                addCityAndScore(player);
                System.out.println("ar");
                return true;
            }
        }
        return false;
    }


    public void addCityAndScore(Player player) {
        if(player.town.trim().equals("Ipswich"))
            ++ipswich;
        else
            ++suffolk;
        points+=player.points;
    }

    public boolean validatePlayerCity(Player player) {
        return ((ipswich <town_max && player.town.trim().equals("Ipswich")) || (suffolk <town_max && player.town.trim().equals("Suffolk")));
    }

    public boolean validatePlayerScore(Player player) {
        return player.points + points <= skill_max;
    }
*/

}