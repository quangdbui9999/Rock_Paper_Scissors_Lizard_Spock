/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, February 22th, 2017
 *  Description: CSC-122 Fall 2016 Project 2 Starter Code
 */

package Project2RPSLSpock;

import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Programmed by: Quang Bui
 * Due Date: Thursday, February 22th, 2017
 * Description: CSC-122 Fall 2016 Project 2 Starter Code
 */
public class RPSLSpockGame {
    private Player player;
    private Choice computerPick;
    private Winner winner;
    private int gameCount;
    private int computerWins,
                ties,
                playerWins;   // ? goes with Player ? 
    private int spockCount;   // ? Player's spock count
    private double winningPercentage; // ? Player ?
    
    /**
     * CONSTRUCTOR
     * Pre-condition: player, computerPick, winner, gameCount,
     * computerWins, ties, playerWins, spockCount, and winningPercentage
     * variables must be declared (these variable don't need to 
     * initialize).
     * Post-condition: player, computerPick, winner, gameCount,
     * computerWins, ties, playerWins, spockCount, and winningPercentage
     * variables have been assigned the value (initialize)
     */
    public RPSLSpockGame(){
        player = new Player();
        gameCount = computerWins = ties = 0;
        spockCount = playerWins = 0;
        winningPercentage = 0.0;
        winner = Winner.tie;
        computerPick = Choice.Spock;
    }
    
    /**
     * Mutator: playGame(), this is the most important function of 
     * the RPSLSpock Program because it is gathered all function
     * in this program to run the game.
     * Pre-condition: these method: instructions();getPlayerName(); 
     * makeComputerChoice(); makePlayerChoice(); showChoices(); 
     * showDetailChoice(); determineWinner(); checkForAWinner(); 
     * gameResults(); reportWinner(); resetInformation();
     * must be coded completely
     * Post-condition: The playGame() method will assemble these methods
     * instructions();getPlayerName(); gameResults(); reportWinner(); 
     * makeComputerChoice(); makePlayerChoice(); showChoices(); 
     * showDetailChoice(); determineWinner(); checkForAWinner(); 
     * to run the game. After a player have chose a choice, the game
     * will output the computer's choice, it is compare two choice to 
     * determine who is win. A player can be chose in the next time by
     * pressing "y" when the screen output
     * "Do you want to play again? (y/n): ". If he/she doesn't play
     * game, he/she should pressing n. And the game will notify
     * the result of the game (their winning percentage, number of wins,
     * number of losses, number of tie, how many they chose)
     */
    
    public void playGame()
    {
        Scanner cin = new Scanner(System.in);
        String play_again = "";
        String inviteNewMember = "";
        
        do{
            instructions();
            getPlayerName();
            do{
                makeComputerChoice();  // sets computerPick
                makePlayerChoice(); // sets player picks
                showChoices(); // for player and computer
                showDetailChoice();
                determineWinner(); // sets winner
                checkForAWinner();
                gameCount++;
                //gameResults();
                System.out.print("Do you want to play again? (y/n): ");
                play_again = cin.nextLine();
            }while(play_again.equalsIgnoreCase("y"));
            gameResults();
            reportWinner(); //  who and why
            
            System.out.print("\n\nComputer wants to invite a new player"
                    + ", do you agree? (y/n): ");
            inviteNewMember = cin.nextLine();
            if(inviteNewMember.equalsIgnoreCase("y")){
                this.resetInformation();
            }
        }while(inviteNewMember.equalsIgnoreCase("y"));
        
        System.out.println("THANK YOU FOR SPENDING YOUR TIME TO PLAY"
                + " GAME: SPOCK, SCISSORS, LIZARD, ROCK, PAPER"
                + " WITH ME.\n I WISH YOU HAVE A GREAT DAY WHEN"
                + " YOU COME PLAY GAME WITH ME.");
    }
    
