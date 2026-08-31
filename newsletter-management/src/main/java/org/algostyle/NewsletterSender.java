package org.algostyle;

import java.util.List;

public class NewsletterSender {
    private SubscribersDatabase subscribersDatabase;
    private MessagingEngine messagingEngine;

    public NewsletterSender(SubscribersDatabase subscribersDatabase, MessagingEngine messagingEngine){
        this.subscribersDatabase = subscribersDatabase;
        this.messagingEngine = messagingEngine;
    }
    public void sendNewsletter(String subject)  {
        if(getNumberOfSubscribers() == 0){
            throw new ZeroSubscribersException();
        }
        List<String> emails = subscribersDatabase.getEmailsSubscribers();
        messagingEngine.sendEmail(subject, emails);
    }
    public int getNumberOfSubscribers(){
        return subscribersDatabase.getEmailsSubscribers().size();
    }

    public SubscribersDatabase getSubscribersDatabase(){
        return subscribersDatabase;
    }
    public MessagingEngine getMessagingEngine(){
        return messagingEngine;
    }

}
