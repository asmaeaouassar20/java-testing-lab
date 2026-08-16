import org.jilali.barrieres.EmailService;
import org.jilali.barrieres.UserBarriers;
import org.jilali.barrieres.UserRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserBarriersTest {
    @Test
    public void testUserPermit(){
        final int PASSENGER_ID = 3;
        UserRepository mockedUserRepository = mock(UserRepository.class);
        EmailService mockedEmailService = mock(EmailService.class);
        UserBarriers userBarriers = new UserBarriers(mockedUserRepository,mockedEmailService);

        userBarriers.userPermit(PASSENGER_ID);

        verify(mockedUserRepository).registerUserOnApp(PASSENGER_ID);
        verify(mockedEmailService).notifyUser(PASSENGER_ID);

    }
}
