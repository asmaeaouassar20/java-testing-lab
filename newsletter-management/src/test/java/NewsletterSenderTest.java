import org.algostyle.MessagingEngine;
import org.algostyle.NewsletterSender;
import org.algostyle.SubscribersDatabase;
import org.algostyle.ZeroSubscribersException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class NewsletterSenderTest {

    // test constructor
    @Test
    public void constructorAssignsDatabase(){
        MessagingEngine messagingEngine=mock(MessagingEngine.class);
        SubscribersDatabase subscribersDatabase=new SubscribersDatabase();

        NewsletterSender newsletterSender=new NewsletterSender(subscribersDatabase,messagingEngine);
        assertEquals(subscribersDatabase, newsletterSender.getSubscribersDatabase());
    }

    @Test
    public void testGetNumberOfSubscribers(){
        SubscribersDatabase subscribersDatabase=mock(SubscribersDatabase.class); // nullified
        MessagingEngine messagingEngine=mock(MessagingEngine.class);


        NewsletterSender newsletterSender=new NewsletterSender(subscribersDatabase,messagingEngine);

        List<String> subscribersEmails = Arrays.asList("email1" , "email2" , "email3");

        // create a stub
        when(subscribersDatabase.getEmailsSubscribers()).thenReturn(subscribersEmails);

        int actualNumberOfSubscribers = newsletterSender.getNumberOfSubscribers();
        assertEquals(3,actualNumberOfSubscribers);
    }

    @Test
    public void testSendNewsletterThrowsZeroSubscribersException(){
        NewsletterSender newsletterSender = new NewsletterSender(new SubscribersDatabase(), new MessagingEngine());
        NewsletterSender newsletterSenderSpy = spy(newsletterSender);

        when(newsletterSenderSpy.getNumberOfSubscribers()).thenReturn(0);

        Throwable exception = assertThrows(ZeroSubscribersException.class, ()->{ newsletterSenderSpy.sendNewsletter("Hey Jilali"); });
        assertEquals("You have no subscribers" , exception.getMessage());
    }
}
