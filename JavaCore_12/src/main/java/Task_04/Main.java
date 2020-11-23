package Task_04;

public class Main {
    public static void main(String[] args) {
        MusicBand band = new MusicBand("G1", 1000);
        System.out.println(band);
        band.addMember("John Wolsen");
        System.out.println(band);
        band.addMember("Piter Griffin");
        System.out.println(band);
        band.removeMember("John Wolsen");
        System.out.println(band);


        MusicBand band1 = new MusicBand("G2", 1001);
        band1.addMember("Homer Simpson");
        System.out.println(band1);

        System.out.println(MusicBand.transferMembers("G3", 2020, band, band1));
        System.out.println(MusicBand.transferMembers(band.getMembers(), band1.getMembers()));

        band.setMembers(MusicBand.transferMembers(band.getMembers(), band1.getMembers()));
        System.out.println(band);
    }
}
