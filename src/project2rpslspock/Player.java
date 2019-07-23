/*
 *  CSC-122 SP 2018 PROJECT:
 *  Programmer: Quang Bui
 *  Due Date: Thursday, February 22th, 2017
 *  Description: Sample CS1 Starter code for Player
 */

package Project2RPSLSpock;

import java.util.Scanner;

/**
 *
 * Programmed by: Quang Bui
 * Due Date: Thursday, February 22th, 2017
 * Description: Sample CS1 Starter code for Player
 * 
 */
public class Player {
    private String name;
    private int score;
    private Choice choice;
    
    /**
     * C O N S T R U C T O R
     */
    public Player(){
        name = "";
        score = 0;
        choice = Choice.Spock;
    }
    
    /**
     * C O N S T R U C T O R
     * @param inName 
     */
    public Player(String inName){
        name = inName;
        score = 0;
        choice = Choice.Spock;
    }
    
    /**
     * Accessor: toString()
     * @return output String of class object
     */
    public String toString(){
        String out = "";
        out += " Name: " + name + " Score: "+ score;
        return out;
    }
    
    /**
     * Mutator: setName(String inName)
     * @param inName 
     */
    public void setName(String inName)
    {
        name = inName;
    }
    
    /**
     * Mutator: setName()
     */
    public void setName()
    {
        Scanner cin = new Scanner(System.in);
        
        System.out.print ( " Please enter your name > ");
        name = cin.nextLine();
    }
    
    /**
     * Mutator: setScore(int inScore)
     * @param inScore 
     */
    public void setScore(int inScore)
    {
        score = inScore;
    }
    
    /**
     * Mutator: setChoice( Choice inChoice)
     * @param inChoice 
     */
    public void setChoice( Choice inChoice)
    {
        choice = inChoice;
    }
    
    /**
     * Mutator: setChoice
     * Retrieve the input from user for PRSLSpockGame 
     */
    public void setChoice()
    {
        Scanner cin = new Scanner(System.in);
        int numChoice;

        do{
            System.out.print (" Select one from the following:"
                            + "\n 1. " + Choice.paper 
                            + "\n 2. " + Choice.rock
                            + "\n 3. " + Choice.scissors
                            + "\n 4. " + Choice.lizard
                            + "\n 5. " + Choice.Spock
                            + "\n -------------------> ");
            numChoice = cin.nextInt();
            
            if(numChoice < 1 || numChoice > 5){
                System.err.println("The selection is invalid. Can you"
                        + " choose again, please?");
            }
        }while(numChoice < 1 || numChoice > 5);
        
        switch (numChoice)
        {
            case 1: choice = Choice.paper; break;
            case 2: choice = Choice.rock; break;
            case 3: choice = Choice.scissors; break;
            case 4: choice = Choice.lizard; break;
            case 5: choice = Choice.Spock; break;
        }

    }
    
    /**
     * Accessor: getName()
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Accessor: getScore()
     * @return score
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Accessor: getChoice()
     * @return choice
     */
    public Choice getChoice()
    {
        return choice;
    }
}
