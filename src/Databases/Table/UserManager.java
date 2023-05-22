/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases.Table;

import Databases.Beans.User;
import Databases.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nipun
 */
public class UserManager {

    public static boolean addUser(User user) {

        int userId = DB.iudReturnId("INSERT INTO user(username,password,account_status) VALUES('" + user.getUserName() + "','" + user.getPassword() + "','1')");

        if (userId > 0) {
            user.setUserId(userId);
            return addQuestionAnswers(user);
        }
        return false;
    }

    private static boolean addQuestionAnswers(User user) {

        boolean b = false;

        user.setQuestionsId(getQuestionId(user.getQuestions()));
        for (int i = 0; i < user.getQuestionsId().size(); i++) {

            b = DB.iud("INSERT INTO recovery_answers(iduser,idrecovery_questions,answer) VALUES('" + user.getUserId() + "', '" + user.getQuestionsId().get(i) + "','" + user.getAnswers().get(i) + "')");
        }
        return b;
    }

    private static ArrayList<Integer> getQuestionId(ArrayList<String> questions) {

        ArrayList<Integer> questionId = new ArrayList<Integer>();

        for (String question : questions) {
            try {
                ResultSet result = DB.search("SELECT idrecovery_questions FROM recovery_questions WHERE recovery_question = '" + question + "' ");

                if (result.next()) {
                    System.out.println(result.getInt("idrecovery_questions"));
                    questionId.add(result.getInt("idrecovery_questions"));
                }

            } catch (SQLException ex) {
                DB.processException(ex);
            }
        }

        return questionId;
    }

    public static ResultSet getAllQuestions() {
        return DB.search("SELECT * FROM recovery_questions");
    }

    public static ResultSet getActiveUserNameFromName(String username) {

        return DB.search("SELECT username from user WHERE BINARY username = '" + username + "' AND account_status = '1' ");
    }

    public static ResultSet getDeactiveUserNameFromName(String username) {

        return DB.search("SELECT username from user WHERE BINARY username = '" + username + "' AND account_status = '0' ");
    }

    public static ResultSet getActiveUserFromCredential(String username, String password) {

        return DB.search("SELECT * from user where BINARY username='" + username + "'AND  password='" + password + "' AND account_status = '1'");
    }

    public static boolean addLoginLog(String userId, Timestamp currentTime) {
        return DB.iud("INSERT INTO user_log(login_time,iduser) VALUES('" + currentTime + "', '" + userId + "')");
    }

    public static boolean deactivateUserFromUsername(String username) {
        return DB.iud("UPDATE user SET account_status = '0' WHERE  BINARY username = '" + username + "' ");
    }

    public static boolean isUserNameExits(String username) {

        ResultSet result = DB.search("SELECT iduser FROM user WHERE BINARY username = '" + username + "' ");

        try {
            if (result.next()) {
                return true;
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }
        return false;
    }

    public static ResultSet getSelecteQ_AFromUsername(String username) {

        return DB.search("select recovery_question,answer from user inner join recovery_answers inner join recovery_questions on "
                + "user.iduser = recovery_answers.iduser and recovery_answers.idrecovery_questions = recovery_questions.idrecovery_questions "
                + "where username = '" + username + "' ");
    }

    public static boolean resetPasswordFromName(String password, String username) {

        return DB.iud("UPDATE user SET password = '" + password + "' WHERE username = '" + username + "' ");
    }

      public static boolean resetPasswordFromUid(String password, String userId) {

        return DB.iud("UPDATE user SET password = '" + password + "' WHERE iduser = '" + userId + "' ");
    }
      
      
    public static String getUsernameFromUid(String userId) {

        ResultSet result = DB.search("SELECT username FROM user WHERE iduser = '" + userId + "' ");

        try {
            if (result.next()) {
                return result.getString("username");
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }
        return null;
    }

    public static String getPasswordFromUid(String userId) {
        ResultSet result = DB.search("SELECT password FROM user WHERE iduser = '" + userId + "' ");

        try {
            if (result.next()) {
                return result.getString("password");
            }
        } catch (SQLException ex) {
            DB.processException(ex);
        }
        return null;
    }
    
    public static ResultSet getLastLogedUser(){
       return DB.search("SELECT user_log.iduser_log, user.username FROM user_log INNER JOIN user ON user_log.iduser = user.iduser ORDER BY iduser_log DESC LIMIT 1");
    }

    public static boolean setLogoutToUser(String logId, Timestamp currentTime){
       return DB.iud("UPDATE user_log set logout_time ='" + currentTime + "' WHERE iduser_log = '" + logId + "' ");
    }
}
