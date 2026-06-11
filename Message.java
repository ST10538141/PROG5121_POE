import java.util.ArrayList;
import java.util.Random;

public class Message {

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    private static int totalMessages = 0;

    private static ArrayList<String> sentMessages = new ArrayList<>();
    private static ArrayList<String> storedMessages = new ArrayList<>();
    private static ArrayList<String> disregardedMessages = new ArrayList<>();
    private static ArrayList<String> messageHashes = new ArrayList<>();
    private static ArrayList<String> messageIDs = new ArrayList<>();

    public Message(String recipient, String messageText) {

        this.recipient = recipient;
        this.messageText = messageText;

        this.messageID = generateMessageID();

        totalMessages++;
        this.messageNumber = totalMessages;

        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {

        Random random = new Random();
        String id = "";

        for (int i = 0; i < 10; i++) {
            id += random.nextInt(10);
        }

        return id;
    }

    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    public String checkRecipientCell() {

        if (recipient.startsWith("+") && recipient.length() <= 13) {
            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    public String createMessageHash() {

        String firstTwo = messageID.substring(0, 2);

        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return firstTwo + ":" + messageNumber + ":" + firstWord + lastWord;
    }

    public String sentMessage(int option) {

        switch (option) {

            case 1:
                sentMessages.add(messageText);
                messageHashes.add(messageHash);
                messageIDs.add(messageID);
                return "Message successfully sent.";

            case 2:
                disregardedMessages.add(messageText);
                return "Message disregarded.";

            case 3:
                storedMessages.add(messageText);
                messageHashes.add(messageHash);
                messageIDs.add(messageID);
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + messageHash
                + "\nRecipient: " + recipient
                + "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {
        return totalMessages;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

    public static ArrayList<String> getSentMessages() {
        return sentMessages;
    }

    public static String displayLongestMessage() {

        String longest = "";

        for (String msg : storedMessages) {

            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }

        return longest;
    }

    public static String searchByMessageID(String id) {

        for (int i = 0; i < messageIDs.size(); i++) {

            if (messageIDs.get(i).equals(id)) {
                return "Message Found";
            }
        }

        return "Message not found";
    }

    public static String deleteMessageByHash(String hash) {

        for (int i = 0; i < messageHashes.size(); i++) {

            if (messageHashes.get(i).equals(hash)) {

                messageHashes.remove(i);

                return "Message successfully deleted.";
            }
        }

        return "Message not found.";
    }
}