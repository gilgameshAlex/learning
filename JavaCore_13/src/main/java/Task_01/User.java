package Task_01;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private List<User> subscriptions;

    public User(String userName) {
        this.userName = userName;
        subscriptions = new ArrayList<>();
    }

    public void subscribe(User user) {
        subscriptions.add(user);
    }

    public boolean isSubscripted(User user) {
        return subscriptions.contains(user);
    }

    public  boolean isFriend(User user) {
        if (this.subscriptions.contains(user) && user.getSubscriptions().contains(this))
            return  true;
        else
            return false;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSubscriptions(List<User> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void sendMessage(User user, String text) {
        MessageDatabase.sendMessage(this, user, text);
    }

    public String getUserName() {
        return userName;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }

    @Override
    public String toString() {
        return this.userName;
    }
}
