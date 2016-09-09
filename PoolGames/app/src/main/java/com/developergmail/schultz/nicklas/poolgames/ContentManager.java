package com.developergmail.schultz.nicklas.poolgames;

import android.app.Application;
import android.graphics.Color;

import com.developergmail.schultz.nicklas.poolgames.games.Cribbage;
import com.developergmail.schultz.nicklas.poolgames.games.Cutthroat;
import com.developergmail.schultz.nicklas.poolgames.games.Drinking;
import com.developergmail.schultz.nicklas.poolgames.games.EightBall;
import com.developergmail.schultz.nicklas.poolgames.games.IGame;
import com.developergmail.schultz.nicklas.poolgames.games.NineBall;
import com.developergmail.schultz.nicklas.poolgames.games.Snooker;
import com.developergmail.schultz.nicklas.poolgames.helpers.StringHelper;

import java.util.ArrayList;

/**
 * Created by nicklasschultz on 30/08/16.
 */
public class ContentManager extends Application {

    private ArrayList<IGame> games;

    public ArrayList<IGame> getGames() {
        if (this.games == null) {
            fetchGames();
        }
        return this.games;
    }

    public IGame getGameByName(String name) {
        IGame returnValue = null;
        for (IGame g : games) {
            if (g.getName().equals(name)) {
                returnValue = g;
                break;
            }
        }
        return returnValue;
    }

    private void fetchGames() {
        ArrayList<IGame> games = getDummyGames();
        this.games = games;
    }

