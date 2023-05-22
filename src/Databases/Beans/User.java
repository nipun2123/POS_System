/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Beans;

import java.util.ArrayList;

/**
 *
 * @author nipun
 */
public class User {

    
    private int userId;
     private String userName;
    private String password;
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private ArrayList<Integer> questionsId;
    
    
    /**
     * @return the answers
     */
    public ArrayList<String> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public User setAnswers(ArrayList<String> answers) {
        this.answers = answers;
        return this;
    }
   

    /**
     * @return the questions
     */
    public ArrayList<String> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public User setQuestions(ArrayList<String> questions) {
        this.questions = questions;
        return this;
    }

    /**
     * @return the questionsId
     */
    public ArrayList<Integer> getQuestionsId() {
        return questionsId;
    }

    /**
     * @param questionsId the questionsId to set
     */
    public User setQuestionsId(ArrayList<Integer> questionsId) {
        this.questionsId = questionsId;
          return this;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public User setUserId(int userId) {
        this.userId = userId;
          return this;
    }
    
    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public User setPassword(String password) {
        this.password = password;
        return this;
    }
    
   
    
    
}
