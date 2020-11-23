package Task_05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MusicBand {
    private String name;
    private int year;
    private List<MusicArtist> members;

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
        members = new ArrayList<>();
    }

    public void setMembers(List<MusicArtist> members) {
        this.members = members;
    }

    public List<MusicArtist> getMembers() {
        return members;
    }

    public void addMember(MusicArtist name) {
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

    public static List<MusicArtist> transferMembers(List<MusicArtist> a, List<MusicArtist> b) {
        return Stream.concat(a.stream(), b.stream()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return new StringBuilder("").append(this.name).append(" ").append(this.year).append(" ").append(this.members.toString()).toString();
    }
}
