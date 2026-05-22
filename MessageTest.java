// MessageTest.java

//import org.junit.Test;

public class MessageTest {

    //Test
    public void testMessageID() {

        Message messageObj =
                new Message("+27831234567", "Test message");

        boolean result = messageObj.checkMessageID();

        assertTrue(result);
    }

    //Test
    public void testValidCellNumber() {

        Message messageObj =
                new Message("+27825554444", "Hello there");

        String expected =
                "Cell phone number successfully captured.";

        assertEquals(expected,
                messageObj.checkRecipientCell());
    }

    //Test
    public void testInvalidCellNumber() {

        Message messageObj =
                new Message("0823456789", "Invalid number");

        String expected =
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";

        assertEquals(expected,
                messageObj.checkRecipientCell());
    }

    //Test
    public void testHashCreated() {

        Message messageObj =
                new Message("+27839876543", "Checking hash");

        assertNotNull(messageObj.getMessageHash());
    }

    //Test
     public void testMessageCounterIncrease() {

        int beforeTotal =
                Message.returnTotalMessages();

        Message obj =
                new Message("+27831230000", "Counter test");

        int afterTotal =
                Message.returnTotalMessages();

        AssertEquals(beforeTotal + 1, afterTotal);
    }

    private void assertTrue(boolean result) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(String expected, String checkRecipientCell) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertNotNull(String messageHash) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void AssertEquals(int i, int afterTotal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}