    /**
     * Mutator: resetInformation()
     * Pre-condition: player, computerPick, winner, gameCount,
     * computerWins, ties, playerWins, spockCount, and winningPercentage
     * variables must be declared (these variable don't need to 
     * initialize).
     * Post-condition: This method looks like the default constructor 
     * method of the RPSLSpockGame class. When a new player takes part
     * in the game, all previous player's information have been resetted
     */
    private void resetInformation(){
        player = new Player();
        gameCount = computerWins = ties = 0;
        spockCount = playerWins = 0;
        winningPercentage = 0.0;
        winner = Winner.tie;
        computerPick = Choice.Spock;
    }
    
    /**
     * Mutator: instructions()
     * Pre-condition: None
     * Post-condition: Output the instructions of the game
     */
    private void instructions(){
        System.out.println("Welcome to the game of Paper, Rock, "
            + "Scissors, Lizard, Spock. \nThe first time, you need to "
            + "enter your name. \nAfter you enter your name, there is one "
            + "person (computer) will play it with you. \nYou will choose "
            + "randomly from 1 to 5 corresponding the Paper, Rock, "
            + "Scissors, Lizard, Spock respectively. \nThe computer will "
            + "randomly pick up one of the following: Paper, Rock, "
            + "Scissors, Lizard, Spock. \nThe winner is determined by, "
            + "Scissors cuts paper, and paper covers rock, rock breaks "
            + "scissors. \nIf you and computer select the same option, "
            + "it is a tie.");
        System.out.println("The game has a winner based on one of "
                + "the following outcomes:");
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("1. Rock breaks Scissors.");
        System.out.println("2. Paper covers Rock.");
        System.out.println("3. Scissors cuts Paper.");
        System.out.println("4. Lizard poisons Spock.");
        System.out.println("5. Spock vaporizes Rock.");
        System.out.println("6. Paper disproves Spock.");
        System.out.println("7. Scissors capitates Lizard.");
        System.out.println("8. Spock smashes scissors.");
        System.out.println("9. Lizard eats Paper.");
        System.out.println("10. Rock pulverizes Lizard.");
        System.out.println("11. Draw (both players selected same option)");
        System.out.println("--------------------------------------------");
        System.out.println("Good luck.");
    }
    
    /**
    * Mutator: getPlayerName()
    * Pre-condition: the setName() method must be defined in 
    * Player class.
    * Post-condition: set the name of player
    */
    private void getPlayerName()
    {
        player.setName();
    }
    
    /**
    * Mutator: makeComputerChoice()
    * Pre-condition: the enumerated Choice be be declare
    * Post-condition: the computer will choose randomly from 1 to 5 
    * corresponding the paper, rock, scissors, lizard, and Spock.
    * This selection will be chosen randomly.
    */
    private void makeComputerChoice()
    {
        Random rand = new Random();
        int num = rand.nextInt(5) + 1; //get random number from 1 to 5 

        if (num == 1)
            computerPick = Choice.paper;
        else if (num == 2)
            computerPick = Choice.rock;
        else if (num == 3)
            computerPick = Choice.scissors;
        else if (num == 4)
            computerPick = Choice.lizard;
        else
            computerPick = Choice.Spock;
    }
    
    /**
     * Mutator: makePlayerChoice()
     * Pre-condition: the setChoice() method must be defined in 
     * Player class.
     * Post-condition: set the choice of player
     */
    private void makePlayerChoice(){
        player.setChoice();
    }
    
    /**
    * Mutator: showChoices()
    * Pre-condition: the player and computer must be choice one of
    * the following choice already: paper, rock, scissors, lizard,
    * and Spock.
    * Post-condition: output the choice of player and computer
    */
    private void showChoices()
    {
        System.out.println(" Player: " + player.getName() +
                " chose " + player.getChoice() +
                "\t The Computer chose " + computerPick);
    }
    
