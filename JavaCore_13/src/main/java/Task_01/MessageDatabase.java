package Task_01;

import java.util.*;

public class MessageDatabase {
    private static List<Message> messageList = new ArrayList<>();

    public static void sendMessage(User u1, User u2, String text) {
        messageList.add(new Message(u1, u2, text));
    }

    public static Collection<Message> getMessages() {
        return messageList;
    }

    public static void showDialog(User u1, User u2) {
        List<Message> resList = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getSender().getUserName() == u1.getUserName() && message.getReceiver().getUserName() == u2.getUserName()
                || message.getSender().getUserName() == u2.getUserName() && message.getReceiver().getUserName() == u1.getUserName()) {
                resList.add(message);
            }
        }
        Collections.sort(resList, COMPARE_BY_DATE);
        for (Message message : resList) {
            System.out.println(new StringBuilder(message.getSender().getUserName()).append(": ").append(message.getText()));
        }
    }

    public static final Comparator<Message> COMPARE_BY_DATE = new Comparator<Message>() {
        @Override
        public int compare(Message o1, Message o2) {
            if (o1.getDate().before(o2.getDate())) return 1;
            if (o1.getDate().after(o2.getDate())) return -1;
            return 0;
        }
    };
}
