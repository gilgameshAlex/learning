package Task_01;

public class Test {
    public static void main(String[] args) {
        User u1 = new User("Alex");
        User u2 = new User("Yarex");
        u1.sendMessage(u2, "Hello");
        u1.sendMessage(u2, "Where are you?");

        u2.sendMessage(u1, "Разговаривай по русский");
        u2.sendMessage(u1, "ты шо, англичанин?");
        u2.sendMessage(u1, "как дела то?");
        u1.sendMessage(u2, "нормуль");
        u2.sendMessage(u1, "го apex?");

        User u3 = new User("Unknown");
        u3.sendMessage(u1, "привет");
        u1.sendMessage(u3, "халлоу");
        u3.sendMessage(u1, "я тебя найду");
        u1.sendMessage(u3, "зачем?");
        u3.sendMessage(u1, "и накажу");
        u1.sendMessage(u3, "та за шо????");

        MessageDatabase.showDialog(u1, u2);
        System.out.println("------------------");
        MessageDatabase.showDialog(u3, u1);

        //System.out.println(MessageDatabase.getMessages());

        System.out.println("Первый подписан на второго - " + u1.isSubscripted(u2));
        u1.subscribe(u2);
        System.out.println("Первый подписан на второго - " + u1.isSubscripted(u2));

        System.out.println("Первый друг второго - " + u1.isFriend(u2));
        u2.subscribe(u1);
        System.out.println("Первый друг второго - " + u1.isFriend(u2));
        System.out.println("Второй друг первого - " + u2.isFriend(u1));
        System.out.println("Первый друг третьего - " + u1.isFriend(u3));
    }
}
