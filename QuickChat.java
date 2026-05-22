// QuickChat.java

import javax.swing.JOptionPane;

public class QuickChat {

    public static void main(String[] args) {

        // User already logged in from Part 1
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

            String menuOptions =
                    "QuickChat Menu\n\n"
                    + "1. Send Messages\n"
                    + "2. Show Recently Sent Messages\n"
                    + "3. Quit";

            int userChoice =
                    Integer.parseInt(
                            JOptionPane.showInputDialog(menuOptions)
                    );

            switch (userChoice) {

                case 1:

                    for (int i = 0; i < numberOfMessages; i++) {

                        String recipient =
                                JOptionPane.showInputDialog(
                                        "Enter recipient cell number (Example: +27831234567):"
                                );

                        String messageText =
                                JOptionPane.showInputDialog(
                                        "Enter your message:"
                                );

                        // Check if message exceeds limit
                        if (messageText.length() > 250) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Message exceeds 250 characters by "
                                            + (messageText.length() - 250)
                                            + " characters."
                            );

                            continue;
                        }

                        Message messageObj =
                                new Message(recipient, messageText);

                        JOptionPane.showMessageDialog(
                                null,
                                messageObj.checkRecipientCell()
                        );

                        String result =
                                messageObj.sentMessage(1);

                        JOptionPane.showMessageDialog(
                                null,
                                result + "\n\n"
                                        + messageObj.printMessages()
                        );

                        sentCount++;
                    }

                    break;

                case 2:

                    JOptionPane.showMessageDialog(
                            null,
                            "Coming Soon."
                    );

                    break;

                case 3:

                    // Exit program
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