    /**
    * Mutator: showDetailChoice()
    * Pre-condition: the player and computer must be choice one of
    * the following choice already: paper, rock, scissors, lizard,
    * and Spock.
    * Post-condition: compare two choices of player and computer
    * and output the details of two choices
    */
    private void showDetailChoice(){
        System.out.print("Compare two choices: \n");
        switch(computerPick){
            case paper:{
                if(player.getChoice() == Choice.rock){
                    System.out.println(computerPick + " COVERS " 
                            + player.getChoice());
                }else if(player.getChoice() == Choice.Spock){
                    System.out.println(computerPick + " DISPROVES " 
                            + player.getChoice());
                }
                break;
            }
            case rock:{
                if(player.getChoice() == Choice.lizard){
                    System.out.println(computerPick + " PULVERIZES " 
                            + player.getChoice());
                }else if(player.getChoice() == Choice.scissors){
                    System.out.println(computerPick + " BREAKS " 
                            + player.getChoice());
                }
                break;
            }
            case scissors:{
                if(player.getChoice() == Choice.paper){
                    System.out.println(computerPick + " CUTS " 
                            + player.getChoice());
                }else if(player.getChoice() == Choice.lizard){
                    System.out.println(computerPick + " CAPITATES " 
                            + player.getChoice());
                }
                break;
            }
            case lizard:{
                if(player.getChoice() == Choice.Spock){
                    System.out.println(computerPick + " POISONS " 
                            + player.getChoice());
                }else if(player.getChoice() == Choice.paper){
                    System.out.println(computerPick + " EATS " 
                            + player.getChoice());
                }
                break;
            }
            case Spock:{
                if(player.getChoice() == Choice.paper){
                    System.out.println(computerPick + " VAPORIZES " 
                            + player.getChoice());
                }else if(player.getChoice() == Choice.scissors){
                    System.out.println(computerPick + " SMASHES " 
                            + player.getChoice());
                }
                break;
            }
        }
        
        
        switch(player.getChoice()){
            case paper:{
                if(computerPick == Choice.rock){
                    System.out.println(player.getChoice() + " COVERS " 
                            + computerPick);
                }else if(computerPick == Choice.Spock){
                    System.out.println(player.getChoice() + " DISPROVES " 
                            + computerPick);
                }
                break;
            }
            case rock:{
                if(computerPick == Choice.lizard){
                    System.out.println(player.getChoice() + " PULVERIZES " 
                            + computerPick);
                }else if(computerPick == Choice.scissors){
                    System.out.println(player.getChoice() + " BREAKS " 
                            + computerPick);
                }
                break;
            }
            case scissors:{
                if(computerPick == Choice.paper){
                    System.out.println(player.getChoice() + " CUTS " 
                            + computerPick);
                }else if(computerPick == Choice.lizard){
                    System.out.println(player.getChoice() + " CAPITATES " 
                            + computerPick);
                }
                break;
            }
            case lizard:{
                if(computerPick == Choice.Spock){
                    System.out.println(player.getChoice() + " POISONS " 
                            + computerPick);
                }else if(computerPick == Choice.paper){
                    System.out.println(player.getChoice() + " EATS " 
                            + computerPick);
                }
                break;
            }
            case Spock:{
                if(computerPick == Choice.paper){
                    System.out.println(player.getChoice() + " VAPORIZES " 
                            + computerPick);
                }else if(computerPick == Choice.scissors){
                    System.out.println(player.getChoice() + " SMASHES " 
                            + computerPick);
                }
                break;
            }    
        }
    }
    
    
    /**
     * Mutator: determineWinner()
     * Pre-condition: the player and computer must be choice one of
     * the following choice already: paper, rock, scissors, lizard,
     * and Spock.
     * Post-condition: compare two choices of player and computer
     * and determine who will be Win in a selection. If computer wins,
     * the computerWins variable will be added 1, If the player wins,
     * the playerWins variable will be added 1, if the computer
     * and player chose the same choice, the ties variable will be
     * added 1
     */
    private void determineWinner(){
        if(computerPick == player.getChoice()){
            winner = Winner.tie;
            ties++;
        }else{
            switch(computerPick){
                case paper:{
                    if(player.getChoice() == Choice.Spock
                        || player.getChoice() == Choice.rock){
                        winner = Winner.computer;
                        computerWins++;
                    }else{
                        winner = Winner.player;
                        playerWins++;
                    }
                    break;
                }
                case rock:{
                    if(player.getChoice() == Choice.lizard
                        || player.getChoice() == Choice.scissors){
                        winner = Winner.computer;
                        computerWins++;
                    }else{
                        winner = Winner.player;
                        playerWins++;
                    }
                    break;
                }
                case scissors:{
                    if(player.getChoice() == Choice.lizard
                        || player.getChoice() == Choice.paper){
                        winner = Winner.computer;
                        computerWins++;
                    }else{
                        winner = Winner.player;
                        playerWins++;
                    }
                    break;
                }
                case lizard:{
                    if(player.getChoice() == Choice.Spock
                        || player.getChoice() == Choice.paper){
                        winner = Winner.computer;
                        computerWins++;
                    }else{
                        winner = Winner.player;
                        playerWins++;
                    }
                    break;
                }
                case Spock:{
                    if(player.getChoice() == Choice.scissors
                        || player.getChoice() == Choice.rock){
                        winner = Winner.computer;
                        computerWins++;
                    }else{
                        winner = Winner.player;
                        playerWins++;
                    }
                    break;
                }
            }
        }
    }
    