    // TODO create strin resources for this
    private ArrayList<IGame> getDummyGames() {
        String[] playContent = new String[3];
        String[] playTitles = new String[3];
        String[] rackTitles = new String[1];
        String[] rackContent = new String[1];
        String[] winning = new String[1];
        String[] winningContent = new String[1];
        rackTitles[0] = "The rack";
        rackContent[0] = "Place the balls in a diamond formation. The first ball facing the player needs to be the number 1 ball. In the middle of the diamond formation the number 9 ball should be";
        playContent[0] = "One person is chosen to shoot first, by breaking the rack. The base of the cue ball must be behind the head string for the break shot. " +
                "If the player who breaks fails to make a legal break, the opponent can either demand a re-rack and become the breaker, or continue to play as if " +
                "it had been an ordinary foul, depending upon the rules of the event. If the breaker pockets a ball and commits no foul, it remains the breaker's turn " +
                "If the breaker pockets the 9 ball on the break (without fouling), this is an instant win.\n\n";
        playContent[1] = "The objective is to sink the 9-ball with a legal shot. A legal shot consists of striking the cue ball into the lowest numbered object ball on the table and subsequently " +
                "either pocketing an object ball, or driving any ball (including the cue ball) to any rail, otherwise the shot is a foul. " +
                "Object balls do not have to be pocketed in numerical order; Any ball may be pocketed at any time during the game, so long as the lowest-numbered ball is contacted first by the cue ball. " +
                "Players alternate innings at the table, meaning play continues by one player until he or she misses, commits a foul, or pockets the 9 ball for the win.\n\n";
        playContent[2] = "The penalty for a foul is that the player's " +
                "inning ends and the opponent comes to the table with ball in hand, able to place the cue ball anywhere on the table prior to shooting.";
        playTitles[0] = "The Break\n\n";
        playTitles[1] = "Play\n\n";
        playTitles[2] = "Foul\n\n";
        winning[0] = "Who wins?\n\n";
        winningContent[0] = "The person that pots the 9 ball legally wins. If a player fouls and pockets the 9 ball, or knocks the 9 ball off the table, the 9 ball is placed on the foot spot, and the incoming player receives ball-in-hand.";
        IGame nineBall = new NineBall("9-Ball", new Rule(
                StringHelper.getSpannableString("Game Setup\n\n", rackTitles, rackContent),
                StringHelper.getSpannableString("Game Play\n\n", playTitles, playContent),
                StringHelper.getSpannableString("Winning\n\n", winning, winningContent)
        ), R.drawable.nineball);

        playContent = new String[3];
        rackContent = new String[1];
        winningContent = new String[1];
        rackContent[0] = "Place the balls in a triangle formation, with a longside against the back wall of the table. The 8-ball should be placed in the middle, of the third row ";
        playContent[0] = "One person is chosen to shoot first, using the cue ball to break the object-ball rack apart. If the shooter who breaks fails to make a legal break, then the " +
                "opponent can call for a re-rack and become the breaker, or elect to play from the current position of the balls.\n\n";
        playContent[1] = "A player (or team) will continue to shoot until committing a foul, or failing to legally pocket an object ball on a non-foul shot (whether intentionally or not). " +
                "Thereupon it is the turn of the opposing player(s). Play alternates in this manner for the remainder of the game. Following a foul, the incoming player has ball-in-hand " +
                "anywhere on the table, unless the foul occurred on the break shot, as noted previously.\n\n";
        playContent[2] = "Selecting colors\nAt some point in the game, one of the players can select balls 1–7 (the \"solids\") or balls 9–15 (the \"stripes\") as their group of object balls by legally " +
                "pocketing a ball from one category. The other player is assigned to the other group. Balls pocketed on the break shot are not used to assign the target groups. Once the target " +
                "groups have been assigned, they remain fixed throughout the remainder of the game.\n\n" +
                "Pocketing the 8 ball\nOnce all of a player's or team's group of object balls are pocketed, they may attempt to sink the 8 ball. To win, the player (or team) must first designate which pocket " +
                "they plan to sink the 8 ball into and then successfully pot the 8 ball in that called pocket. If the 8 ball falls into any pocket other than the one designated or is knocked off the table, " +
                "or a foul (see below) occurs and the 8 ball is pocketed, this results in loss of game. ";

        winningContent[0] =  "Any of the following results in a game win:\n" +
                "A player legally pockets the 8 ball into a designated pocket, after all of that player's object balls have been pocketed\n\n" +
                "The opposing player illegally pockets the 8 ball (e.g. before clearing all of that player's object balls, does so on the same shot as the last such object ball, or the 8 falls into a pocket " +
                "other than the one that was designated)\n\n" +
                "The opposing player knocks the 8 ball off the table.\n\n" +
                "The opposing player commits any foul, including scratching the cue ball into a pocket, or knocking it off the table, in the course of a shot that pockets the 8 ball. (As noted above, a scratch or other " +
                "foul while shooting for the 8 ball is not a loss of the game if the 8 is not pocketed or jumped from the table.)";
        IGame eightBall = new EightBall("8-Ball", new Rule(
                StringHelper.getSpannableString("Game Setup\n\n", rackTitles, rackContent),
                StringHelper.getSpannableString("Game Play\n\n", playTitles, playContent),
                StringHelper.getSpannableString("Winning\n\n", winning, winningContent)
        ), R.drawable.rack_setup);




        rackContent = new String[] { "Place the balls in a triangle formation, with a longside against the back wall of the table. The 8-ball should be placed in the middle, of the third row " };
        playContent = new String[] {"A cribbage only counts when the paired balls are pocketed in succession in the same inning.\n\n" +
                "Where a player pockets a first paired ball and is thus on a cribbage, if the companion ball is not pocketed on the next stroke, " +
                "the shot is a foul and the unpaired balls of any cribbages not completed are spotted to the foot spot. If the foot spot is " +
                "occupied, balls are spotted as close as possible to the foot spot on the long string stretching back from the foot spot to the foot rail\n\n" +
                "The penalty for all fouls is the ending of the player's inning; no points are lost, and the incoming player has the option of shooting from position or " +
                "taking cue ball in hand from the kitchen (behind the table's head string). Pocketing the 15 ball when it is not the last ball on the table is not a foul. " +
                "Instead it is immediately spotted and play continues without penalty\n\n" +
                "When players pocket more than one ball on a single stroke at any time, they may shoot at any companion balls, but must pocket each in succession in any order. " +
                "If incidental balls are pocketed on the same stroke that a cribbage is completed, they add to the succession of cribbages the player is \"on\". " +
                "When a player fouls by failing to pocket an unpaired cribbage while on a succession of unpaired balls, only unpaired balls are spotted; the prior successful cribbages count toward the score\n\n" +
                "Normal ball and rail foul rules apply in cribbage. This is a requirement present in most pool games that a player must contact an object ball with the cue ball " +
                "and after that contact, either pocket an object ball, or some ball including the cue ball must contact a rail. When a foul results from scratching the cue ball into a pocket or jumping it off " +
                "the table, the player has cue ball in hand from the kitchen. When a player has cue ball in hand from the kitchen and all object balls are also behind the head string in the kitchen, " +
                "a player has the option of having the object ball nearest the head string relocated to the foot spot.\n\n"};
        winningContent = new String[] {"The first player to get 5 cribbages wins"};
        IGame pool = new Cribbage("Cribbage", new Rule(
                StringHelper.getSpannableString("Game Setup\n\n", rackTitles, rackContent),
                StringHelper.getSpannableString("Game Play\n\n", playTitles, playContent),
                StringHelper.getSpannableString("Winning\n\n", winning, winningContent)
        ), R.drawable.rack_setup);




        playContent = new String[] {"Cutthroat (or Elimination or Screw your neighbour, as it is also known) is a game for three players in which each player tries to win by pocketing the balls of the other two players. " +
                "The 15 balls are divided into three groups: one through five, six through ten, and 11 through 15. " +
                "Players can either choose a group of balls before the game starts, or be assigned a group as each begins pocketing balls. If you scratch "
                + ", one ball of both opponents is returned to the table, even if one of the opponents has had all his balls removed. Your turn continues as long as you pocket a ball. " +
                "You can even pocket your own ball in order to be able to keep shooting"};
        winningContent = new String[] {"The final player with balls left wins"};
        IGame cutthroat = new Cutthroat("Cutthroat", new Rule(
                StringHelper.getSpannableString("Game Setup\n\n", rackTitles, rackContent),
                StringHelper.getSpannableString("Game Play\n\n", playTitles, playContent),
                StringHelper.getSpannableString("Winning\n\n", winning, winningContent)
        ), R.drawable.rack_setup);




        playContent = new String[] {"Play a regular game of pool as you normally would with your friends. Each player must have their own drink. Just add these rules for drinking depending on what happens:\n" +
                "Teams chug for break. The team of the first person to finish gets to break.\n" +
                "If player makes a ball, both members of the opposing team take a drink.\n\n" +
                "If player misses a ball, his/her team drinks.\n\n" +
                "For each ball made in a row, the opposing team has to take that many drinks. So if you made your 2nd ball in a row, opposing team has to take 2 drinks. For your third ball in a row the opposing team takes 3 drinks, and so on.\n\n" +
                "If player commits any foul, opposing team is awarded Ball-In-Hand (they get to place the cue ball wherever they want) and your team has to take a drink.\n\n" +
                "Losing team must chug the rest of their drinks and refill the winning team.\n\n" +
                "Time out will be called for any player to refill his/her drink, however since you are a team your partner must also finish their drink so you can refill together."};
        rackContent = new String[] {"Place the balls in a triangle formation, with a longside against the back wall of the table. The 8-ball should be placed in the middle, of the third row "};
        winningContent = new String[] {"Alla är vinnare"};
        IGame drinking = new Drinking("Drinking", new Rule(
                StringHelper.getSpannableString("Game Setup\n\n", rackTitles, rackContent),
                StringHelper.getSpannableString("Game Play\n\n", playTitles, playContent),
                StringHelper.getSpannableString("Winning\n\n", winning, winningContent)
        ), R.drawable.beer);




        playContent = new String[] {"Sink redball then colored"};
        rackContent = new String[] {"setup the tablwe"};
        winningContent = new String[] {"The person with the most points win"};
        IGame snooker = new Snooker("Snooker", new Rule(
                StringHelper.getSpannableString("Game Setup\n\n", rackTitles, rackContent),
                StringHelper.getSpannableString("Game Play\n\n", playTitles, playContent),
                StringHelper.getSpannableString("Winning\n\n", winning, winningContent)
        ), R.drawable.snooker_reds);

        ArrayList<IGame> listOfGames = new ArrayList<>();
        listOfGames.add(nineBall);
        listOfGames.add(eightBall);
        listOfGames.add(pool);
        listOfGames.add(cutthroat);
        listOfGames.add(snooker);
        listOfGames.add(drinking);

        return listOfGames;
    }
}
