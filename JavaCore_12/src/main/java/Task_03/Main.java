package Task_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<MusicBand> musicBands = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 20; i++) {
            int randVal = random.nextInt(120) + 1900;
            musicBands.add(new MusicBand(new StringBuilder("GroupName_").append(i).toString(), randVal));
        }
        System.out.println(musicBands);
        Collections.shuffle(musicBands);
        System.out.println(musicBands);
        System.out.println(Main.groupAfter2000(musicBands));
    }

    public static List<MusicBand> groupAfter2000(List<MusicBand> bands) {
        List<MusicBand> resArr = new ArrayList<>();
        for (MusicBand band : bands) {
            if (band.getYear() > 2000)
                resArr.add(band);
        }
        return resArr;
    }
}
