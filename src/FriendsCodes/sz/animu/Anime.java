package FriendsCodes.sz.animu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Anime {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");/*
    0         1         2         3         4         5         6         7         8         9
    0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789
    1   V A |012| | 9| Noragami -------------------------------------------------------- 01.05.2016
    1   V A |013| | 8| Noragami Aragoto ------------------------------------------------ 01.05.2016

    index of VIEW marker: 4
    index of anime type: 6
    index of series: 9,10,11. Period: 9 - 12
    index of quality: 15,16. Period: 15-17.*/

    //basic info
    private String name;
    private int series;     //amount of series
    private AnimeType type;
    private boolean shown;  //if shown, all info below is required.
    //info if shown
    private int number;     //the number in shown animes list
    private int quality;
    private Date viewDate;

    private static int biggestNameLength;
    private static int dateFirstIndex;

    public Anime(String name, int series, AnimeType type) {
        this.name = name;
        this.series = series;
        this.type = type;
        this.shown = false;
        checkStatics(name);
    }

    public Anime(String name, int series, AnimeType type, int number, int quality, Date viewDate) {
        this.name = name;
        this.series = series;
        this.type = type;
        this.shown = true;
        this.number = number;
        this.quality = quality;
        this.viewDate = viewDate;
        checkStatics(name);
    }

    public static Anime parse(String source) {
        boolean shown = source.charAt(4) == 'V';
        int series = Integer.parseInt(source.substring(9, 12).trim());
        AnimeType type = AnimeType.get(source.charAt(6));
        String name = source.substring(19, source.indexOf(filledString(3, type.filler))-1);

        if (shown) {
            int number = Integer.parseInt(source.substring(0, 3).trim());
            int quality = Integer.parseInt(source.substring(15, 17).trim());

            int length = source.length();

            Date viewDate = new Date(0);
            try {
                viewDate = DATE_FORMAT.parse(source.substring(length - 10, length));
            } catch (ParseException e) {
                System.err.println("Something went wrong while parsing viewDate!\n" + e.getMessage());
            }
            return new Anime(name, series, type, number, quality, viewDate);
        } else {
            return new Anime(name, series, type);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(filledString(Character.MAX_VALUE, ' '));
        builder.replace(0, 17, "        |   | |  |"); //insert skeleton

        int nameLastIndex = 19 + name.length();
        builder.replace(19, nameLastIndex, name); //insert name
        builder.replace(nameLastIndex + 1, dateFirstIndex - 1,
                filledString(dateFirstIndex - name.length() - 21, type.filler)); //insert line fill
        builder.replace(9, 12, String.format("%03d", series));

        builder.setCharAt(0, '-'); //not shown. Standard.
        builder.setCharAt(6, type.marker); //Anime type marker

        if (shown) {
            builder.replace(0, 3, String.format("%-3d", number));
            builder.replace(15, 17, String.format("%2d", quality));
            builder.replace(dateFirstIndex, dateFirstIndex+10, DATE_FORMAT.format(viewDate));

            builder.setCharAt(4, 'V');
        } else {
            builder.setCharAt(4, 'X');
        }
        return builder.toString().trim();
    }

    private static void checkStatics(String name) {
        if (biggestNameLength < name.length()) {
            biggestNameLength = name.length();
            dateFirstIndex = 19 + biggestNameLength + 5;
        }
    }

    private static String filledString(int amount, char fill) {
        return new String(new char[amount]).replaceAll("\\\0", String.valueOf(fill));
    }
}