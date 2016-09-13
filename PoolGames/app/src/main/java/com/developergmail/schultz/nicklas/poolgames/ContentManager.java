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
        rackTitles[0] = "The rack\n\n";
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



        playTitles[0] = "Rules of Play\n\n";
        playTitles[1] = "Special cases\n\n";
        playTitles[2] = "Foul\n\n";
        winning[0] = "Scoring\n\n";

        playContent = new String[] {"The objective is to score more points than your opponent by sinking the object balls in the correct order. \n\n1. A legally potted ball entitles the striker to continue at the table until he fails to legally pot a ball." +
                "2. It is not necessary to cause the cue ball or an object ball to contact a cushion or drop in a pocket after the cue ball has contacted a legal object ball (ball on). Failure to contact a legal object ball first is a foul.\n\n" +
                "3. As long as reds are on the table, the incoming striker (player taking his first stroke of an inning) always has a red as his legal object ball (ball on).\n\n" +
                "4. Any red balls potted on a legal shot are legally potted balls; the striker need not call any particular red ball(s), pocket(s) or details of how the pot will be played.\n\n" +
                "5. When the striker has a red ball as his \"ball on\" (legal object ball), he must cause the cue ball's first contact to be with a red ball. Failure to do so is a foul\n\n" +
                "6. After the striker has scored a red ball initially, his next legal object is a color, and as long as reds remain on the table he must alternate his play between reds and colors (though within each group he may play a ball of his choice). When reds remain on the table and a color is his object, the striker must (a) designate prior to stroking which color ball is his object (that specific color is then his \"ball on\"), and (b) cause the cue ball's first contact with a ball to be with that colored ball. If the striker fails to meet these requirements, it is a foul\n\n" +
                "7. If the striker's ball on is a red, and he pots a color, it is a foul.\n\n" +
                "8. If the striker's ball on is a color, and he pots any other ball, it is a foul.\n\n" +
                "9. Jump shots are illegal in International Snooker. It is a foul if the striker intentionally causes the cue ball to jump (rise from the bed of the table) by any means, if the jump is an effort to clear an obstructing ball.\n\n" +
                "10. While reds remain on the table, each potted color is spotted prior to the next stroke (see Spotting Balls below for spotting rules).\n\n" +
                "11. When no reds remain on the table, striker's balls on become the colors, in ascending numerical order (2,3,4,5,6,7). These legally potted colors are not spotted after each is potted; they remain off the table\n\n"

                , "Illegally Potted Ball: Reds illegally potted are not spotted; they remain off the table. Colors illegally potted are spotted. (See Spotting Balls.)\n\n" +
                "Object Balls Jumped off the Table: Reds jumped off the table are not spotted and the striker has committed a foul. Colors jumped off the table are spotted and the striker has committed a foul.\n\n" +
                "Spotting Balls: Reds are never spotted. Colors to be spotted are placed as at the start of the game. If a color's spot is occupied (to mean that to spot it would make it touch a ball), it is placed on the spot of the highest value color that is unoccupied. If all spots are occupied, the color is spotted as close as possible to its original spot on a straight line between its spot and the nearest point on the top (foot) cushion.\n\n" +
                "Cue Ball after Jumping off the Table: Incoming player has cue ball in hand within the Half Circle. When cue ball is in hand within the Half Circle (except the opening break), there is no restriction (based on position of reds or colors) as to what balls may be played; striker may play at any ball on regardless of where it is on the table.\n\n" +
                "Touching a Ball: While balls are in play it is a foul if the striker touches any object ball or if the striker touches the cue ball with anything other than the tip during a legal stroke.\n\n" +
                "Snookered: The cue ball is snookered when a direct stroke in a straight line to any part of every ball on is obstructed by a ball or balls not on. If there is any one ball that is not so obstructed, the cue ball is not snookered. If in-hand within the Half Circle, the cue ball is snookered only if obstructed from all positions on or within the Half Circle. If the cue ball is obstructed by more than one ball, the one nearest to the cue ball is the effective snookering ball.\n\n" +
                "Angled: The cue ball is angled when a direct stroke in a straight line to any part of every ball on is obstructed by a corner of the cushion. If there is any one ball on that is not so obstructed, the cue ball is not angled. If angled after a foul the referee or player will state \"Angled Ball\", and the striker has the choice to either (1) play from that position or (2) play from in hand within the Half Circle.\n\n" +
                "Occupied: A spot is said to be occupied if a ball cannot be placed on it without its touching another ball.\n\n" +
                "Touching Ball: If the cue ball is touching another ball which is, or can be, on, the referee or player shall state \"Touching Ball.\" Thereafter the striker must play away from it or it is a push stroke (foul). No penalty is incurred for thus playing away if (1) the ball is not on; the ball is on and the striker nominates such ball; or (3) the ball is on and the striker nominates, and first hits, another ball. [If the referee considers that a touching ball has moved through an agency other than the player, it is not a foul.]\n\n" +
                "Push Stroke: A push stroke is a foul and is made when the tip of the cue remains in contact with the cue ball (1) when the cue ball makes contact with the object ball, or (2) after the cue ball has commenced its forward motion. Provided that where the cue ball and an object ball are almost touching, it shall be deemed a legal stroke if the cue ball hits the finest possible edge of the object ball.\n\n" +
                "Miss: The striker shall to the best of his ability endeavor to hit the ball on. If the referee considers the rule infringed he shall call foul and a \"miss.\" The incoming player (1) may play the ball(s) as they lie, or (2) may request that the ball(s) be returned to the original position and have the offending player play the stroke again. Note: if the ball on cannot possibly be hit, the striker is judged to be attempting to hit the ball on.\n\n" +
                "Free Ball: After a foul, if the cue ball is snookered, the referee or player shall state \"Free Ball.\" If the non-offending layer takes the next stroke he may nominate any ball as on. For this stroke, such ball shall be regarded as, and acquire the value of, the ball on. It is a foul should the cue ball fail to first hit, or - except when only the pink and black remain on the table - be snookered by, the free ball. If the \"free ball\" is potted, is is spotted, and the value of the ball on is scored. if the ball on is potted it is scored. If both the \"free ball\" and the ball on are potted, only the value of the ball on is scored.\n\n",

                "The following are fouls and incur a penalty of four points or the higher one prescribed:\n" +
                        "1. value of the ball on -\n" +
                        "\n" +
                        "by striking: \na) when the balls are still moving from the previous shot. \nb) the cue ball more than once (double hit). \nc) without at least one foot on the floor.\n d) out of turn. \ne) improperly from in hand within the Half Circle.\n\n" +
                        "by causing:\n" +
                        "\n" +
                        "f) the cue ball to miss all object balls. \ng) the cue ball to enter a pocket. \nh) a snooker with free ball. \ni) a jump shot.\n\n" +
                        "2. value of the ball on or ball concerned -\n" +
                        "\n" +
                        "by causing:\n" +
                        "\n" +
                        "a) a ball not on to enter a pocket. \nb) the cue ball to first hit a ball not on. \nc) a push stroke. \nd) by striking with a ball not correctly spotted. \ne) by touching a ball with other than the tip of the cue. \nf) by forcing a ball off the table.\n\n" +
                        "3. value of the ball on or higher value of the two balls by causing the cue ball to hit simultaneously two balls other than two reds or a \"free ball\" and the ball on.\n\n" +
                        "4. penalty of seven points is incurred if -\n" +
                        "\n" +
                        "the striker\n" +
                        "\n" +
                        "a) after potting a red commits a foul before nominating a color.\n" +
                        "\n" +
                        "b) uses a ball off the table for any purpose.\n" +
                        "\n" +
                        "c) plays at reds in successive strokes.\n" +
                        "\n" +
                        "d) uses as the cue ball any ball other than the white one."};
        rackContent = new String[] {"Play begins with the balls placed as in the diagram above. The pink is spotted on the Pyramid Spot. The apex ball of the triangle of reds is racked as close as possible to the pink without touching it."};
        winningContent = new String[] {"Points are scored in two ways: players are awarded points for fouls by the opponent, and by legally potting reds or colors.\n\nPoint values for object balls: red-1, yellow-2, green-3, brown-4, blue-5, pink-6, black-7."};
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
