package FriendsCodes.sz.animu;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    private static final String fileName = "D:\\Admin\\ani.txt";
    private static final ArrayList<Anime> ANIMES = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        log("Reading a file. Wait...");
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            if (line.startsWith("No") || line.isEmpty())
                continue;
            ANIMES.add(Anime.parse(line));
        }
        fileReader.close();
        log("File reading finished.");

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        log("A command manager has started. Type help for more info");
        while(true) {
            String command = console.readLine();
            switch (command) {
                case "help": {
                    log("help - current list;");
                    log("list - a full list of animes;");
                    log("exit - save a list in file and close the program;");
                    log("add - add a new anime to the and of the list;");
                    log("contains - returns true if a list contains anime titile;");
                } break;
                case "list": {
                    ANIMES.forEach(System.out::println);
                } break;
                case "exit": {
                    exit();
                } break;
                case "add": {
                    log("Shown? (Y/N)");
                    boolean shown = console.readLine().equalsIgnoreCase("Y");

                    log("Name: (String)");
                    String name = console.readLine().trim();

                    log("Type: (F = Film; A = Anime; G = Ongoing; O = OVA; T = Unknown)");
                    AnimeType type = AnimeType.get(console.readLine().charAt(0));

                    int series = 1;
                    if (type != AnimeType.Film) {
                        log("Series: (Integer)");
                        series = Integer.parseInt(console.readLine().trim());
                    }

                    if (shown) {
                        log("Quality: (1-10, Integer)");
                        int quality = Integer.parseInt(console.readLine().trim());
                        log("Date of view: (dd.mm.yyyy)");
                        Date viewDate = Anime.DATE_FORMAT.parse(console.readLine().trim());
                        log("Number in list: (Huh?)");
                        int number = Integer.parseInt(console.readLine().trim());

                        ANIMES.add(new Anime(name, series, type, number, quality, viewDate));
                    } else {
                        ANIMES.add(new Anime(name, series, type));
                    }
                    log("Successfully added. Type list to show a full list of aniems.");
                } break;
            }
        }
    }

    private static void log(String msg) {
        System.out.println(msg);
    }

    private static void exit() throws FileNotFoundException{
        PrintWriter writer = new PrintWriter(fileName);

        writer.println("No      серии ?/10 название");
        ANIMES.forEach(writer::println);

        writer.close();
        log("Successfully wrote a list in file. Path: " + fileName);
        System.exit(0);
    }
}
