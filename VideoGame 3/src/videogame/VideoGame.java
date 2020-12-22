/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

/**
 *
 * @author pennyshuster */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class VideoGame {

    //2.2.1 Entity Class - VideoGame

    //data fields
    private String title;
    private String developer;     //lead developer 
    private String platforms[];
    private LocalDate releaseDate;

    public VideoGame(String title, String developer, String platforms[], LocalDate releaseDate) {
        this.title = title;
        this.developer = developer;
        this.platforms = platforms;
        this.releaseDate = releaseDate;
      
    }

    //add constructor that takes in values for all data fields
    

    //add a getter for each data field
    public String getTitle() {
        return title;
    }
    
    public String getDeveloper() {
        return developer;
    }
    
    public String[] getPlatforms(){
        return platforms;
    }
    
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    //add a setter for each data field
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPlatforms(String[] platforms){
        this.platforms = platforms;
    }
    
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    
    
    
    @Override
    public String toString() {
        return "title: " + title + " developer: " + developer + " platforms: "
                + Arrays.toString(platforms) + " release date: " + releaseDate;
        //add your code
        //return a string including all infor. about a game
        // date value included in format: 9/15/2020 for Sep. 15, 2020
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null){
         return false;
        }
        if (this == otherObject){
            return true;
        }
        VideoGame otherEntry = (VideoGame) otherObject;
        return this.title.equals(otherEntry.title);
        //add your code
        // comparing two VideoGame objects based only on title
        

    }    
}
