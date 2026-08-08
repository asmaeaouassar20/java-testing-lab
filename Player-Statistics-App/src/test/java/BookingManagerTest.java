import org.algostyle.BookingManager;
import org.algostyle.HotelDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingManagerTest {
    private BookingManager bookingManager;

    @BeforeEach
    public void setup() throws SQLException{
        HotelDao hotelDaoMock = mock(HotelDao.class); // not real instance, it's a mocked version
        bookingManager = new BookingManager(hotelDaoMock);
        List<String> availableRoomsFromFakeDb = Arrays.asList("room A", "room C", "rom K", "rom Y");
        when(hotelDaoMock.fetchAvailableRooms()).thenReturn(availableRoomsFromFakeDb);
    }
    @Test
    public void testCheckRoomAvailabilityTrue() throws SQLException {
        assertTrue(bookingManager.checkRoomAvailability("room A"));
    }
    @Test
    public void testCheckRoomAvailabilityFalse() throws SQLException {
        assertFalse(bookingManager.checkRoomAvailability("room X"));
    }
}
