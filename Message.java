// Message.java

public class Message {

    private static int totalMessages = 0;

    private String recipient;
    private String messageText;
    private String messageID;
    private String messageHash;

    public Message(String recipient, String messageText) {

        this.recipient = recipient;
        this.messageText = messageText;

        // Generate message details
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();

        totalMessages++;
    }

    // Generate random message ID
    private String generateMessageID() {

        String id =
                String.valueOf((int)(Math.random() * 1000000000));

        return id;
    }

    // Check if ID is valid
    public boolean checkMessageID() {

        if (messageID.length() <= 10) {
            return true;
        }
        else {
            return false;
        }
    }

    // Validate recipient number
    public String checkRecipientCell() {

        if (recipient.startsWith("+27")
                && recipient.length() == 12) {

            return "Cell phone number successfully captured.";
        }
        else {

            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Create hash value
    private String createMessageHash() {

        String firstTwo =
                messageID.substring(0, 2);

        String[] words =
                messageText.split(" ");

        String firstWord =
                words[0].toUpperCase();

        String lastWord =
                words[words.length - 1].toUpperCase();

        return firstTwo + ":" + totalMessages + ":" +
                firstWord + lastWord;
    }

    public String getMessageHash() {
        return messageHash;
    }

    // Simulate sending message
    public String sentMessage(int option) {

        if (option == 1) {
            return "Message successfully sent.";
        }
        else if (option == 2) {
            return "Press 0 to delete message.";
        }
        else {
            return "Message successfully stored.";
        }
    }

    // Display message info
    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {
        return totalMessages;
    }
}