    /**
     * Mutator: checkForAWinner()
     * Pre-condition: the variable of ties, playerWins, computerWins
     * must be initialize, they can be a nonzero number after the player
     * chose 1 choice
     * Post-condition: if playerWins > computerWins, the winner will be
     * player, if playerWins < computerWins, the winner will be
     * computer, if playerWins == computerWins, they ties
     */
    private void checkForAWinner(){
        if(playerWins > computerWins){
            winner = Winner.player;
        }else if(playerWins < computerWins){
            winner = Winner.computer;
        }else if(playerWins == computerWins){
            winner = Winner.tie;
        }
    }
    
    /**
     * Accessor: getWinningPercentage()
     * @return winningPercentage
     * Pre-condition: the gameCount and playerWins variables must
     * be declared and initialized.
     * Post-condition: this method will be calculated the winning
     * percentage of the player when they finished in the process
     * of the compare two choices between computer and players
     * (after one time choice)
     */
    private double getWinningPercentage(){
        if(gameCount == 0){
            return -1;
        }else{
            winningPercentage = (double)playerWins / gameCount;
            return winningPercentage;
        }
    }
    
    /**
     * Mutator: gameResults()
     * Pre-condition: The programmer should import the NumberFormat 
     * class. The getWinningPercentage() method must be calculated.
     * playerWins, computerWins, ties, gameCount variables must be 
     * declared and calculated.
     * Post-condition: This method will output the information include
     * the player's number of wins (playerWins), games played 
     * (gameCount), and their winning percentage (getWinningPercentage)
     * getWinningPercentage is formatted based on the getPercentInstance
     * method of NumberFormat class.
     */
    private void gameResults(){
        NumberFormat percent = NumberFormat.getPercentInstance();
        System.out.println("You finished the game.");
        System.out.println("This is " + player.getName() +"'s"
                + " statistics ");
        System.out.println("Number of wins: " + playerWins);
        System.out.println("Number of losses: " + computerWins);
        System.out.println("Number of ties: " + ties);
        System.out.println("The number of game played is: " + gameCount);
        System.out.println("The winning percentage is: "
                + percent.format(this.getWinningPercentage()));
    }
    
    /**
     * Mutator: reportWinner()
     * Pre-condition: the winner enumerated must be declared in
     * the enumerated class.
     * Post-condition: This method will output who is the winner.
     */
    private void reportWinner(){
        if(winner == Winner.player){
            System.out.println(" Congratulations "
          + player.getName() + ". You WON!");
        }else if(winner == Winner.computer){
            System.out.println(" " + player.getName() 
                    + " lose! The Computer WON");
        }else if(winner == Winner.tie){
            System.out.println(player.getName() + " and Computer"
                    + " tie.");
        }
    }
}