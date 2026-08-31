package org.algostyle;

import java.util.ArrayList;
import java.util.List;

public class SubscribersDatabase {
    public List<String> getEmailsSubscribers(){
        List<String> emailsSubscribers = new ArrayList<>();
        // connection à la base de donné
        /*
        try{
            Connection connection = DriverManager.getConnection("DB_URL");
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT email FROM SUBSCRIBER_TABLE");
            while(rs.next()){
                emailsSubscribers.add(rs.toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }*/
        return emailsSubscribers;
    }
}
