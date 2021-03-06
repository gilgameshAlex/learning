package Task_04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MusicBand {
    private String name;
    private int year;
    private List<String> members;

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
        members = new ArrayList<>();
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public List<String> getMembers() {
        return members;
    }

    public void addMember(String name) {
        this.members.add(name);
    }

    public void removeMember(String name) {
        this.members.remove(name);
    }

    public int getYear() {
        return year;
    }

    public void printMembers() {
        System.out.println(members);
    }

    public static MusicBand transferMembers(String name, int year, MusicBand a, MusicBand b) {
        MusicBand res = new MusicBand(name, year);
        res.getMembers().addAll(a.getMembers());
        res.getMembers().addAll(b.getMembers());
        return  res;
    }

    public static List<String> transferMembers(List<String> a, List<String> b) {
        return Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return new StringBuilder("").append(this.name).append(" ").append(this.year).append(" ").append(this.members.toString()).toString();
    }
}
