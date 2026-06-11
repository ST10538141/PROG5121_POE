import javax.swing.JOptionPane;

public class QuickChat {

    public static void main(String[] args) {

        boolean loggedIn = true;

        if (!loggedIn) {

            JOptionPane.showMessageDialog(
                    null,
                    "Login failed."
            );

            return;
        }

        JOptionPane.showMessageDialog(
                null,
                "Welcome to QuickChat."
        );

        int numberOfMessages =
                Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "How many messages would you like to send?"
                        )
                );

        int sentCount = 0;

        boolean isRunning = true;

        while (isRunning) {

            String menu =
                    "QuickChat Menu\n\n"
                    + "1. Send Messages\n"
                    + "2. Show Sent Messages\n"
                    + "3. Stored Messages\n"
                    + "4. Quit";

            int choice =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(menu)
                    );

            switch (choice) {

                case 1:

                    for (int i = 0; i < numberOfMessages; i++) {

                        String recipient =
                                JOptionPane.showInputDialog(
                                        "Enter recipient cell number:"
                                );

                        String messageText =
                                JOptionPane.showInputDialog(
                                        "Enter your message:"
                                );

                        if (messageText.length() > 250) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Please enter a message less than 250 characters."
                            );

                            continue;
                        }

                        Message msg =
                                new Message(recipient, messageText);

                        JOptionPane.showMessageDialog(
                                null,
                                msg.checkRecipientCell()
                        );

                        String result =
                                msg.sentMessage(1);

                        JOptionPane.showMessageDialog(
                                null,
                                result + "\n\n"
                                + msg.printMessages()
                        );

                        sentCount++;
                    }

                    break;

                case 2:

                    if (Message.getSentMessages().isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "No messages have been sent."
                        );

                    } else {

                        JOptionPane.showMessageDialog(
                                null,
                                Message.getSentMessages().toString()
                        );
                    }

                    break;

                case 3:

                    String storedMenu =
                            "Stored Messages Menu\n\n"
                            + "1. Display Longest Message\n"
                            + "2. Search Message ID\n"
                            + "3. Delete Message By Hash\n"
                            + "4. Display Report";

                    JOptionPane.showMessageDialog(
                            null,
                            storedMenu
                    );

                    break;

                case 4:

                    JOptionPane.showMessageDialog(
                            null,
                            "Total number of messages sent: "
                                    + sentCount
                    );

                    isRunning = false;

                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid option."
                    );
            }
        }
    }
}