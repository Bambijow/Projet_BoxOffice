import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Box {

    public Box(String file) throws FileNotFoundException {
        Scanner in = new Scanner(new File(file));

        int nbLine = 0;
        String[] entry;
        while(in.hasNextLine()){
            String l = in.nextLine();
            nbLine++;
            entry = l.split(".FILM : |\tREALISATEUR : |\tANNEE : |\tVILLE : |\tENTREES :");
            Main.afficherFilm(new Film(entry[0], entry[1], Integer.parseInt(entry[2]), Integer.parseInt(entry[4])));
        }
        in.close();
        System.out.println("Nombre de lignes : " + nbLine);
    }

}
