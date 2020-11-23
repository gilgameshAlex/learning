package Task_05;

public class Main {
    public static void main(String[] args) {
        MusicBand band = new MusicBand("G1", 1000);
        band.addMember(new MusicArtist("Low Jhonson", 10));
        band.addMember(new MusicArtist("Dead Moroz", 9999));
        System.out.println(band);

        MusicBand band1 = new MusicBand("G2", 1001);
        band1.addMember(new MusicArtist("Emelya Durachok", 231));
        System.out.println(band1);

        System.out.println(MusicBand.transferMembers("G3", 2020, band, band1));

        System.out.println(MusicBand.transferMembers(band.getMembers(), band1.getMembers()));

        band.setMembers(MusicBand.transferMembers(band.getMembers(), band1.getMembers()));
        System.out.println(band);
    }
}
