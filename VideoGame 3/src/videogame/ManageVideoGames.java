/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

/**
 *
 * @author pennyshuster
 */
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ManageVideoGames {

    boolean exit;
    LinkedList<VideoGame> VideoGames = new LinkedList<>();

    public static void main(String[] args) {

        //2.2.2 Application Class - ManageVideoGames
        //create an empty list of VideoGames
        //1. display 
        ManageVideoGames menu = new ManageVideoGames();
        menu.runMenu();

    }

    private void printMenu() {
        System.out.println("----Menu-----");
        System.out.println("1) add a new game");
        System.out.println("2) remove an existing game");
        System.out.println("3) Display the games in the order they were inserted");
        System.out.println("4) Find games with latest release");
        System.out.println("5) Exit");
        //2. get user choice

        //3. take action based on user choice until user quit
    }

    public void runMenu() {

        while (!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);

        }

    }

    private int getInput() {
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while (choice < 1 || choice > 5) {
            System.out.print("enter your choice: ");
            choice = Integer.parseInt(kb.nextLine());
        }
        return choice;
    }

    private void performAction(int choice) {
        switch (choice) {
            case 1:
                addNewGame(VideoGames);
                break;
            case 2:
                removeGame(VideoGames);
                break;
            case 3:
                display(VideoGames);
                break;
            case 4:
                gameWithLastestRelease(VideoGames);
                break;
            case 5:
                exit = true;
                break;
        }

    }

    private void addNewGame(LinkedList<VideoGame> games) {
        VideoGame newGame = new VideoGame(addNewTitle(), addNewDeveloper(), newPlatforms(), newReleaseDate());
        games.add(newGame);

    }

    public String addNewTitle() {
        Scanner kb = new Scanner(System.in);
        System.out.println("enter game title");
        String newGameTitle = kb.nextLine();
        return newGameTitle;
    }

    public String addNewDeveloper() {
        Scanner kb = new Scanner(System.in);
        System.out.println("enter game developer");
        String newGameDeveloper = kb.nextLine();
        return newGameDeveloper;
    }

    public int getNumPlatforms() {
        Scanner kb = new Scanner(System.in);
        System.out.println("enter number of platforms");
        int newNumPlatforms = Integer.parseInt(kb.nextLine());
        return newNumPlatforms;
    }

    public String[] newPlatforms() {
        int numPlatforms = getNumPlatforms();
        Scanner kb = new Scanner(System.in);
        String[] newPlatforms;
        newPlatforms = new String[numPlatforms];
        for (int i = 0; i < numPlatforms; i++) {

            System.out.println("enter platform");
            newPlatforms[i] = kb.nextLine();
        }
        return newPlatforms;

    }

    public LocalDate newReleaseDate() {
        Scanner kb = new Scanner(System.in);
        System.out.println("enter year in numbers ex: 2009");
        int year = Integer.parseInt(kb.nextLine());
        System.out.println("enter month in numbers ex: 8");
        int month = Integer.parseInt(kb.nextLine());
        System.out.println("enter day in number ex: 20");
        int day = Integer.parseInt(kb.nextLine());
        LocalDate releaseDate = LocalDate.of(year, month, day);
        return releaseDate;
    }

    private void removeGame(LinkedList<VideoGame> games) {
        Scanner kb = new Scanner(System.in);
        System.out.println("enter index  of game you want to remove");
        int removedGame = Integer.parseInt(kb.nextLine());
        games.remove(removedGame);

    }

    public void display(LinkedList<VideoGame> games) {
        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i));
            
        }
    }

    public void gameWithLastestRelease(LinkedList<VideoGame> games) {
        int newestGameIndex = 0;
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getReleaseDate().isBefore(games.get(newestGameIndex).getReleaseDate())) {
                newestGameIndex = i;
            }

        }
        System.out.println(games.get(newestGameIndex));
    }

    //define other methods for modularization, samples are listed
    //add a video game based on user input
    //remove a game based on user input
    //find the game with latest release date
    //get user choice
    //display menu
}
