/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, February 22th, 2017
 *  Description: Create an object-oriented programming solution to play 
 *  the ever-popular game of Paper, Rock, Scissors, Lizard, Spock 
 *  using the following rules: two players simultaneously choose 
 *  either rock, paper, or scissors.  The winner is determined by, 
 *  Scissors cuts paper, and paper covers rock, rock breaks scissors.
 *  If both players select the same option, it is a tie.
 *  The game will consist of one player who plays against the computer.
 *  The game has a winner (player, computer, or a tie) based on 
 *  one of the following outcomes:
 *  1.	Rock breaks Scissors
 *  2.	Paper covers Rock
 *  3.	Scissors cuts Paper
 *  4.	Lizard poisonsSpock
 *  5.	Spock vaporizes Rock
 *  6.	Paper disproves Spock
 *  7.	Scissors capitates Lizard
 *  8.	Spock smashes scissors
 *  9.	Lizard eats Paper
 *  10.	Rock pulverizes Lizard
 *  11.	Draw (both players selected same option)
 *  
 *  A count is maintained for the number of games played as well as 
 *  the number of wins, ties, and losses (computer wins). The user 
 *  can play as many games as they like; when finished playing, 
 *  statistics are provided that include the player's number of wins, 
 *  games played, and their winning percentage.  After the player is 
 *  finished, the program should accommodate a new player if there is 
 *  one who wants to play.
 */

package Project2RPSLSpock;

/**
 * DRIVE FILR
 * Profesor: A. Wright
 * Programmer: Quang Bui
 */
public class Project2RPSLSpock {

    public static void main(String[] args) {
        RPSLSpockGame gameOn = new RPSLSpockGame();
        gameOn.playGame();
    }
}

/*
run:
Welcome to the game of Paper, Rock, Scissors, Lizard, Spock. 
The first time, you need to enter your name. 
After you enter your name, there is one person (computer) will play it with you. 
You will choose randomly from 1 to 5 corresponding the Paper, Rock, Scissors, Lizard, Spock respectively. 
The computer will randomly pick up one of the following: Paper, Rock, Scissors, Lizard, Spock. 
The winner is determined by, Scissors cuts paper, and paper covers rock, rock breaks scissors. 
If you and computer select the same option, it is a tie.
The game has a winner based on one of the following outcomes:

--------------------------------------------
1. Rock breaks Scissors.
2. Paper covers Rock.
3. Scissors cuts Paper.
4. Lizard poisons Spock.
5. Spock vaporizes Rock.
6. Paper disproves Spock.
7. Scissors capitates Lizard.
8. Spock smashes scissors.
9. Lizard eats Paper.
10. Rock pulverizes Lizard.
11. Draw (both players selected same option)
--------------------------------------------
Good luck.
 Please enter your name > Quang Bui
 Select one from the following:
 1. paper
 2. rock
 3. scissors
 4. lizard
 5. Spock
 -------------------> 4
 Player: Quang Bui chose lizard	 The Computer chose paper
Compare two choices: 
lizard EATS paper
Do you want to play again? (y/n): y
 Select one from the following:
 1. paper
 2. rock
 3. scissors
 4. lizard
 5. Spock
 -------------------> 2
 Player: Quang Bui chose rock	 The Computer chose rock
Compare two choices: 
Do you want to play again? (y/n): n
You finished the game.
This is Quang Bui's statistics 
Number of wins: 1
Number of losses: 0
Number of ties: 1
The number of game played is: 2
The winning percentage is: 50%
 Congratulations Quang Bui. You WON!


Computer wants to invite a new player, do you agree? (y/n): y
Welcome to the game of Paper, Rock, Scissors, Lizard, Spock. 
The first time, you need to enter your name. 
After you enter your name, there is one person (computer) will play it with you. 
You will choose randomly from 1 to 5 corresponding the Paper, Rock, Scissors, Lizard, Spock respectively. 
The computer will randomly pick up one of the following: Paper, Rock, Scissors, Lizard, Spock. 
The winner is determined by, Scissors cuts paper, and paper covers rock, rock breaks scissors. 
If you and computer select the same option, it is a tie.
The game has a winner based on one of the following outcomes:

--------------------------------------------
1. Rock breaks Scissors.
2. Paper covers Rock.
3. Scissors cuts Paper.
4. Lizard poisons Spock.
5. Spock vaporizes Rock.
6. Paper disproves Spock.
7. Scissors capitates Lizard.
8. Spock smashes scissors.
9. Lizard eats Paper.
10. Rock pulverizes Lizard.
11. Draw (both players selected same option)
--------------------------------------------
Good luck.
 Please enter your name > Hieu Gia
 Select one from the following:
 1. paper
 2. rock
 3. scissors
 4. lizard
 5. Spock
 -------------------> 3
 Player: Hieu Gia chose scissors	 The Computer chose rock
Compare two choices: 
rock BREAKS scissors
Do you want to play again? (y/n): y
 Select one from the following:
 1. paper
 2. rock
 3. scissors
 4. lizard
 5. Spock
 -------------------> 1
 Player: Hieu Gia chose paper	 The Computer chose rock
Compare two choices: 
paper COVERS rock
Do you want to play again? (y/n): y
 Select one from the following:
 1. paper
 2. rock
 3. scissors
 4. lizard
 5. Spock
 -------------------> 5
 Player: Hieu Gia chose Spock	 The Computer chose rock
Compare two choices: 
Do you want to play again? (y/n): n
You finished the game.
This is Hieu Gia's statistics 
Number of wins: 2
Number of losses: 1
Number of ties: 0
The number of game played is: 3
The winning percentage is: 67%
 Congratulations Hieu Gia. You WON!


Computer wants to invite a new player, do you agree? (y/n): n
THANK YOU FOR SPENDING YOUR TIME TO PLAY GAME: SPOCK, SCISSORS, LIZARD, ROCK, PAPER WITH ME.
 I WISH YOU HAVE A GREAT DAY WHEN YOU COME PLAY GAME WITH ME.
BUILD SUCCESSFUL (total time: 44 seconds)

*/