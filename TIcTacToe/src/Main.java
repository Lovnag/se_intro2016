import java.util.Scanner;

/**
 * Created by Lovnag on 19.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        RunningTheGame playing = new RunningTheGame();
        System.out.println("Greetings, dear Gamemaster. Please, choose whether you want to create a default game(in which case type '0'), or if you want to see a win rate of two AIs against each other(in which case type how many games do you want them to play)");
        Scanner in = new Scanner(System.in);
        int numbOfGames = in.nextInt();
        if (numbOfGames == 0) {
            playing.run();
        } else {
            System.out.println(playing.theArtificialIdiots(numbOfGames));
        }
    }

}
